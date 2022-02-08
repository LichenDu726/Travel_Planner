package com.example.travelplannerbackend.controller;

import com.example.travelplannerbackend.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class GeneratePlanController {

    @Autowired
    private SchedulerService schedulerService;

//    @PostMapping(value = "/generatePlan")
//    @ResponseStatus(value = HttpStatus.OK)
//    public void generatePlan(Principal principal) {
//       // schedulerService.generatePlan(principal.getName());
//    }
}