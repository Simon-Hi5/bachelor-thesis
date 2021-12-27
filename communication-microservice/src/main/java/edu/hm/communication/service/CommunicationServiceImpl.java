package edu.hm.communication.service;

import edu.hm.communication.CommunicationApplication;
import edu.hm.communication.common.ResourceNotFoundException;
import edu.hm.communication.persistence.Communication;
import edu.hm.communication.persistence.CommunicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Communication service implementation.
 *
 * @author Simon Hirner
 */
@Service
public class CommunicationServiceImpl implements CommunicationService {

    private static final Logger logger = LoggerFactory.getLogger(CommunicationApplication.class);

    private final CommunicationRepository communicationRepository;

    public CommunicationServiceImpl(CommunicationRepository communicationRepository) {
        this.communicationRepository = communicationRepository;
    }

    @Override
    public List<Communication> getAllCommunications() {
        logger.debug("Find all communications");
        return communicationRepository.findAll();
    }

    @Override
    public Optional<Communication> getCommunication(String id) {
        logger.debug("Find communication {}", id);
        return communicationRepository.findById(id);
    }

    @Override
    public Communication saveCommunication(Communication newCommunication) {
        logger.debug("Save new communication");
        return communicationRepository.save(newCommunication);
    }

    @Override
    public Communication replaceCommunication(String id, Communication newCommunication) {
        logger.debug("Replace communication {}", id);
        return getCommunication(id)
                .map(communication -> {
                    communication.setFirstName(newCommunication.getFirstName());
                    communication.setLastName(newCommunication.getLastName());
                    communication.setGender(newCommunication.getGender());
                    communication.setEmail(newCommunication.getEmail());
                    communication.setDateOfBirth(newCommunication.getDateOfBirth());
                    communication.setPhoneNumber(newCommunication.getPhoneNumber());
                    communication.setAddress(newCommunication.getAddress());
                    return saveCommunication(communication);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public void deleteCommunication(String id) {
        logger.debug("Delete communication {}", id);
        communicationRepository.deleteById(getCommunication(id).orElseThrow(() -> new ResourceNotFoundException(id)).getId());
    }

    @Override
    public void deleteAllCommunications() {
        logger.debug("Delete all communications");
        communicationRepository.deleteAll();
    }

}
