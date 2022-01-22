package edu.hm.interaction.service;

import edu.hm.interaction.InteractionApplication;
import edu.hm.interaction.common.BadRequestException;
import edu.hm.interaction.common.ResourceNotFoundException;
import edu.hm.interaction.persistence.Interaction;
import edu.hm.interaction.persistence.InteractionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

/**
 * Interaction service implementation.
 *
 * @author Simon Hirner
 */
@Service
public class InteractionServiceImpl implements InteractionService {

    private static final Logger logger = LoggerFactory.getLogger(InteractionApplication.class);

    private final InteractionRepository interactionRepository;

    public InteractionServiceImpl(InteractionRepository interactionRepository) {
        this.interactionRepository = interactionRepository;
    }

    @Override
    public List<Interaction> getAllInteractions() {
        logger.debug("Find all interactions");
        return interactionRepository.findAll();
    }

    @Override
    public Optional<Interaction> getInteraction(String id) {
        logger.debug("Find interaction {}", id);
        return interactionRepository.findById(id);
    }

    @Override
    public Interaction saveInteraction(Interaction newInteraction) {
        logger.debug("Verify contact ID");
        String contactService = System.getenv().getOrDefault("CONTACT_SERVICE", "localhost");
        String contactApi = "http://" + contactService + "/contacts/" + newInteraction.getRelatedContactId();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(contactApi, String.class);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            logger.debug("Save new interaction");
            return interactionRepository.save(newInteraction);
        } else if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            throw new BadRequestException("Contact ID is invalid");
        } else {
            throw new BadRequestException("Contact ID could not be verified");
        }
    }

    @Override
    public Interaction replaceInteraction(String id, Interaction newInteraction) {
        logger.debug("Replace interaction {}", id);
        return getInteraction(id)
                .map(interaction -> {
                    interaction.setNote(newInteraction.getNote());
                    interaction.setRelatedContactId(newInteraction.getRelatedContactId());
                    interaction.setDateAndTime(newInteraction.getDateAndTime());
                    interaction.setFormOfInteraction(newInteraction.getFormOfInteraction());
                    return saveInteraction(interaction);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public void deleteInteraction(String id) {
        logger.debug("Delete interaction {}", id);
        interactionRepository.deleteById(getInteraction(id).orElseThrow(() -> new ResourceNotFoundException(id)).getId());
    }

    @Override
    public void deleteAllInteractions() {
        logger.debug("Delete all interactions");
        interactionRepository.deleteAll();
    }

}
