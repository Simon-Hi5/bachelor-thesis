package edu.hm.contact;

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

    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;

    public ContactController(ContactRepository contactRepository, AddressRepository addressRepository) {
        this.contactRepository = contactRepository;
        this.addressRepository = addressRepository;
    }

    @GetMapping
    List<Contact> findAllContact() {
        logger.debug("findAllContact: GET /contacts");
        return contactRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Contact newContact(@RequestBody Contact newContact) {
        logger.debug("newContact: POST /contacts");
        try {
            addressRepository.save(newContact.getAddress());
            return contactRepository.save(newContact);
        } catch (ConstraintViolationException exception) {
            throw new BadRequestException(exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    Contact findByIdContact(@PathVariable String id) {
        logger.debug("findByIdContact: GET /contacts/{}", id);
        return contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @PutMapping("/{id}")
    Contact replaceContact(@RequestBody Contact newContact, @PathVariable String id) {
        return contactRepository.findById(id)
                .map(contact -> {
                    contact.setFirstName(newContact.getFirstName());
                    contact.setLastName(newContact.getLastName());
                    contact.setGender(newContact.getGender());
                    contact.setEmail(newContact.getEmail());
                    contact.setDateOfBirth(newContact.getDateOfBirth());
                    contact.setPhoneNumber(newContact.getPhoneNumber());
                    contact.setAddress(newContact.getAddress());
                    return contactRepository.save(contact);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteContact(@PathVariable String id) {
        logger.debug("deleteContact: DELETE /contacts/{}", id);
        contactRepository.deleteById(id);
    }

}

@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFoundException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(ResourceNotFoundException.class);

    ResourceNotFoundException(String id) {
        super("Could not find resource: " + id);
        logger.error(this.getMessage());
    }

}

@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadRequestException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(BadRequestException.class);

    BadRequestException(String message) {
        super(message);
        logger.error(this.getMessage());
    }

}
