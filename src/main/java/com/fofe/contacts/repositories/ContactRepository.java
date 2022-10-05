package com.fofe.contacts.repositories;

import com.fofe.contacts.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ContactRepository extends JpaRepository<Contact,Long> {
    List<Contact> findContactsByLastNameContains(String lastName);
    List<Contact> findContactsByFirstNameContains(String lastName);
    List<Contact> findContactsByLastNameContainsAndFirstNameContains(String lastName,String name);
}
