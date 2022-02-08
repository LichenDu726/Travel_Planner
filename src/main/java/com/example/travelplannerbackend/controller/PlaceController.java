package com.example.travelplannerbackend.controller;

import com.example.travelplannerbackend.exception.CategoryNotExistException;
import com.example.travelplannerbackend.exception.PlaceNotExistException;
import com.example.travelplannerbackend.model.Place;
import com.example.travelplannerbackend.model.PlaceCategory;

import com.example.travelplannerbackend.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaceController {
    private PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping(value = "/cities/{cityName}/{category}")
    public List<Place> getPlaceByCategory(@PathVariable String cityName, @PathVariable String category)
        throws CategoryNotExistException{

       PlaceCategory placeCategory = PlaceCategory.Museum;
        if (category == null) {
            placeCategory = PlaceCategory.Museum;
        } else if (category.equals("park") ){
            placeCategory = PlaceCategory.Park;
        } else if (category.equals("museum") ) {
            placeCategory = PlaceCategory.Museum;
        } else if (category.equals("theater")) {
            placeCategory = PlaceCategory.Theater;
        } else if (category.equals("event")) {
            placeCategory = PlaceCategory.Event;
        } else if (category.equals("landscape")) {
            placeCategory = PlaceCategory.Landscape;
        }
        return placeService.listByCategory(cityName, placeCategory);
       // return placeService.listByCategory();
    }

    @GetMapping(value = "/search/{cityName}/{keywords}")
    public List<Place> getPlaceByKeywords(@PathVariable String cityName,@PathVariable String keywords)
        throws PlaceNotExistException {
        // List<Place> places = placeService.listByKeywords(keywords);
        return placeService.listByKeywords(cityName, keywords);
    }

    @GetMapping(value = "/cities/search/{cityName}/{id}")
    public Place getPlaceById(@PathVariable String id) throws PlaceNotExistException {
        return placeService.listById(id);
    }
}
