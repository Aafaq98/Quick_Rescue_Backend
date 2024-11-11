package org.example.quickrescueapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.quickrescueapplication.common.constant.Role;

/**
 * This class represents the Contact entity.
 */
@Table(name = "contact")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Contact {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "gender")
    private String gender;

    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "has_login")
    private Boolean hasLogin;


    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.EAGER) // we can change it according to the requirement
    @JoinColumn(name = "alert_profile_id")
    private AlertProfile alertProfile;


}
