package com.example.travelplannerbackend.service;
import com.example.travelplannerbackend.exception.PlaceNotExistException;
import com.example.travelplannerbackend.repository.CityRepository;
import com.example.travelplannerbackend.repository.PlaceRepository;
import com.example.travelplannerbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.travelplannerbackend.model.*;
import java.util.*;

@Service
public class PlaceService {
    private CityRepository cityRepository;
    private PlaceRepository placeRepository;
    private UserRepository userRepository;

    @Autowired
    public PlaceService(CityRepository cityRepository, PlaceRepository placeRepository, UserRepository userRepository) {
        this.cityRepository = cityRepository;
        this.placeRepository = placeRepository;
        this.userRepository = userRepository;
    }

    public List<Place> listByCategory(String cityName, PlaceCategory category) {
        City city = cityRepository.getById(cityName);
        return placeRepository.findDistinctByCityAndCategory(city, category);
    }

    public List<Place> listByKeywords(String cityName, String keyword) {
//        PlaceCategory category = PlaceCategory.valueOf(keyword);
//        return placeRepository.findPlaceByKeywords(keyword, category);
        // return placeRepository.findPlaceByKeywords(keyword);
        // return placeRepository.findAllByNameContaining(keyword);
        City city = cityRepository.getById(cityName);
        return placeRepository.findDistinctByCityAndNameContaining(city, keyword);
    }



    public Place listById(String id) throws PlaceNotExistException {
        Long idOfPlace = Long.valueOf(id);
        return placeRepository.findById(idOfPlace).get();
    }
}
