package edu.hm.communication;

import edu.hm.communication.persistence.Country;
import edu.hm.communication.persistence.Gender;
import edu.hm.communication.persistence.Address;
import edu.hm.communication.persistence.Communication;
import edu.hm.communication.service.CommunicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.time.Month;

/**
 * Communication microservice application.
 *
 * @author Simon Hirner
 */
@SpringBootApplication
public class CommunicationApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CommunicationApplication.class);

    private final CommunicationService communicationService;

    public CommunicationApplication(CommunicationService communicationService) {
        this.communicationService = communicationService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CommunicationApplication.class, args);
    }

    @Override
    public void run(String... args) {
        initializeDatabase();
    }

    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

    private void initializeDatabase() {
        try {
            logger.info("Initialize database");

            communicationService.deleteAllCommunications();

            Address address1 = new Address("Straße 1", "",
                    "80963", "München", Country.GERMANY);
            Communication communication1 = new Communication("Thorsten", "Schlott");
            Communication communication2 = new Communication("Max", "Mustermann", Gender.MALE,
                    LocalDate.of(1999, Month.JULY, 23), "test@test.de",
                    "+49012940323", address1);

            communicationService.saveCommunication(communication1);
            communicationService.saveCommunication(communication2);
        } catch (ConstraintViolationException exception) {
            logger.error(exception.getMessage());
        }
    }

}
