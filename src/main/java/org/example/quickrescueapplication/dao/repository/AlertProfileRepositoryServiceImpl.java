package org.example.quickrescueapplication.dao.repository;

import org.example.quickrescueapplication.entity.AlertProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AlertProfileRepositoryServiceImpl implements AlertProfileRepositoryService {

    @Autowired
    private AlertProfileRepository alertProfileRepository;

    /**
     * This method is used to create an alert profile
     * @param alertProfile
     * @return
     */
    @Override
    public AlertProfile create(AlertProfile alertProfile) {
        AlertProfile savedAlertProfile = alertProfileRepository.save(alertProfile);
        return savedAlertProfile;
    }

    /**
     * This method is used to update an alert profile
     * @param alertProfile
     * @return
     */
    @Override
    public AlertProfile update(AlertProfile alertProfile) {
        AlertProfile updateAlertProfileEntity = alertProfileRepository.save(alertProfile);
        return updateAlertProfileEntity;
    }

    /**
     * This method is used to delete an alert profile
     * @param id
     */
    @Override
    public void delete(Long id) {
        alertProfileRepository.deleteById(id);
    }

    /**
     * This method is used to find an alert profile
     * @param id
     * @return
     */
    @Override
    public Optional<AlertProfile> find(Long id) {
        Optional<AlertProfile> alertProfile = alertProfileRepository.findById(id);
        return alertProfile;
    }

    /**
     * This method is used to get an alert profile by id
     * @param id
     * @return
     */
    @Override
    public AlertProfile getById(Long id) {
        return alertProfileRepository.getFirstById(id);
    }

    /**
     * This method is used to get all alert profiles
     * @param accountId
     * @return
     */
    @Override
    public List<AlertProfile> findAllByAccountId(Long accountId) {
        List<AlertProfile> alertProfiles = alertProfileRepository.findAllByAccountId(accountId);
        return alertProfiles;
    }
}
