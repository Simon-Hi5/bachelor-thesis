package edu.hm.contact.controller;

import edu.hm.contact.ContactApplication;
import edu.hm.contact.common.BadRequestException;
import edu.hm.contact.common.ResourceNotFoundException;
import edu.hm.contact.persistence.Contact;
import edu.hm.contact.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactApplication.class);

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    List<Contact> findAllContact() {
        logger.debug("GET /contacts");
        return contactService.findContacts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Contact newContact(@RequestBody Contact newContact) {
        logger.debug("POST /contacts");
        try {
            return contactService.saveContact(newContact);
        } catch (ConstraintViolationException exception) {
            throw new BadRequestException(exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    Contact findByIdContact(@PathVariable String id) {
        logger.debug("GET /contacts/{}", id);
        return contactService.findContact(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @PutMapping("/{id}")
    Contact replaceContact(@RequestBody Contact newContact, @PathVariable String id) {
        logger.debug("PUT /contacts/{}", id);
        return contactService.replaceContact(id, newContact);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteContact(@PathVariable String id) {
        logger.debug("DELETE /contacts/{}", id);
        contactService.deleteContact(id);
    }

}

