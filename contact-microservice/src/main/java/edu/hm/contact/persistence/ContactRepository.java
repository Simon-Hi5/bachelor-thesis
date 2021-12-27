package edu.hm.contact.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository for contacts.
 *
 * @author Simon Hirner
 */
public interface ContactRepository extends MongoRepository<Contact, String> {

}
