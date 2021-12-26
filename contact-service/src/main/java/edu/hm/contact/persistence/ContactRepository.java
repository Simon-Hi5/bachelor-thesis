package edu.hm.contact.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends MongoRepository<Contact, String> {

    List<Contact> findAllByLastNameContains(@Param("lastName") String lastName);

    int countAllByAddress_Id(@Param("addressId") String addressId);

}
