package org.example.quickrescueapplication.service;

import org.example.quickrescueapplication.entity.AlertProfile;

import java.util.List;
import java.util.Optional;

public interface AlertProfileManager {

    public AlertProfile create(AlertProfile alertProfile);

    public AlertProfile update(AlertProfile alertProfile);

    public void delete(Long id);

    public Optional<AlertProfile> find(Long id);

    public AlertProfile getById(Long id);

    public List<AlertProfile> findAllByAccountId(Long accountId);


}
