package com.example.travelplannerbackend.repository;


import com.example.travelplannerbackend.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// first project DAO
public interface SchedulerPlacesRepository extends JpaRepository<SchedulerPlaces, SchedulerPlacesKey> {
    List<SchedulerPlaces> findBySchedulerId(String schedulerId);
   // List<UserFavoritePlaces> findByUsername(String username);

    List<SchedulerPlaces> deleteBySchedulerId(String schedulerId);
    void deleteBySchedulerIdAndPlaceId(String schedulerId, String placeId);
}