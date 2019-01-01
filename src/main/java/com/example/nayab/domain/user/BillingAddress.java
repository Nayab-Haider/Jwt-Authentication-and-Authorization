package com.example.nayab.domain.user;

import com.example.nayab.configuration.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name="billingAddress")
public class BillingAddress extends Auditable<String>  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRegistrationId;


    private String secretAnswer1;
    private String secretAnswer2;

    @JsonIgnore
    @OneToOne
    private User user;
}
