package com.example.nayab.service.country;


import com.example.nayab.domain.user.MyCountry;
import com.example.nayab.domain.user.MyCountry;
import com.example.nayab.domain.user.State;
import com.example.nayab.repository.user.CountryRepository;
import com.example.nayab.repository.user.StateRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Override
    public ResponseEntity<?> insertNewCountry(MyCountry country) {
        countryRepository.save(country);
        return new ResponseEntity<>("New Country added Successfully with Id: "+country.getCountryId(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> insertNewState(State state,String countryId) {

        Optional<MyCountry> countryObj = countryRepository.findById(Long.valueOf(countryId));
        if(countryObj!=null){
            state.setCountry(countryObj.get());
            stateRepository.save(state);
            return new ResponseEntity<>("New state added Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Given Country Id does not exist", HttpStatus.BAD_REQUEST);

    }

    @Override
    public ResponseEntity<?> deleteCountry(String countryId) {

        Optional<MyCountry> countryObj = countryRepository.findById(Long.valueOf(countryId));
        if(countryObj!=null){
            countryRepository.delete(countryObj.get());
            return new ResponseEntity<>("Country Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Given Country Id does not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> deleteState(String stateId) {
        Optional<State> stateObj = stateRepository.findById(Long.valueOf(stateId));
        if(stateObj!=null){
            stateRepository.delete(stateObj.get());
            return new ResponseEntity<>("Country Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Given Country Id does not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> getCountryDetail(String countryId) {

        Optional<MyCountry> countryObj = countryRepository.findById(Long.valueOf(countryId));

        if(countryObj!=null){
            List<State> stateList = stateRepository.findByCountry(countryObj.get());
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("country",countryObj.get());
            jsonObject.put("stateList",stateList);
//            stateList
            return new ResponseEntity<>(jsonObject, HttpStatus.OK);
        }
        return new ResponseEntity<>("Given Country Id does not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> updateCountry(MyCountry country,String countryId) {
        Optional<MyCountry> countryObj = countryRepository.findById(Long.valueOf(countryId));
        if(countryObj!=null){
            countryObj.get().setCountryCode(country.getCountryCode());
            countryObj.get().setCountryName(country.getCountryName());
            countryRepository.save(countryObj.get());
            return new ResponseEntity<>("Country updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Given Country Id does not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> updateState(State state,String stateId) {
        Optional<State> stateObj = stateRepository.findById(Long.valueOf(stateId));
        if(stateObj!=null){
            stateObj.get().setStateCode(state.getStateCode());
            stateObj.get().setStateName(state.getStateName());
            stateRepository.save(state);
            return new ResponseEntity<>("State updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Given State Id does not exist", HttpStatus.BAD_REQUEST);
    }
}

