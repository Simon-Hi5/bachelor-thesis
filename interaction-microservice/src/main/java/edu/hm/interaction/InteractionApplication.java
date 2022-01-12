package edu.hm.interaction;

import edu.hm.interaction.persistence.FormOfInteraction;
import edu.hm.interaction.persistence.Interaction;
import edu.hm.interaction.service.InteractionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * Interaction microservice application.
 *
 * @author Simon Hirner
 */
@SpringBootApplication
public class InteractionApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InteractionApplication.class);

    private final InteractionService interactionService;

    public InteractionApplication(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    public static void main(String[] args) {
        SpringApplication.run(InteractionApplication.class, args);
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

            interactionService.deleteAllInteractions();

            Interaction interaction1 = new Interaction(FormOfInteraction.EMAIL, "123456",LocalDateTime.of(2020, Month.JUNE, 12, 8,30));
            Interaction interaction2 = new Interaction(FormOfInteraction.PHONE, "Notiz","101010",LocalDateTime.of(2020, Month.JUNE, 12, 8,30));

            interactionService.saveInteraction(interaction1);
            interactionService.saveInteraction(interaction2);
        } catch (ConstraintViolationException exception) {
            logger.error(exception.getMessage());
        }
    }

}
