package com.example.nayab.controller;

import com.example.nayab.util.LoginCredentials;
import com.example.nayab.domain.User;
import com.example.nayab.service.Restaurants.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/v1")
@RestController
public class Authenticate {


    @Autowired
    private UserService userService;

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody LoginCredentials user){
       return userService.signin(user.getUsername(),user.getPassword());
    }

    @PostMapping("/signup")
    ResponseEntity<?> sigup(@RequestBody User user){
        return userService.signup(user);
    }

    @DeleteMapping("/delete/{username}")
    ResponseEntity<?> delete(@PathVariable String username,@RequestHeader("Authorization") String authKey){
        return userService.delete(username);
    }

    @GetMapping("/whoami")
    ResponseEntity<?> knowMe(HttpServletRequest request,@RequestHeader("Authorization") String authKey){
        return userService.whoami(request);
    }


}
