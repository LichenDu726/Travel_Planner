package com.example.travelplannerbackend.repository;

import com.example.travelplannerbackend.model.Scheduler;
import com.example.travelplannerbackend.model.User;
import com.example.travelplannerbackend.service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    //User getById(String username);
//    User user = UserService.getUser(username);
//    Long schedulerId = user.getSchedulerId();

   // Place

}