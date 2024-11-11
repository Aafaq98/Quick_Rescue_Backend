package org.example.quickrescueapplication.service;

import org.example.quickrescueapplication.common.CommonUtils;
import org.example.quickrescueapplication.common.constant.Role;
import org.example.quickrescueapplication.dao.repository.*;
import org.example.quickrescueapplication.entity.Account;
import org.example.quickrescueapplication.entity.AlertProfile;
import org.example.quickrescueapplication.entity.Contact;
import org.example.quickrescueapplication.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ContactManagerImpl implements ContactManager{

    @Autowired
    private AccountRepositoryService accountRepositoryService;

    @Autowired
    private ContactRepositoryService contactRepositoryService;

    @Autowired
    private LoginRepositoryService loginRepositoryService;

    @Autowired
    private AlertProfileRepositoryService alertProfileRepositoryService;



    final static String company="QuickRescue";

    /**
     *  This method is used to create a contact
     * @param contact
     * @return
     */
    @Override
    public Contact create(Contact contact) {
        Optional<Account> account = accountRepositoryService.find(contact.getAccount().getId());
        if (account.isPresent()) {
            String accountEmailDomain = getEmailDomain(account.get().getEmailDomain());
            String contactEmailDomain = getEmailDomain(contact.getEmail()); 

            if (!contactEmailDomain.equals(accountEmailDomain)) {
                throw new IllegalArgumentException("Contact email domain does not match account email domain.");
            }
          if(account.get().getName().equals(company))
          {
              contact.setRole(Role.ADMIN);
          }
          else {
                contact.setRole(Role.CONTACT);
          }


            ValidateWithAlertProfileLocation(contact);

            // Save the contact
            Contact savedContact = contactRepositoryService.Create(contact);

            // Create a login if hasLogin is true
            if (contact.getHasLogin()) {
               // String password = PasswordGenerator.generateRandomPassword();
                String password = CommonUtils.generateRandomPassword();
                Login login = new Login();

                login.setUsername(contact.getEmail());
                login.setPassword(password);
                login.setContact(savedContact);

                // Save the login
                loginRepositoryService.create(login);
                // Optionally log or email the password to the contact/admin (not shown here for security reasons)
                System.out.println("Generated login for contact with username: " + login.getUsername() + " and password: " + login.getPassword());
            }
            return savedContact;
        } else {
            throw new IllegalArgumentException("Account not found for the contact.");
        }
    }


    @Override
    public Contact update(Contact contact) {
        Optional<Account> account = accountRepositoryService.find(contact.getAccount().getId());
        if (account.isPresent()) {
            String accountEmailDomain = getEmailDomain(account.get().getEmailDomain());
            String contactEmailDomain = getEmailDomain(contact.getEmail());

            if (!contactEmailDomain.equals(accountEmailDomain)) {
                throw new IllegalArgumentException("Contact email domain does not match account email domain.");
            }
            Contact updatedContact = contactRepositoryService.update(contact);
            return updatedContact;
        }
        else {
            throw new IllegalArgumentException("Account not found for the contact.");
        }
    }

    @Override
    public void delete(final Long id) {
        contactRepositoryService.delete(id);
    }

    @Override
    public Optional<Contact> find(final Long id) {
        Optional<Contact> contact = contactRepositoryService.find(id);
        return contact;
    }

    @Override
    public Contact getById(final Long id) {
        Contact contact = contactRepositoryService.getById(id);
        return contact;
    }

    @Override
    public List<Contact> findByAccountId(Long accountId) {
        List<Contact> contacts = contactRepositoryService.findAllByAccountId(accountId);
        return contacts;
    }

    private String getEmailDomain(String email) {
        return email.substring(email.indexOf("@") + 1);
    }

    private void ValidateWithAlertProfileLocation(Contact contact) {
        String AccountId=contact.getAccount().getId().toString();
        List<AlertProfile> alertProfiles = alertProfileRepositoryService.findAllByAccountId(Long.parseLong(AccountId));
        if(!CollectionUtils.isEmpty(alertProfiles)){
            // match the city and country of the contact with the alert profile
            for (AlertProfile alertProfile : alertProfiles) {
                if (alertProfile.getLocation().getCity().equals(contact.getAddress().getCity()) || alertProfile.getLocation().getCountry().equals(contact.getAddress().getCountry())) {
                    contact.setAlertProfile(alertProfile);
                    break;
                }
            }
        }


    }

}
