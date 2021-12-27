package edu.hm.opportunity.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository for opportunities.
 *
 * @author Simon Hirner
 */
public interface OpportunityRepository extends MongoRepository<Opportunity, String> {

}
