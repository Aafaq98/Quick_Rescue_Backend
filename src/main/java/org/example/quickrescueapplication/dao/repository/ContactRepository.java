package org.example.quickrescueapplication.dao.repository;


import org.example.quickrescueapplication.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

   Contact getFirstById(Long id);

   List<Contact> findAllByAccountId(Long accountId);
}
