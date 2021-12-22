package edu.hm.contact;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
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

@SpringBootApplication
public class ContactApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ContactApplication.class);

    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;

    public ContactApplication(ContactRepository contactRepository, AddressRepository addressRepository) {
        this.contactRepository = contactRepository;
        this.addressRepository = addressRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ContactApplication.class, args);
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
            contactRepository.deleteAll();
            addressRepository.deleteAll();

            Address address1 = new Address("Straße 1", "",
                    "80963", "München", Country.GERMANY);
            Contact contact1 = new Contact("Thorsten", "Schlott");
            Contact contact2 = new Contact("Max", "Mustermann", Gender.MALE,
                    LocalDate.of(1999, Month.JULY, 23), "test@test.de",
                    "+49012940323", address1);

            addressRepository.save(address1);
            contactRepository.save(contact1);
            contactRepository.save(contact2);
        } catch (ConstraintViolationException exception) {
            logger.error(exception.getMessage());
        }
    }

}
