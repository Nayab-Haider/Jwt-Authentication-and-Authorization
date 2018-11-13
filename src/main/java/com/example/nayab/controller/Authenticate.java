package com.example.nayab.controller;

import com.example.nayab.domain.User;
import com.example.nayab.service.Restaurants.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1")
@RestController
public class Authenticate {


    @Autowired
    private UserService userService;

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestParam String username,@RequestParam String password){
       return userService.signin(username,password);
    }

    @PostMapping("/signup")
    ResponseEntity<?> sigup(@RequestBody User user){
        return userService.signup(user);
    }

    @DeleteMapping("/delete")
    ResponseEntity<?> delete(@PathVariable String username,@RequestHeader("Authorization") String auth){
        return userService.delete(username);
    }


}
