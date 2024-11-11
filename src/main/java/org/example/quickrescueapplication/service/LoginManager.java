package org.example.quickrescueapplication.service;

import org.example.quickrescueapplication.entity.Login;

public interface LoginManager {

    public Login create(Login login);

    public Login update(Login login);

    public Login findByUsernameAndPassword(String username, String password);

    public Login getById(Long id);

    public void delete(Long id);

    public Login find(Long id);

}
