package com.example.nayab.service.authenticate;

import com.example.nayab.configuration.JwtTokenProvider;
import com.example.nayab.controller.authenticate.AuthenticationController;
import com.example.nayab.domain.user.User;
import com.example.nayab.exception.authentication.AuthenticationFailed;
import com.example.nayab.repository.user.UserRepository;
import com.example.nayab.util.authenticate.ResetPassword;
import com.example.nayab.util.response.ResponseDomain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Component
public interface AuthenticationService {

    public ResponseEntity<?> signin(String username, String password);

    public  ResponseEntity<?> signup(User user);

    public ResponseEntity<?> delete(String username);

    public ResponseEntity<?> whoami(HttpServletRequest req);

    public ResponseEntity<?> forgotPassword(HttpServletRequest request, String userName);

    public ResponseEntity<?> resetPassword(ResetPassword resetPassword);

}
