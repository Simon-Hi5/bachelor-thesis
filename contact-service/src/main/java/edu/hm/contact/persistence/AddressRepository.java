package edu.hm.contact.persistence;

import edu.hm.contact.persistence.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {

}