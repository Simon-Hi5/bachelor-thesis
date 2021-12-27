package edu.hm.contact;

import edu.hm.contact.controller.ContactController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ContactApplicationTests {

	@Autowired
	private ContactController contactController;

	@Test
	void contextLoads() {
		assertThat(contactController).isNotNull();
	}

}
