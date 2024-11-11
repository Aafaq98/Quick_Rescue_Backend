package org.example.quickrescueapplication.service;



import org.example.quickrescueapplication.entity.Account;

import java.util.List;

public interface AccountManager {

    /**
     * This method is used to add an account
     * @param account
     * @return
     */
    public Account add(Account account);

    /**
     * This method is used to get an account by id
     * @param id
     * @return
     */
    public Account getAccountById(Long id);

    /**
     * This method is used to update an account
     * @param account
     * @return
     */
    public Account update(Account account);

    /**
     * This method is used to delete an account
     * @param id
     */
    public void delete(Long id);

    /**
     * This method is used to get all accounts
     * @return
     */
    public List<Account> getAll();

}
