package org.example.quickrescueapplication.controller;


import org.example.quickrescueapplication.entity.Contact;
import org.example.quickrescueapplication.service.ContactManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactApi {


    @Autowired
    private ContactManager contactManager;


    @PostMapping
    public Contact create(@RequestBody Contact contact) {

      Contact savedContact =  contactManager.create(contact);
      return savedContact;
    }

    @GetMapping("/{id}")
    public Contact get(@PathVariable Long id) {
        Contact contact = contactManager.getById(id);
        return contact;
    }

    @PutMapping
    public Contact update(@RequestBody Contact contact) {
        Contact updatedContact = contactManager.update(contact);
        return updatedContact;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contactManager.delete(id);
    }

    @GetMapping("/account/{accountId}")
    public List<Contact> findByAccountId(@PathVariable Long accountId) {
        return contactManager.findByAccountId(accountId);
    }


}
