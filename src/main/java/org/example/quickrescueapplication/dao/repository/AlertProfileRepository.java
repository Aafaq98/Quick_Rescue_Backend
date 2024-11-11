package org.example.quickrescueapplication.dao.repository;

import org.example.quickrescueapplication.entity.AlertProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertProfileRepository extends JpaRepository<AlertProfile, Long> {
    List<AlertProfile> findAllByAccountId(Long accountId);

    AlertProfile findByAccountId(Long accountId);

    AlertProfile getFirstById(Long id);

}
