package edu.hm.communication.service;

import edu.hm.communication.persistence.Communication;

import java.util.List;
import java.util.Optional;

/**
 * Interface for communication service.
 *
 * @author Simon Hirner
 */
public interface CommunicationService {

    List<Communication> getAllCommunications();

    Optional<Communication> getCommunication(String id);

    Communication saveCommunication(Communication newCommunication);

    Communication replaceCommunication(String id, Communication newCommunication);

    void deleteCommunication(String id);

    void deleteAllCommunications();
}
