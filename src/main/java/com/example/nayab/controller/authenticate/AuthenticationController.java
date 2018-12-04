package com.example.nayab.controller.authenticate;

import com.example.nayab.domain.user.User;
import com.example.nayab.service.authenticate.AuthenticationService;
import com.example.nayab.util.authenticate.LoginCredentials;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("/v1")
@RestController
public class AuthenticationController {

    private static final Logger logger= LogManager.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody LoginCredentials user){
        logger.info("Entering into AuthenticationController inside method login");
       return authenticationService.signin(user.getUsername(),user.getPassword());
    }

    @PostMapping("/signup")
    ResponseEntity<?> sigup(@RequestBody User user){
        logger.info("Entering into AuthenticationController inside method sigup");
        return authenticationService.signup(user);
    }

    @DeleteMapping("/delete/{username}")
    ResponseEntity<?> delete(@PathVariable String username,@RequestHeader("Authorization") String authKey){
        logger.info("Entering into AuthenticationController inside method delete");
        return authenticationService.delete(username);
    }

    @GetMapping("/whoami")
    ResponseEntity<?> knowMe(HttpServletRequest request,@RequestHeader("Authorization") String authKey){
        logger.info("Entering into AuthenticationController inside method knowMe");
        return authenticationService.whoami(request);
    }

    @PostMapping("/forgotpassword/{userName}")
    ResponseEntity<?> forgotPassword(HttpServletRequest request,@PathVariable String userName){
        logger.info("Entering into AuthenticationController inside method forgotPassword");
        return authenticationService.forgotPassword(request,userName);
    }

    @PostMapping("/resetpassword")
    ResponseEntity<?> resetPassword(@RequestParam String requestParams, @RequestParam String password){
        logger.info("Entering into AuthenticationController inside method forgotPassword");
        return authenticationService.resetPassword(requestParams,password);
    }


}
