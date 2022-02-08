package com.example.travelplannerbackend.controller;

import com.example.travelplannerbackend.exception.CategoryNotExistException;
import com.example.travelplannerbackend.exception.CityNotExistException;
import com.example.travelplannerbackend.exception.PlaceNotExistException;
import com.example.travelplannerbackend.model.Place;
import com.example.travelplannerbackend.model.PlaceCategory;
import com.example.travelplannerbackend.service.CityService;
import com.example.travelplannerbackend.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/cities/{name}")
    public List<Place> getPlaceByCity(@PathVariable String name)
            throws CityNotExistException {

        return cityService.listByCity(name);
    }
}
