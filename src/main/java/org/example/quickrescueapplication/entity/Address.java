package org.example.quickrescueapplication.entity;


import jakarta.persistence.Embeddable;
import lombok.Data;

/**
 * This class represents the Address entity.
 */
@Embeddable
@Data
public class Address {
        private String streetAddress;
        private String city;
        private String stateProvince;
        private String country;

}
