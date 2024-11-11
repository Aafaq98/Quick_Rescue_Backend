package org.example.quickrescueapplication.dao.repository;


import org.example.quickrescueapplication.entity.AlertProfile;

import java.util.List;
import java.util.Optional;

public interface AlertProfileRepositoryService {
    public AlertProfile create(AlertProfile alertProfile);
    public AlertProfile update(AlertProfile alertProfile);
    public void delete(Long id);
    public Optional<AlertProfile> find(Long id);
    public AlertProfile getById(Long id);
    public List<AlertProfile> findAllByAccountId(Long accountId);
}
