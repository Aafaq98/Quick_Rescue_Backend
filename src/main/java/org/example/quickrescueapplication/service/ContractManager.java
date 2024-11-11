package org.example.quickrescueapplication.service;

import org.example.quickrescueapplication.entity.Contact;
import org.example.quickrescueapplication.entity.Contract;

import java.util.List;
import java.util.Optional;

public interface ContractManager {

    public Contract create(final Contract contract);

    public Contract update(final Contract contract);

    public void delete(final Long id);

    public Optional<Contract> find(final Long id);

    public Contract getById(final Long id);

    public Contract findByAccountId(final Long accountId);
}
