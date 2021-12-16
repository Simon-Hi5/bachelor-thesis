package edu.hm.communication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Communication API", version = "1.0", description = "Communication Information"))
public class CommunicationApplication implements CommandLineRunner {

	private final CommunicationRepository communicationRepository;

	public CommunicationApplication(CommunicationRepository communicationRepository) {
		this.communicationRepository = communicationRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CommunicationApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// communicationRepository.deleteAll();
		// communicationRepository.save(new CommunicationModel("Einkaufen", 1));
		// communicationRepository.save(new CommunicationModel("Seminararbeit erstellen", 2));
	}

}
