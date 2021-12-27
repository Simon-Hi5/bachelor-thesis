package edu.hm.contact.controller;

import edu.hm.contact.service.ContactService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContactController.class)
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactService;

    @Test
    public void contactsShouldReturnOK() throws Exception {
        mockMvc.perform(get("/contacts")).andExpect(status().isOk());
    }

    @Test
    public void contactsShouldReturnf() throws Exception {
        mockMvc.perform(get("/contacts/1")).andExpect(status().isNotFound());
    }

}
