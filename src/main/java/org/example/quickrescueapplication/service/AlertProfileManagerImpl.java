package org.example.quickrescueapplication.service;

import org.example.quickrescueapplication.common.exception.ResourceNotFoundException;
import org.example.quickrescueapplication.dao.repository.AccountRepositoryService;
import org.example.quickrescueapplication.dao.repository.AlertProfileRepository;
import org.example.quickrescueapplication.dao.repository.AlertProfileRepositoryService;
import org.example.quickrescueapplication.entity.Account;
import org.example.quickrescueapplication.entity.AlertProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AlertProfileManagerImpl implements AlertProfileManager {

    @Autowired
    AlertProfileRepositoryService alertProfileRepositoryService;

    @Autowired
    AccountRepositoryService accountRepositoryService;

    /**
     * This method is used to create an alert profile
     * @param alertProfile
     * @return
     */
    @Override
    public AlertProfile create(final AlertProfile alertProfile) {
        // check if account exists
        Optional<Account> account= checkAccount(alertProfile.getAccount().getId());

        if (!account.isPresent()) {
            throw new ResourceNotFoundException("Account not found");
        }
        AlertProfile savedAlertProfile = alertProfileRepositoryService.create(alertProfile);
        return savedAlertProfile;
    }

    /**
     * This method is used to update an alert profile
     * @param alertProfile
     * @return
     */
    @Override
    public AlertProfile update(final AlertProfile alertProfile) {
        Optional<Account> account= checkAccount(alertProfile.getAccount().getId());

        if (!account.isPresent()) {
            throw new ResourceNotFoundException("Account not found");
        }

        AlertProfile updatedAlertProfile = alertProfileRepositoryService.update(alertProfile);
        return updatedAlertProfile;

    }


    /**
     * This method is used to delete an alert profile
     * @param id
     */
    @Override
    public void delete(Long id) {
        alertProfileRepositoryService.delete(id);
    }


    /**
     * This method is used to find an alert profile
     * @param id
     * @return
     */
    @Override
    public Optional<AlertProfile> find(Long id) {
        Optional<AlertProfile> alertProfile = alertProfileRepositoryService.find(id);
        return alertProfile;
    }

    /**
     * This method is used to get an alert profile by id
     * @param id
     * @return
     */
    @Override
    public AlertProfile getById(Long id) {
        AlertProfile alertProfile = alertProfileRepositoryService.getById(id);
        return alertProfile;
    }

    /**
     * This method is used to get all alert profiles
     * @param accountId
     * @return
     */
    @Override
    public List<AlertProfile> findAllByAccountId(Long accountId) {
        List<AlertProfile> alertProfiles = alertProfileRepositoryService.findAllByAccountId(accountId);
        return  alertProfiles;
    }

    /**
     *  This method is used to check if account exists
     * @param id
     * @return
     */
    private Optional<Account> checkAccount(Long id){
        Optional<Account> account = accountRepositoryService.find(id);
         return account;
    }
}
