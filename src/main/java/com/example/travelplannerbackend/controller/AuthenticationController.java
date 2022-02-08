package com.example.travelplannerbackend.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.travelplannerbackend.model.Token;
import com.example.travelplannerbackend.model.User;
import com.example.travelplannerbackend.model.UserRole;
import com.example.travelplannerbackend.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthenticationController {
    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate/user")
    public Token authenticateGuest(@RequestBody User user) {
        return authenticationService.authenticate(user, UserRole.ROLE_USER);
    }

}