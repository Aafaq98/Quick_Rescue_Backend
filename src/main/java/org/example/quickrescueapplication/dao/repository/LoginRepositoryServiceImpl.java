package org.example.quickrescueapplication.dao.repository;


import org.example.quickrescueapplication.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginRepositoryServiceImpl implements  LoginRepositoryService{

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login create(Login login) {
        return loginRepository.save(login);

    }

    @Override
    public Login update(Login login) {
        Login updatedLogin = loginRepository.save(login);
        return updatedLogin;

    }

    @Override
    public void delete(Long id) {
     loginRepository.deleteById(id);
    }

    @Override
    public Optional<Login> find(Long id) {
     Optional<Login> login =  loginRepository.findById(id);
     return login;
    }

    @Override
    public Login getById(Long id) {
         return loginRepository.getFirstById(id);
    }

    @Override
    public Login findByUsernameAndPassword(String username, String password) {
        Login login = loginRepository.findByUsernameAndPassword(username, password);
        return login;
    }


}
