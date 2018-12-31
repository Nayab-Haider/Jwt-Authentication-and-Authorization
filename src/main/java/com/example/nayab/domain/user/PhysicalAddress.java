package com.example.nayab.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name="phyaddress")
public class PhysicalAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRegistrationId;


    private String secretAnswer1;
    private String secretAnswer2;

    @JsonIgnore
    @ManyToOne
    private User user;



}
