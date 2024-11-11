package org.example.quickrescueapplication.dao.repository;

import org.example.quickrescueapplication.entity.Account;

import java.util.List;
import java.util.Optional;


/**
 * This interface provides the repository service for the Account entity.
 */
public interface AccountRepositoryService {

    public Account create(final Account account);

    public Account update(final Account account);

    public void delete(final Long id);

    public Optional<Account> find(final Long id);

    public Account getById(final Long id);

    public List<Account> getAll();


}
