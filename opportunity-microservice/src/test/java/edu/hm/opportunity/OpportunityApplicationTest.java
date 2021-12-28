package edu.hm.opportunity;

import edu.hm.opportunity.controller.OpportunityController;
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
class OpportunityApplicationTest {

	@Autowired
	private OpportunityController opportunityController;

	@Test
	void contextLoads() {
		assertThat(opportunityController).isNotNull();
	}

}
