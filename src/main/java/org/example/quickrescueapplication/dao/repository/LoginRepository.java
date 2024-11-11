package org.example.quickrescueapplication.dao.repository;


import org.example.quickrescueapplication.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

    public  Login getFirstById(Long id);
    // getByUSername and getByPassword
    public Login findByUsernameAndPassword(String username, String password);
}

