package edu.hm.contact;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Contact API", version = "1.0", description = "Contact Information"))
public class ContactApplication implements CommandLineRunner {

	private final ContactRepository contactRepository;

	public ContactApplication(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// contactRepository.deleteAll();
		// contactRepository.save(new ContactModel("Einkaufen", 1));
		// contactRepository.save(new ContactModel("Seminararbeit erstellen", 2));
	}

}
