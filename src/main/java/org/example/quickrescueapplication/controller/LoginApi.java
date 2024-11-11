package org.example.quickrescueapplication.controller;


import jakarta.validation.Valid;
import org.example.quickrescueapplication.common.Login.LoginModel;
import org.example.quickrescueapplication.entity.Login;
import org.example.quickrescueapplication.service.LoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
// allow all

@CrossOrigin(origins = "*")
public class LoginApi {

    @Autowired
    private LoginManager loginManager;

    @PostMapping
    public Login create(Login login){
        return loginManager.create(login);
    }

    @PostMapping("/userlogin")
    public Login findByUsernameAndPassword(@RequestBody @Valid LoginModel loginModel){
        return loginManager.findByUsernameAndPassword(loginModel.getUsername(), loginModel.getPassword());
    }

    @PutMapping
    public Login update(Login login){
        return loginManager.update(login);
    }

    @GetMapping("/{id}")
    public Login find(@PathVariable Long id){
        Login login= loginManager.find(id);
        if(login==null){
            throw new IllegalArgumentException("Login not found for id: "+id);
        }
        return login;
    }



}
