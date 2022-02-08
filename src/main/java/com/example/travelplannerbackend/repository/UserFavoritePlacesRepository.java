package com.example.travelplannerbackend.repository;


import com.example.travelplannerbackend.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// first project DAO
public interface UserFavoritePlacesRepository extends JpaRepository<UserFavoritePlaces, UserFavoritePlacesKey> {
    List<UserFavoritePlaces> findByUsername(String username);


}