package com.fofe.contacts.controllers;

import com.fofe.contacts.entities.Contact;
import com.fofe.contacts.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContactController {
    @Autowired
    ContactService contactService;

    @GetMapping("/contats")
    public List<Contact> getAllContats(){
        return contactService.getAllContats();
    }
    @GetMapping("/contact/{id}")
    public Optional<Contact> getContact(@PathVariable("id") Long id){
        System.out.println(id);
        return contactService.getOne(id);
    }

    @PostMapping("/contact/save")
    public String addContact(@RequestBody Contact contact){
        contactService.save(contact);
        return "otk";
    }
    @PutMapping("/contact/update")
    public String updateContact(@RequestBody Contact contact){
        contactService.update(contact);
        return "ok";
    }
    @DeleteMapping("contact/delete/{id}")
    public String deleteContact(@PathVariable("id") Long id){
        contactService.delete(id);
        return  "offk";
    }

    @GetMapping("contact/name/{name}")
    public List<Contact> byName(@PathVariable("name") String name){
        return contactService.contactsByName(name);
    }

}
