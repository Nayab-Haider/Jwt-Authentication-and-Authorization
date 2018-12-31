package com.example.nayab.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "country_list")
public class MyCountry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "country_custom_generator")
    @SequenceGenerator(name = "country_custom_generator",sequenceName = "country_custom_generator",initialValue = 3)
    @JsonIgnore
    private Long countryId;

    private String countryCode;

    private String countryName;
}
