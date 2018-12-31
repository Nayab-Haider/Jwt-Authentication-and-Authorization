package com.example.nayab.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="billingAddress")
public class BillingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRegistrationId;


    private String secretAnswer1;
    private String secretAnswer2;

    @JsonIgnore
    @OneToOne
    private User user;
}
