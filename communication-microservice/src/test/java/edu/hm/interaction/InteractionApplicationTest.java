package edu.hm.interaction;

import edu.hm.interaction.controller.InteractionController;
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
class InteractionApplicationTest {

	@Autowired
	private InteractionController interactionController;

	@Test
	void contextLoads() {
		assertThat(interactionController).isNotNull();
	}

}
