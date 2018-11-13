package com.example.nayab.service.Restaurants;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SearchRestaurants {

    public ResponseEntity<?> listAllRestaurants() {
//        RestTemplate restTemplate = new RestTemplate();


        String transactionUrl = "https://developers.zomato.com/api/v2.1/search";
        HttpHeaders headers = new HttpHeaders();
        headers.set("user-key","2157516787c0d3558f778f28e721d7bd");
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(transactionUrl)
                // Add query parameter
                .queryParam("entity_id", "94741")
                .queryParam("entity_type", "zone");
        HttpEntity<?> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        Object response = restTemplate.exchange(transactionUrl, HttpMethod.GET,entity, Object.class);


        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
