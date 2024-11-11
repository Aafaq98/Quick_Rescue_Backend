package org.example.quickrescueapplication.service;

import org.example.quickrescueapplication.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactManager {

    public Contact create(final Contact contact);

    public Contact update(final Contact contact);

    public void delete(final Long id);

    public Optional<Contact> find(final Long id);

    public Contact getById(final Long id);

    public List<Contact> findByAccountId(final Long accountId);
}
