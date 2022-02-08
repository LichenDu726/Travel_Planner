package com.example.travelplannerbackend.controller;

import com.example.travelplannerbackend.model.Place;
import com.example.travelplannerbackend.model.Scheduler;
import com.example.travelplannerbackend.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.security.Principal;


@RestController
public class SchedulerController {

    @Autowired
    private SchedulerService schedulerService;

    @GetMapping(value = "user/scheduler/get/{username}")
    @ResponseBody
    public Scheduler getScheduler(@PathVariable String username) {
        return schedulerService.getScheduler(username);
    }

    // datatype for plannedPlaces - verified;
    // PathVariable or RequestBody
    // @RequestBody Place[] places
    // no need to have plannedPlaces as input?????
    @PostMapping(value = "user/scheduler/set/{username}/{date}")
    public void setScheduler(@PathVariable String date,
                             @RequestBody String dailyPlan,
                             Principal principal) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
         schedulerService.setScheduler(principal.getName(), localDate, dailyPlan);
    };

    @PutMapping(value = "/user/scheduler/add/{schedulerId}/{placeId}")
    public void addPlaceToScheduler(@PathVariable String placeId,
                                    @PathVariable String schedulerId) {
        schedulerService.addPlaceToScheduler(schedulerId, placeId);
    }

    @DeleteMapping(value = "/user/scheduler/delete/{schedulerId}")
    public void cleanScheduler( @PathVariable String schedulerId) {
        schedulerService.cleanScheduler(schedulerId);
    }

//    No need for generate plan function????????
    @PutMapping(value = "/user/scheduler/generateplan/{username}/{schedulerId}")
    public void generatePlanFromScheduler(@PathVariable String schedulerId,
                                          Principal principal) {
        schedulerService.generatePlanFromScheduler(principal.getName(), schedulerId);
    }

    @PutMapping(value = "/user/scheduler/update/{schedulerId}/{placeIdOld}/{placeIdNew}/{date}")
    public void updatePlaceAndDateToScheduler(@PathVariable String placeIdOld,
                                              @PathVariable String placeIdNew,
                                              @PathVariable String schedulerId,
                                              @PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        schedulerService.updatePlaceAndDateToScheduler(schedulerId, placeIdOld, placeIdNew, localDate);
    }
}

