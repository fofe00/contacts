package com.fofe.contacts.services;

import com.fofe.contacts.entities.Contact;
import com.fofe.contacts.repositories.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ContactService {
    private ContactRepository contactRepository;
    public List<Contact> getAllContats(){
        return  contactRepository.findAll();
    }

    public Optional <Contact> getOne(long id) {
        return contactRepository.findById(id);
    }
    public void save(Contact contact){
        contactRepository.save(contact);
    }
    public Contact update(Contact contact){
        return contactRepository.save(contact);
    }
    public void  delete(long id){
        contactRepository.deleteById(id);
    }
    public List<Contact> contactsByName(String name){
       return contactRepository.findContactsByLastName(name);
    }
}
