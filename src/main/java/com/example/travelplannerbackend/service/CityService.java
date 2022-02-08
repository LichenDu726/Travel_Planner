package com.example.travelplannerbackend.service;
import com.example.travelplannerbackend.repository.CityRepository;
import com.example.travelplannerbackend.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.travelplannerbackend.model.*;
import java.util.*;

@Service
public class CityService {
    private CityRepository cityRepository;
    private PlaceRepository placeRepository;
    //public CityService() {}

    @Autowired
    public CityService(CityRepository cityRepository, PlaceRepository placeRepository) {
        this.cityRepository = cityRepository;
        this.placeRepository = placeRepository;
    }

    public List<Place> listByCity(String cityName) {
        City city = cityRepository.getById(cityName);
        return placeRepository.
                findByCity(city);
    }
}