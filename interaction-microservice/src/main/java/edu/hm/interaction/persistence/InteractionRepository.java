package edu.hm.interaction.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Repository for interactions.
 *
 * @author Simon Hirner
 */
public interface InteractionRepository extends MongoRepository<Interaction, String> {
    List<Interaction> findAllByOrderByDateAndTimeDescIdDesc();
}
