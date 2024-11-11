package org.example.quickrescueapplication.dao.repository;

import org.example.quickrescueapplication.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This interface is used to manage the account repository
 */
@Service
public class AccountRepositoryServiceImpl implements AccountRepositoryService{

    @Autowired
    private AccountRepository accountRepository;


    /**
     * This method is used to create an account
     * @param account
     * @return
     */

    @Override
    public Account create(final Account account) {
       Account accountSavedEntity= accountRepository.save(account);
        return accountSavedEntity;
    }


    /**
     * This method is used to update an account
     * @param account
     * @return
     */
    @Override
    public Account update(final Account account) {
       Account updatedAccount= accountRepository.save(account);
        return updatedAccount;
    }


    /**
     * This method is used to delete an account
     * @param id
     */
    @Override
    public void delete(final Long id) {
        accountRepository.deleteById(id);
    }

    /**
     * This method is used to find an account
     * @param id
     * @return
     */
    @Override
    public Optional<Account> find(Long id) {
     Optional<Account> account= accountRepository.findById(id);
     return account;
    }

    /**
     * This method is used to get an account by id
     * @param id
     * @return
     */
    @Override
    public Account getById(Long id) {
        Account account=accountRepository.getFirstById(id);
        return account;
    }

    /**
     * This method is used to get all accounts
     * @return
     */
    @Override
    public List<Account> getAll() {
      return   accountRepository.findAll();

    }


}
