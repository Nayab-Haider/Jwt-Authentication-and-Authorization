package com.example.nayab.controller.authenticate;

import com.example.nayab.domain.user.User;
import com.example.nayab.util.authenticate.LoginCredentials;
import com.example.nayab.service.authenticate.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/v1")
@RestController
public class AuthenticationController {


    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody LoginCredentials user){
       return authenticationService.signin(user.getUsername(),user.getPassword());
    }

    @PostMapping("/signup")
    ResponseEntity<?> sigup(@RequestBody User user){

        return authenticationService.signup(user);
    }

    @DeleteMapping("/delete/{username}")
    ResponseEntity<?> delete(@PathVariable String username,@RequestHeader("Authorization") String authKey){
        return authenticationService.delete(username);
    }

    @GetMapping("/whoami")
    ResponseEntity<?> knowMe(HttpServletRequest request,@RequestHeader("Authorization") String authKey){
        return authenticationService.whoami(request);
    }


}