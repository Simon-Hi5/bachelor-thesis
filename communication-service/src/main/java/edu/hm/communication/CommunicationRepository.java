package edu.hm.communication;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommunicationRepository extends MongoRepository<CommunicationModel, String> {

}
