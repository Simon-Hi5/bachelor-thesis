package edu.hm.opportunity;

import edu.hm.opportunity.persistence.Country;
import edu.hm.opportunity.persistence.Gender;
import edu.hm.opportunity.persistence.Address;
import edu.hm.opportunity.persistence.Opportunity;
import edu.hm.opportunity.service.OpportunityService;
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
 * Opportunity microservice application.
 *
 * @author Simon Hirner
 */
@SpringBootApplication
public class OpportunityApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(OpportunityApplication.class);

    private final OpportunityService opportunityService;

    public OpportunityApplication(OpportunityService opportunityService) {
        this.opportunityService = opportunityService;
    }

    public static void main(String[] args) {
        SpringApplication.run(OpportunityApplication.class, args);
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

            opportunityService.deleteAllOpportunities();

            Address address1 = new Address("Straße 1", "",
                    "80963", "München", Country.GERMANY);
            Opportunity opportunity1 = new Opportunity("Thorsten", "Schlott");
            Opportunity opportunity2 = new Opportunity("Max", "Mustermann", Gender.MALE,
                    LocalDate.of(1999, Month.JULY, 23), "test@test.de",
                    "+49012940323", address1);

            opportunityService.saveOpportunity(opportunity1);
            opportunityService.saveOpportunity(opportunity2);
        } catch (ConstraintViolationException exception) {
            logger.error(exception.getMessage());
        }
    }

}
