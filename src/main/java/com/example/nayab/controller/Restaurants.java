package com.example.nayab.controller;

import com.example.nayab.domain.User;
import com.example.nayab.service.Restaurants.SearchRestaurants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class Restaurants {

    @Autowired
    private SearchRestaurants searchRestaurants;

    @GetMapping("/restaurantssearch")
    ResponseEntity<?> search(@RequestHeader("Authorization") String authKey){
        return searchRestaurants.listAllRestaurants();
    }
}

