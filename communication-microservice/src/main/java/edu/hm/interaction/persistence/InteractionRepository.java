package edu.hm.interaction.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository for interactions.
 *
 * @author Simon Hirner
 */
public interface InteractionRepository extends MongoRepository<Interaction, String> {

}
