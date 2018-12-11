package com.example.nayab.util.authenticate;

import lombok.Data;

@Data
public class ResetPassword {
    String token;

    String password;
}
