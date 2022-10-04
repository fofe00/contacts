package com.fofe.contacts.controllers;

import com.fofe.contacts.entities.Contact;
import com.fofe.contacts.services.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/web")
public class ContactWebController {
    private ContactService contactService;
    @GetMapping("/contacts")
    public String getAllContacts(){
        //TODO call service
        //-pass data to view
        return "contact_list";
    }
    @GetMapping("/contact/{id}")
    public String getOneContact(@PathVariable("id") Long id){
        //TODO call service
        //- pass data to view and return view
        return "contat";
    }
    public String createForm(){
        //TODO return form file
        return "create_form";
    }
    @PostMapping("/update/{id}")
    public String update_form(@PathVariable("id") Long id, Contact contact){
        //TODO return update form view
        return "update_form";
    }

    public void saveContact(Contact contact){
        //Todo call service to save data
        // redirect user to list funcion
    }

}
