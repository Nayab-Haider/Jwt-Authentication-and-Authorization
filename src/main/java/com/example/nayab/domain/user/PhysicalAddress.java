package com.example.nayab.domain.user;

import com.example.nayab.configuration.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name="phyaddress")
public class PhysicalAddress extends Auditable<String>  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRegistrationId;


    private String secretAnswer1;
    private String secretAnswer2;

    @JsonIgnore
    @ManyToOne
    private User user;



}
