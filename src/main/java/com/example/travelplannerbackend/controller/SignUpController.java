package com.example.travelplannerbackend.controller;
import com.example.travelplannerbackend.model.UserRole;
import org.springframework.web.bind.annotation.RestController;
import com.example.travelplannerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.travelplannerbackend.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;

@RestController
public class SignUpController {
    private UserService userService;

    @Autowired
    public SignUpController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/signup")
    public void addHost(@RequestBody User user) {
        userService.signUp(user, UserRole.ROLE_USER);
    }

}