package edu.hm.contact.service;

import edu.hm.contact.ContactApplication;
import edu.hm.contact.common.ResourceNotFoundException;
import edu.hm.contact.persistence.AddressRepository;
import edu.hm.contact.persistence.Contact;
import edu.hm.contact.persistence.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    private static final Logger logger = LoggerFactory.getLogger(ContactApplication.class);

    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;

    public ContactServiceImpl(ContactRepository contactRepository, AddressRepository addressRepository) {
        this.contactRepository = contactRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Contact> findContacts() {
        logger.debug("Find all contacts");
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> findContact(String id) {
        logger.debug("Find contact {}", id);
        return contactRepository.findById(id);
    }

    @Override
    public Contact saveContact(Contact newContact) {
        logger.debug("Save new contact");
        addressRepository.save(newContact.getAddress());
        return contactRepository.save(newContact);
    }

    @Override
    public Contact replaceContact(String id, Contact newContact) {
        logger.debug("Replace contact {}", id);
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

    @Override
    public void deleteContact(String id) {
        logger.debug("Delete contact {}", id);
        String addressId = contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id)).getAddress().getId();
        if (contactRepository.countAllByAddress_Id(addressId) > 1) {
            addressRepository.deleteById(addressId);
        }
        contactRepository.deleteById(id);
    }

}
