package edu.hm.opportunity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OpportunityRepository extends MongoRepository<OpportunityModel, String> {

}
