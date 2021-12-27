package edu.hm.communication.controller;

import edu.hm.communication.service.CommunicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for communication controller.
 *
 * @author Simon Hirner
 */
@WebMvcTest(CommunicationController.class)
public class CommunicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommunicationService communicationService;

    @Test
    public void communicationsShouldReturnOK() throws Exception {
        mockMvc.perform(get("/communications")).andExpect(status().isOk());
    }

    @Test
    public void communicationsShouldReturnf() throws Exception {
        mockMvc.perform(get("/communications/1")).andExpect(status().isNotFound());
    }

}
