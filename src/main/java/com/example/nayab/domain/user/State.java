package com.example.nayab.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@Table(name = "state_list")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "state_custom_generator")
    @SequenceGenerator(name = "state_custom_generator",sequenceName = "state_custom_generator",initialValue = 65)
    @JsonIgnore
    private Long stateId;

    private String stateName;

    private String stateCode;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MyCountry country;


}
