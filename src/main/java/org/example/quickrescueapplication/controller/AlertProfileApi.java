package org.example.quickrescueapplication.controller;


import jakarta.validation.Valid;
import org.example.quickrescueapplication.entity.AlertProfile;
import org.example.quickrescueapplication.service.AlertProfileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertprofile")
@CrossOrigin(origins = "*")
public class AlertProfileApi {

    @Autowired
    private AlertProfileManager alertProfileManager;

    @PostMapping
    public AlertProfile create(@RequestBody @Valid AlertProfile alertProfile) {
        AlertProfile createdAlertProfile = alertProfileManager.create(alertProfile);
        return createdAlertProfile;
    }

    @PutMapping
    public AlertProfile update(@RequestBody@Valid AlertProfile alertProfile) {
        AlertProfile updatedAlertProfile = alertProfileManager.update(alertProfile);
        return updatedAlertProfile;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alertProfileManager.delete(id);
    }

    @GetMapping("/{id}")
    public AlertProfile get(@PathVariable Long id) {
        AlertProfile alertProfile = alertProfileManager.getById(id);
        return alertProfile;
    }

    @GetMapping("/account/{accountId}")
    public List<AlertProfile> findAllByAccountId(@PathVariable Long accountId) {
        List<AlertProfile> alertProfiles = alertProfileManager.findAllByAccountId(accountId);
        return alertProfiles;
    }


}
