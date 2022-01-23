package edu.hm.opportunity;

import edu.hm.opportunity.persistence.Opportunity;
import edu.hm.opportunity.persistence.Status;
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
        String mongodbHost = System.getenv().getOrDefault("MONGODB_HOST", "localhost");
        logger.info("Environment variable MONGODB_HOST=" + mongodbHost);
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

            Opportunity opportunity1 = new Opportunity(LocalDate.of(2023, Month.JANUARY, 6),
                    Status.PLANNED);
            Opportunity opportunity2 = new Opportunity(LocalDate.of(2022, Month.DECEMBER, 23),
                    120000.0, 130000.0, 8000.0, Status.IN_PROGRESS, "Notiz",
                    "");

            opportunityService.saveOpportunity(opportunity1);
            opportunityService.saveOpportunity(opportunity2);
        } catch (ConstraintViolationException exception) {
            logger.error(exception.getMessage());
        }
    }

}
