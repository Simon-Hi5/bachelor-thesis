package edu.hm.interaction.service;

import edu.hm.interaction.persistence.Interaction;

import java.util.List;
import java.util.Optional;

/**
 * Interface for interaction service.
 *
 * @author Simon Hirner
 */
public interface InteractionService {

    List<Interaction> getAllInteractions();

    Optional<Interaction> getInteraction(String id);

    Interaction saveInteraction(Interaction newInteraction);

    Interaction replaceInteraction(String id, Interaction newInteraction);

    void deleteInteraction(String id);

    void deleteAllInteractions();
}
