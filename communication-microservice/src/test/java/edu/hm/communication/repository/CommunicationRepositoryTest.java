package edu.hm.communication.repository;

import edu.hm.communication.persistence.Communication;
import edu.hm.communication.persistence.CommunicationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for communication repository.
 *
 * @author Simon Hirner
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunicationRepositoryTest {

    private CommunicationRepository communicationRepository;

    @Autowired
    public void setRepository(CommunicationRepository communicationRepository) {
        this.communicationRepository = communicationRepository;
    }

    @Test
    public void createCommunication() {
        Communication communication = new Communication("Vorname", "Nachname");
        assertEquals(communication, communicationRepository.save(communication));
    }

    @Test
    public void findAllCommunications() {
        List<Communication> communication = communicationRepository.findAll();
        assertTrue(!communication.isEmpty());
    }

}
