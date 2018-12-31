package com.example.nayab.service.country;

import com.example.nayab.domain.user.MyCountry;
import com.example.nayab.domain.user.MyCountry;
import com.example.nayab.domain.user.State;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface CountryService {
    ResponseEntity<?> insertNewCountry(MyCountry country);

    ResponseEntity<?> insertNewState(State state,String countryId);

    ResponseEntity<?> deleteCountry(String countryId);

    ResponseEntity<?> getCountryDetail(String countryId);

    ResponseEntity<?> updateCountry(MyCountry country,String countryId);

    ResponseEntity<?> updateState(State state,String stateId);

    ResponseEntity<?> deleteState(String stateId);

}
