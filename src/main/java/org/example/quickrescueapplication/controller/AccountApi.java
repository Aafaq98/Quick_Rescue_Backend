package org.example.quickrescueapplication.controller;


import jakarta.validation.Valid;
import org.example.quickrescueapplication.entity.Account;

import org.example.quickrescueapplication.service.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is a RestController class that provides the API for the Account entity.
 */
@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "*")
public class AccountApi {


    @Autowired
    private AccountManager accountManager;


  //  @GetMapping("/api/account")

    @GetMapping
    public List<Account> getAccount() {
        return accountManager.getAll();
    }

    @PostMapping
    public Account addAccount(@RequestBody @Valid Account account) {
      Account newAccount =  accountManager.add(account);
      return newAccount;
    }

    @PutMapping
    public Account updateAccount(@RequestBody @Valid Account accountDto) {
        Account account = accountManager.update(accountDto);
        return account;
    }

    //delete by id
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
     accountManager.delete(id);
    }


    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        Account account = accountManager.getAccountById(id);
        return account;
    }


}
