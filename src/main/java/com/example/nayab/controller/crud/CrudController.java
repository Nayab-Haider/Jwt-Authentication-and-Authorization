package com.example.nayab.controller.crud;

import com.example.nayab.domain.user.MyCountry;
import com.example.nayab.domain.user.State;
import com.example.nayab.service.country.CountryService;
import com.example.nayab.service.state.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/mapping")
public class CrudController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;

    @PostMapping("/insert/country")
    ResponseEntity<?> insertNewCountry(@RequestHeader("Authorization") String authKey, @RequestBody MyCountry country){
        return countryService.insertNewCountry(country);
    }

    @PostMapping("/insert/state/{countryId}")
    ResponseEntity<?> insertNewState(@RequestHeader("Authorization") String authKey, @RequestBody State state,@PathVariable String countryId){
        return countryService.insertNewState(state,countryId);
    }

    @DeleteMapping("/country/{countryId}")
    ResponseEntity<?> deleteCountry(@RequestHeader("Authorization") String authKey,@PathVariable String countryId){
        return countryService.deleteCountry(countryId);
    }

    @DeleteMapping("/state/{stateId}")
    ResponseEntity<?> deleteState(@RequestHeader("Authorization") String authKey,@PathVariable String stateId){
        return countryService.deleteState(stateId);
    }

    @GetMapping("/country/{countryId}")
    ResponseEntity<?> getCountryDetail(@RequestHeader("Authorization") String authKey,@PathVariable String countryId){
        return countryService.getCountryDetail(countryId);
    }

    @PutMapping("/update/country/{countryId}")
    ResponseEntity<?> updateCountry(@RequestHeader("Authorization") String authKey,@RequestBody MyCountry country,@PathVariable String countryId){
        return countryService.updateCountry(country,countryId);
    }

    @PutMapping("/update/state/{stateId}")
    ResponseEntity<?> updateState(@RequestHeader("Authorization") String authKey,@RequestBody State state,@PathVariable String stateId){
        return countryService.updateState(state,stateId);
    }



}
