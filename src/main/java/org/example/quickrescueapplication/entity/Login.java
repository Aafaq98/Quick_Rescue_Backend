package org.example.quickrescueapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class represents the Login entity.
 */

@Getter
@Setter
@Entity
@Table(name = "login")
@NoArgsConstructor
@ToString
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

}
