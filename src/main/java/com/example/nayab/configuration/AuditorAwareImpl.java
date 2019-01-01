package com.example.nayab.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        String userName =null;
        try{
            userName=SecurityContextHolder.getContext().getAuthentication().getName();
        }
        catch (NullPointerException e){
            userName="Default";
        }
        return Optional.ofNullable(userName);
    }
}
