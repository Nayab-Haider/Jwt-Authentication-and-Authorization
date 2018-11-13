package com.example.nayab.service.Restaurants;

import com.example.nayab.configuration.JwtTokenProvider;
import com.example.nayab.domain.User;
import com.example.nayab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseEntity<?> signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return new ResponseEntity<>(jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles()),HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("invalid credentials",HttpStatus.BAD_REQUEST);
        }
    }

    public  ResponseEntity<?> signup(User user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return new ResponseEntity<>(jwtTokenProvider.createToken(user.getUsername(), user.getRoles()),HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Signup failed",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> delete(String username) {
       try {
           userRepository.deleteByUsername(username);
           return new ResponseEntity<>("Successfully deleted user",HttpStatus.OK);
       }
       catch (Exception e){

       }
        return new ResponseEntity<>("Failed to deleted user",HttpStatus.BAD_REQUEST);
    }

//    public User search(String username) {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
//        }
//        return user;
//    }

    public User whoami(HttpServletRequest req) {
        return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }
}
