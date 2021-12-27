package edu.hm.communication;

import edu.hm.communication.controller.CommunicationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Smoke test.
 *
 * @author Simon Hirner
 */
@SpringBootTest
class CommunicationApplicationTests {

	@Autowired
	private CommunicationController communicationController;

	@Test
	void contextLoads() {
		assertThat(communicationController).isNotNull();
	}

}
