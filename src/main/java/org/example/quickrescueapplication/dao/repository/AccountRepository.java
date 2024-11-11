package org.example.quickrescueapplication.dao.repository;


import org.example.quickrescueapplication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getFirstById(final Long id);

}
