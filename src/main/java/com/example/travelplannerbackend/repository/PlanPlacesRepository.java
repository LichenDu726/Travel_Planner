package com.example.travelplannerbackend.repository;

import com.example.travelplannerbackend.model.Plan;
import com.example.travelplannerbackend.model.PlanPlaces;
import com.example.travelplannerbackend.model.PlanPlacesKey;
import com.example.travelplannerbackend.model.SchedulerPlaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanPlacesRepository extends JpaRepository<PlanPlaces, PlanPlacesKey> {
    List<PlanPlaces> findByPlanId(String planId);
    void deleteByPlanId(String planId);
}