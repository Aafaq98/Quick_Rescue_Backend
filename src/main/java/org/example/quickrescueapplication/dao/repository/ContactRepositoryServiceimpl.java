package org.example.quickrescueapplication.dao.repository;


import org.example.quickrescueapplication.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactRepositoryServiceimpl implements ContactRepositoryService{

    @Autowired
    private ContactRepository contactRepository;

    /**
     * This method is used to create contact
     * @param contact
     * @return
     */
    @Override
    public Contact Create(final Contact contact) {
        Contact contactSavedEntity= contactRepository.save(contact);
        return contactSavedEntity;
    }

    /**
     * This method is used to update contact
     * @param contact
     * @return
     */
    @Override
    public Contact update(final Contact contact) {
        Contact updatedContact= contactRepository.save(contact);
        return updatedContact;
    }

    /**
     * This method is used to delete contact
     * @param id
     */
    @Override
    public void delete(final Long id) {
        contactRepository.deleteById(id);
    }

    /**
     * This method is used to find contact
     * @param id
     * @return
     */
    @Override
    public Optional<Contact> find(final Long id) {
        Optional<Contact> contact= contactRepository.findById(id);
        return contact;
    }

    /**
     * This method is used to get contact by id
     * @param id
     * @return
     */
    @Override
    public Contact getById(final Long id) {
        Contact contact= contactRepository.getFirstById(id);
        return contact;
    }

    /**
     * This method is used to get all contacts
     * @param accountId
     * @return
     */
    @Override
    public List<Contact> findAllByAccountId(Long accountId) {
        List<Contact> contacts = contactRepository.findAllByAccountId(accountId);
        return contacts;
    }



}
