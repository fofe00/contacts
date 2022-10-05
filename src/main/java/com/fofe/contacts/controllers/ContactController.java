package com.fofe.contacts.controllers;

import com.fofe.contacts.entities.Contact;
import com.fofe.contacts.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//TODO make this contoller restfull and create another who work with Thymeleaf


@RestController
public class ContactController {
    @Autowired
    ContactService contactService;

    @GetMapping("/contats")
    public List<Contact> getAllContats(){
        return contactService.getAllContats();
    }
    public  List<Contact> getAllContatsWithPaginate(){
        //TODO add pagination
        return  null;
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

    @GetMapping("lastname/{name}")
    public List<Contact> byLastName(@PathVariable("name") String name){
        return contactService.contactsByLastName(name);
    }
    @GetMapping("firstname/{name}")
    public List<Contact> byFirstName(@PathVariable("name") String name){
        return contactService.contactsByFirstName(name);
    }

}
