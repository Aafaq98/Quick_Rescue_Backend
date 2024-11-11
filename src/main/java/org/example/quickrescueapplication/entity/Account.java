package org.example.quickrescueapplication.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "account")
@Getter
@Setter
@ToString
@NoArgsConstructor
/**
 * This class represents the Account entity.
 */
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",unique = true, nullable = false)
    @NotNull(message = "Name is required")
    private String name;
    @Column(name = "email_domain")
    @NotNull(message = "Email domain is required")
    private String emailDomain;
    @Column(name = "time_zone_city")
    private String timeZoneCity;


}
