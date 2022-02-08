package com.example.travelplannerbackend.repository;


import com.example.travelplannerbackend.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// first project DAO
public interface UserSavedPlanRepository extends JpaRepository<UserSavedPlan, UserSavedPlanKey> {
    UserSavedPlan findByPlanId(String planId);
    List<UserSavedPlan> findByUsername(String username);
    void deleteByPlanId(String planId);
}