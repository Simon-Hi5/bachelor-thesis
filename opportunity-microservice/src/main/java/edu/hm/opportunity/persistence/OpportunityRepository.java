package edu.hm.opportunity.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Repository for opportunities.
 *
 * @author Simon Hirner
 */
public interface OpportunityRepository extends MongoRepository<Opportunity, String> {
    List<Opportunity> findAllByOrderByEstimatedCloseDateAscIdAsc();
}
