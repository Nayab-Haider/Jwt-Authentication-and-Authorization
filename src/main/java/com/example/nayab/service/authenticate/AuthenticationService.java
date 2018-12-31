package com.example.nayab.service.authenticate;

import com.example.nayab.domain.user.User;
import com.example.nayab.util.authenticate.ResetPassword;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public interface AuthenticationService {

    public ResponseEntity<?> signin(String username, String password);

    public  ResponseEntity<?> signup(User user);

    public ResponseEntity<?> delete(String username);

    public ResponseEntity<?> whoami(HttpServletRequest req);

    public ResponseEntity<?> forgotPassword(HttpServletRequest request, String userName);

    public ResponseEntity<?> resetPassword(ResetPassword resetPassword);

    public ResponseEntity<?> refreshToken(HttpServletRequest auth);

}
