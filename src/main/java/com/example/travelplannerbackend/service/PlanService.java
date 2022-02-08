package com.example.travelplannerbackend.service;

import com.example.travelplannerbackend.exception.PlanNotFoundException;
import com.example.travelplannerbackend.model.*;
import com.example.travelplannerbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanService {
    private PlanRepository planRepository;
    private SchedulerRepository schedulerRepository;
    private UserSavedPlanRepository userSavedPlanRepository;
    private PlanPlacesRepository planPlacesRepository;
    private PlaceRepository placeRepository;
    private SchedulerPlacesRepository schedulerPlacesRepository;
    private SchedulerService schedulerService;

    @Autowired
    public PlanService(PlanRepository planRepository, SchedulerRepository schedulerRepository,
                       UserSavedPlanRepository userSavedPlanRepository,
                       PlanPlacesRepository planPlacesRepository,
                       PlaceRepository placeRepository,
                       SchedulerPlacesRepository schedulerPlacesRepository,
                       SchedulerService schedulerService) {
        this.planRepository = planRepository;
        this.schedulerRepository = schedulerRepository;
        this.userSavedPlanRepository = userSavedPlanRepository;
        this.planPlacesRepository = planPlacesRepository;
        this.placeRepository = placeRepository;
        this.schedulerPlacesRepository = schedulerPlacesRepository;
        this.schedulerService = schedulerService;
    }

    public List<Plan> listPlan(String username) {
        //return null;
        //return (planRepository.findByUser(new User.Builder().setUserId(userId).build());
        List<UserSavedPlan> userSavedPlans = userSavedPlanRepository.findByUsername(username);
        System.out.println(userSavedPlans.size());
        List<Plan> plans = new ArrayList<>();
        for (int i = 0; i < userSavedPlans.size(); i++) {
            UserSavedPlan cur = userSavedPlans.get(i);
            Integer planId = Integer.valueOf(cur.getPlanId());
            System.out.println(planId);
            plans.add(planRepository.findById(planId).get());
        }
        return plans;
    }

    public void addPlan(String username, Plan plan) {
        planRepository.save(plan);
        String planId = String.valueOf(plan.getPlanId());
        UserSavedPlan entity = new UserSavedPlan.Builder()
                .setPlanId(planId)
                .setUsername(username)
                .build();
        userSavedPlanRepository.save(entity);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void deletePlan(Integer planId) throws PlanNotFoundException {
        Plan plan = planRepository.findById(planId).orElseThrow(() -> new PlanNotFoundException("Plan is not available"));
        planRepository.deleteById(planId);
        // delete places from PlanPlaces
        planPlacesRepository.deleteByPlanId(String.valueOf(planId));
        // also delete plan in user_saved_plan1 table;
        UserSavedPlan entity = userSavedPlanRepository.findByPlanId(String.valueOf(planId));
        userSavedPlanRepository.delete(entity);
    }
    // add table plan_places;
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Scheduler editPlan(String planId, String schedulerId) {
        //read plan information
        Plan plan = planRepository.findById(Integer.valueOf(planId))
                .orElseThrow(() -> new PlanNotFoundException("Plan is not available"));
        List<Place> placesFromPlan = getPlacesFromPlan(planId);
        String dailyPlan = plan.getDailyPlan();
        // delete plan
        planRepository.deleteById(Integer.valueOf(planId));
        // delete places from PlanPlaces
        planPlacesRepository.deleteByPlanId(planId);
        // delete plan from UserSavedPlan
        userSavedPlanRepository.deleteByPlanId(planId);
        Scheduler scheduler = schedulerRepository.findById(Long.parseLong(schedulerId)).get();
        // clean scheduler
        schedulerService.cleanScheduler(schedulerId);
        // add dailyplan
        scheduler.setDailyPlan(dailyPlan);

        // add places to SchedulerPlaces
        for (int i = 0; i < placesFromPlan.size(); i++) {
            //
            SchedulerPlaces entity = new SchedulerPlaces.Builder()
                    .setSchedulerId(schedulerId)
                    .setPlaceId(String.valueOf(placesFromPlan.get(i).getId()))
                    .build();
            schedulerPlacesRepository.save(entity);
        }
        //scheduler.setPlannedPlaces(placesFromPlan);
        schedulerRepository.save(scheduler);
        return scheduler;
    }

    private List<Place> getPlacesFromPlan(String planId) {
        List<PlanPlaces> places = planPlacesRepository.findByPlanId(planId);
        List<Place> placesFromPlan = new ArrayList<>();
        for (int i = 0; i < places.size(); i++) {
            String placeId = places.get(i).getPlaceId();
            //System.out.println("placeId:" + placeId);
            placesFromPlan.add(placeRepository.findById(Long.valueOf(placeId)).get());
        }
        return placesFromPlan;
    }
}