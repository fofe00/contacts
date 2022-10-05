package com.fofe.contacts.controllers;

import com.fofe.contacts.entities.Contact;
import com.fofe.contacts.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//TODO make this contoller restfull and create another who work with Thymeleaf


@RestController
@RequestMapping("/api/contact")
public class ContactController {
    @Autowired
    ContactService contactService;

    @GetMapping("/")
    public List<Contact> getAllContacts(@RequestParam(name = "first",defaultValue = "",required = false) String firstName,
                                       @RequestParam(name = "last",defaultValue = "",required = false) String lastName){
        System.out.println(firstName);
        if (!firstName.isEmpty() && !lastName.isEmpty()){
            return contactService.findContactsByLastNameContainsAndFirstNameContains(firstName,lastName);
        }else if(!firstName.isEmpty()){
            return contactService.contactsByFirstName(firstName);
        }else {
            return  contactService.contactsByLastName(lastName);
        }
    }

    @GetMapping("/paginate/")
    public  List<Contact> getAllContactsWithPaginate(){
        //TODO add pagination
        return  null;
    }
    @GetMapping("/{id}")
    public Optional<Contact> getContact(@PathVariable("id") Long id){
        System.out.println(id);
        return contactService.getOne(id);
    }

    @PostMapping("/")
    public String addContact(@RequestBody Contact contact){
        contactService.save(contact);
        return "otk";
    }
    @PutMapping("/")
    public String updateContact(@RequestBody Contact contact){
        contactService.update(contact);
        return "ok";
    }
    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable("id") Long id){
        contactService.delete(id);
        return  "delete ok";
    }

}
