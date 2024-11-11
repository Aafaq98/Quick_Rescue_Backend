package org.example.quickrescueapplication.service;

import org.example.quickrescueapplication.entity.Account;
import org.example.quickrescueapplication.dao.repository.AccountRepositoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountManagerImpl implements AccountManager{


    @Autowired
    private AccountRepositoryService accountRepositoryService;

    /**
     * This method is used to add an account
     * @param account
     * @return
     */
    public Account add(final Account account) {
      Account savedAccount = accountRepositoryService.create(account);
       return savedAccount;
    }

    /**
     * This method is used to get an account by id
     * @param id
     * @return
     */
    @Override
    public Account getAccountById(Long id) {
       Account account=accountRepositoryService.getById(id);
        return account;
    }

    /**
     * This method is used to update an account
     * @param account
     * @return
     */
    @Override
    public Account update(Account account) {
        Account updatedAccount = accountRepositoryService.update(account);
        return updatedAccount;
    }

    /**
     * This method is used to delete an account
     * @param id
     */
    @Override
    public void delete(Long id) {
        accountRepositoryService.delete(id);
    }

    /**
     * This method is used to get all accounts
     * @return
     */
    @Override
    public List<Account> getAll() {
        return accountRepositoryService.getAll();
    }


}
