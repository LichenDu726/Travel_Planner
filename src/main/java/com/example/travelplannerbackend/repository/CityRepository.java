package com.example.travelplannerbackend.repository;

import com.example.travelplannerbackend.model.City;
import com.example.travelplannerbackend.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, String> {
    City getCityByCityNameIsLike(String cityName);
}
