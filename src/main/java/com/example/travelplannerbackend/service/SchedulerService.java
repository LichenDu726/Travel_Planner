package com.example.travelplannerbackend.service;

import com.example.travelplannerbackend.exception.SchedulerNotFoundException;
import com.example.travelplannerbackend.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.travelplannerbackend.model.*;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SchedulerService {

    @Autowired
    private UserService userService;

    @Autowired
    private SchedulerRepository schedulerRepository;

    @Autowired
    private SchedulerPlacesRepository schedulerPlacesRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private PlanPlacesRepository planPlacesRepository;

    @Autowired
    private UserSavedPlanRepository userSavedPlanRepository;

    public Scheduler getScheduler(String username) {
        User user = userService.getUser(username);
        Long schedulerId = user.getScheduler().getSchedulerID();
        Scheduler scheduler = schedulerRepository.findById(schedulerId).orElseThrow(() -> new SchedulerNotFoundException("No scheduler is found"));
        return scheduler;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void setScheduler(String username, LocalDate date, String dailyPlan) {
        //Authentication
        User user = userService.getUser(username);

        if (user != null) {
            Scheduler scheduler = user.getScheduler();
            scheduler.setDailyPlan(dailyPlan);
            scheduler.setDate(date);
            schedulerRepository.save(scheduler);
        }
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void cleanScheduler(String schedulerId) {
        schedulerPlacesRepository.deleteBySchedulerId(schedulerId);
        Scheduler scheduler = schedulerRepository.getById(Long.parseLong(schedulerId));
        scheduler.setDate(null);
        scheduler.setDailyPlan(null);
        schedulerRepository.save(scheduler);
    }

    // helper function for generatePlanFromScheduler
    private List<Place> getPlannedPlaces(String scheduleId) {
        List<SchedulerPlaces> places = schedulerPlacesRepository.findBySchedulerId(scheduleId);
        List<Place> plannedPlaces = new ArrayList<>();
        for (int i = 0; i < places.size(); i++) {
            String placeId = places.get(i).getPlaceId();
            plannedPlaces.add(placeRepository.findById(Long.valueOf(placeId)).get());
        }
        return plannedPlaces;
    }

    public void addPlaceToScheduler(String schedulerId, String placeId)  {
        SchedulerPlaces entity = new SchedulerPlaces.Builder().
                                     setPlaceId(placeId).
                                     setSchedulerId(schedulerId).build();
        schedulerPlacesRepository.save(entity);
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void generatePlanFromScheduler(String username, String schedulerId)  {
        Scheduler scheduler = schedulerRepository.getById(Long.valueOf(schedulerId));
        if (scheduler != null) {
            List<Place> plannedPlaces = getPlannedPlaces(schedulerId);
            Plan plan = new Plan.Builder()
                    //.setPlannedPlaces(plannedPlaces)
                    .setDailyPlan(scheduler.getDailyPlan())
                    .build();
            planRepository.save(plan);
            int planId = plan.getPlanId();
            System.out.println(planId);
            System.out.println(plannedPlaces.size());
            for (int i = 0; i < plannedPlaces.size(); i++) {
                PlanPlaces entity = new PlanPlaces.Builder()
                        .setPlanId(String.valueOf(planId))
                        .setPlaceId(String.valueOf(plannedPlaces.get(i).getId()))
                        .build();
                planPlacesRepository.save(entity);
            }
            UserSavedPlan userSavedPlan = new UserSavedPlan.Builder()
                    .setUsername(username)
                    .setPlanId(String.valueOf(planId))
                    .build();
            userSavedPlanRepository.save(userSavedPlan);
            cleanScheduler(scheduler.getSchedulerID().toString());
        }
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void updatePlaceAndDateToScheduler(String schedulerId,
                                              String placeIdOld,
                                              String placeIdNew,
                                              LocalDate localDate) {
        schedulerPlacesRepository.deleteBySchedulerIdAndPlaceId(schedulerId, placeIdOld);
        SchedulerPlaces entity = new SchedulerPlaces.Builder()
                .setPlaceId(placeIdNew)
                .setSchedulerId(schedulerId)
                .build();
        schedulerPlacesRepository.save(entity);
        Scheduler scheduler = schedulerRepository.getById(Long.parseLong(schedulerId));
        scheduler.setDate(localDate);
        scheduler.setDailyPlan(null);
        schedulerRepository.save(scheduler);
    };
}
