package com.example.travelplannerbackend.controller;
import com.example.travelplannerbackend.exception.PlaceNotExistException;
import com.example.travelplannerbackend.model.Place;
import com.example.travelplannerbackend.model.UserRole;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.example.travelplannerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.travelplannerbackend.model.User;

import java.security.Principal;
import java.util.List;

@RestController
public class FavoriteController {
    private UserService userService;

    @Autowired
    public FavoriteController(UserService userService) {
        this.userService = userService;
    }

    //    @PostMapping("/user/signup")
//    public void addUser(@RequestBody User user) {
//        userService.signUp(user, UserRole.ROLE_USER);
//    }
    // Jenny
    @PutMapping(value = "user/favorite/{username}/{placeId}")
    public void addPlaceToFavorite(@PathVariable String username,
                                   @PathVariable String placeId) {
        userService.addPlaceToFavorite(username, placeId);
    }
//    @PutMapping(value = "user/favorite/{username}/{placeId}")
//    public void addPlaceToFavorite(@RequestBody String username,
//                                   @PathVariable String placeId, Principal principal) {
//        userService.addPlaceToFavorite(username, placeId);
//    }

    @GetMapping(value = "user/favorite/{username}")
    public List<Place> getFavoritePlacesByUsername(@PathVariable String username) throws UsernameNotFoundException {
        return userService.listByUser(username);
    }
}