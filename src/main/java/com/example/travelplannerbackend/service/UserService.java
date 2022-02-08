package com.example.travelplannerbackend.service;

import com.example.travelplannerbackend.exception.UserAlreadyExistException;
import com.example.travelplannerbackend.model.*;
import com.example.travelplannerbackend.repository.AuthorityRepository;
import com.example.travelplannerbackend.repository.UserFavoritePlacesRepository;
import com.example.travelplannerbackend.repository.UserRepository;
import com.example.travelplannerbackend.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;
    private PasswordEncoder passwordEncoder;
    private PlaceRepository placeRepository;
    private UserFavoritePlacesRepository userFavoritePlacesRepository;

    @Autowired
    public UserService(UserRepository userRepository, AuthorityRepository authorityRepository,
                       PlaceRepository placeRepository, UserFavoritePlacesRepository userFavoritePlacesRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.placeRepository = placeRepository;
        this.userFavoritePlacesRepository = userFavoritePlacesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void signUp(User user, UserRole role) throws UserAlreadyExistException {
        if (userRepository.existsById(user.getUsername())) {
            throw new UserAlreadyExistException("User Already Exists");
        }
                if (user.getUsername() == null) {
            throw new UserAlreadyExistException("invalid username");
        }

        Scheduler scheduler = new Scheduler();
        user.setScheduler(scheduler);
        user.setEnabled(true);
        List<Plan> savedPlan = new ArrayList<>();
        //user.setSavedPlan(savedPlan);
        //List<Place> favoritePlaces = new ArrayList<>();
        //user.setFavoritePlaces(favoritePlaces);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        Authority authority = new Authority(user.getUsername(), role.name());
        authorityRepository.save(authority);
    }

    public User getUser(String username) {
        return userRepository.getById(username);
    }

    //Jenny
    public void addPlaceToFavorite(String username, String placeId)  {

        //User user = userRepository.findById(username).get();
        //User user = userRepository.getById(username);
//        List<Place> favoritePlaces = new ArrayList<>();
//        user.setFavoritePlaces(favoritePlaces);
        // userFavoritePlacesRepository.findByUser(User user);
        UserFavoritePlaces entity = new UserFavoritePlaces.Builder().setUsername(username).setPlaceId(placeId).build();
        userFavoritePlacesRepository.save(entity);
// Build and execute SQL statement
            //"INSERT IGNORE INTO %s (user_id, listing_id) VALUES (?, ?)", SAVED_RECORDS_DB
    }

    public List<Place> listByUser(String userName) {
        User user = userRepository.getById(userName);
        //List<Place> result = user.getFavoritePlaces();
        List<UserFavoritePlaces> places = userFavoritePlacesRepository.findByUsername(userName);
        //System.out.println("total number of favorite palces" + places.size());
        List<Place> favoritePlaces = new ArrayList<>();
        for (int i = 0; i < places.size(); i++) {
            String placeId = places.get(i).getPlaceId();
            System.out.println("placeId:" + placeId);
            favoritePlaces.add(placeRepository.findById(Long.valueOf(placeId)).get());
        }
        //System.out.println(result.size());
        return favoritePlaces;
    }
}