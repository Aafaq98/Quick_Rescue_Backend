package org.example.quickrescueapplication.dao.repository;

import org.example.quickrescueapplication.entity.Login;

import java.util.Optional;

public interface LoginRepositoryService {

    public Login create(final Login login);

    public Login update(final Login login);

    public void delete(final Long id);

    public Optional<Login> find(final Long id);

    public Login getById(final Long id);

    public Login findByUsernameAndPassword(String username, String password);
}
