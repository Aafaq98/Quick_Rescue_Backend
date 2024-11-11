package org.example.quickrescueapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;



@Entity
@Table(name = "contract")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Contract {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private Integer maxContacts;


    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
