package org.example.quickrescueapplication.dao.repository;

import org.example.quickrescueapplication.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactRepositoryService {

    public Contact Create(Contact contact);

    public Contact update(Contact contact);

    public void delete(Long id);


    public Optional<Contact> find(Long id);

    public Contact getById(Long id);

    public List<Contact> findAllByAccountId(Long accountId);




}
