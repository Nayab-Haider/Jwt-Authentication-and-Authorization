package com.example.nayab.controller.restaurants;

import com.example.nayab.service.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class RestaurantsController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/search")
    ResponseEntity<?> search(@RequestHeader("Authorization") String authKey){
        return restaurantService.listAllRestaurants();
    }
}

