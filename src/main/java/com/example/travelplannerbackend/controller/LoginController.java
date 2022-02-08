package com.example.travelplannerbackend.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.travelplannerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.travelplannerbackend.model.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
//    private UserService userService;
//
//    @Autowired
//    public LoginController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping("/login")
//    public void userLogin(@RequestBody User user) {
//        userService.login(user);
//    }
    private final ObjectMapper objectMapper = new ObjectMapper();

    // we only process the failed login request here, if login successfully, it will automatically redirect to home page
    @RequestMapping("/travelplanner/login")
    public void login(@RequestParam(value = "error") String error, HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        Map<String, Object> data = new HashMap<>();
        data.put("message", "bad credentials");
        response.getOutputStream()
                .println(objectMapper.writeValueAsString(data));
    }

//    public String login() throws IOException {
//        return "login page";
//    }
}