package com.example.nayab.domain.user;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity(name = "loginUser")
public class User {

    @Id
    @GenericGenerator(name = "generator", strategy = "com.example.nayab.util.CustomGenerator")
    @GeneratedValue(generator = "generator")
    private String id;

    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Size(min = 8, message = "Minimum password length: 8 characters")
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> roles;

    @Column(name = "reset_token")
    private String resetToken;

}
