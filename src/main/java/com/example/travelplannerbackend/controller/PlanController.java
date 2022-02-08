package com.example.travelplannerbackend.controller;

import com.example.travelplannerbackend.model.Plan;
import com.example.travelplannerbackend.model.Scheduler;
import com.example.travelplannerbackend.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class PlanController {
    private PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping(value = "user/plan/add/{username}")
    public void addPlan(@PathVariable String username,
                        @RequestBody Plan plan
                        //Principal principal
                        ) {
        //boolean flag = plan == null ? true : false;
//        System.out.println(flag);
//        System.out.println(plan.getDailyPlan());
//        //System.out.println(username);
//        System.out.println(String.valueOf(plan.getPlanId()));
        //plan.setDailyPlan(new plan.Builder().setDailyPlan(principal.getName());
        planService.addPlan(username, plan);
    }

    @GetMapping(value = "user/plan/listall/{username}")
    public List<Plan> listPlan(@PathVariable String username) {
        return planService.listPlan(username);
    }

    @DeleteMapping("user/plan/delete/{planId}")
    public void deletePlan(@PathVariable String planId) {
        Integer idOfPlan = Integer.valueOf(planId);
        planService.deletePlan(idOfPlan);
    }

    @GetMapping(value="user/plan/edit/{planId}/{schedulerId}")
    @ResponseBody
    public Scheduler editPlan(@PathVariable String planId, @PathVariable String schedulerId) {
        return planService.editPlan(planId, schedulerId);
    }
}