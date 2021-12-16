package edu.hm.opportunity;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Opportunity API", version = "1.0", description = "Opportunity Information"))
public class OpportunityApplication implements CommandLineRunner {

	private final OpportunityRepository opportunityRepository;

	public OpportunityApplication(OpportunityRepository opportunityRepository) {
		this.opportunityRepository = opportunityRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(OpportunityApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// opportunityRepository.deleteAll();
		// opportunityRepository.save(new OpportunityModel("Einkaufen", 1));
		// opportunityRepository.save(new OpportunityModel("Seminararbeit erstellen", 2));
	}

}
