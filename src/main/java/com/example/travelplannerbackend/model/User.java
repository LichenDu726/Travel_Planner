package com.example.travelplannerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "user")
@JsonDeserialize(builder = User.Builder.class)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String username;
//    private String firstName;
//    private String lastName;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String name;

    @JsonIgnore
    private boolean enabled;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    @JsonIgnore
    private Scheduler scheduler;

//    @OneToMany
//    @JsonIgnore
//    private List<Plan> savedPlan;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(unique = true)
//    @JsonIgnore
//    private UserFavoritePlaces userFavoritePlaces;

    //@OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    // @JsonIgnore
//    @OneToMany
//    @JsonIgnore
//    private List<Place> favoritePlaces;

    public User () {}

    private User(User.Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.name = builder.name;
        this.enabled = builder.enabled;
        this.scheduler = builder.scheduler;
        //this.savedPlan = builder.savedPlan;
        //this.favoritePlaces = builder.favoritePlaces;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

//    public List<Plan> getSavedPlan() {
//        return savedPlan;
//    }
//
//    public void setSavedPlan(List<Plan> savedPlan) {
//        this.savedPlan = savedPlan;
//    }

//    public List<Place> getFavoritePlaces() {
//
//        return favoritePlaces;
//    }

   // public void setFavoritePlaces(List<Place> favoritePlaces) {
//        this.favoritePlaces = favoritePlaces;
//    }

    public static class Builder {
        @JsonProperty("username")
        private String username;

        @JsonProperty("password")
        private String password;

        private String name;
        private String address;
        private boolean enabled;
        private Scheduler scheduler;
        private List<Plan> savedPlan;
        private List<Place> favoritePlaces;

        public User.Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public User.Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public User.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public User.Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public User.Builder setEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public User.Builder setScheduler(Scheduler scheduler) {
            this.scheduler = scheduler;
            return this;
        }

        public User.Builder setSavedPlan(List<Plan> savedPlan) {
            this.savedPlan = savedPlan;
            return this;
        }

        public User.Builder setFavoritePlaces(List<Place> favoritePlaces) {
            this.favoritePlaces = favoritePlaces;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }
}
