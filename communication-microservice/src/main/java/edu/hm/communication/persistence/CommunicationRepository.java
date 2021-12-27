package edu.hm.communication.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository for communications.
 *
 * @author Simon Hirner
 */
public interface CommunicationRepository extends MongoRepository<Communication, String> {

}
