package org.example.quickrescueapplication.service;

import org.example.quickrescueapplication.dao.repository.LoginRepositoryService;
import org.example.quickrescueapplication.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginManagerImpl implements LoginManager {

    @Autowired
    private LoginRepositoryService loginRepositoryService;

    /**
     *  This method is used to create a login
     * @param login
     * @return
     */
    @Override
    public Login create(Login login) {
        Login savedLogin = loginRepositoryService.create(login);
        return savedLogin;
    }

    /**
     * This method is used to update a login
     * @param login
     * @return
     */
    @Override
    public Login update(Login login) {
        Login updatedLogin = loginRepositoryService.update(login);
        return updatedLogin;
    }

    /**
     * This method is used to find a login
     * @param username
     * @param password
     * @return
     */
    @Override
    public Login findByUsernameAndPassword(final String username, String password) {
        Login login = loginRepositoryService.findByUsernameAndPassword(username, password);
        return login;
    }

    @Override
    public Login getById(Long id) {
        Login login = loginRepositoryService.getById(id);
        return login;
    }

    @Override
    public void delete(Long id) {
    loginRepositoryService.delete(id);
    }

    @Override
    public Login find(Long id) {
        if( loginRepositoryService.find(id).isPresent())
        {
            return loginRepositoryService.find(id).get();
        };
        return null;
    }
}
