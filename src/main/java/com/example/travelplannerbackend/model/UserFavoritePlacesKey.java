package com.example.travelplannerbackend.model;

import java.time.LocalDate;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserFavoritePlacesKey implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;

    private String placeId;

    public UserFavoritePlacesKey() {}

    public UserFavoritePlacesKey(String username, String placeId) {
        this.username = username;
        this.placeId = placeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    //
//    public static long getSerialVersionUID() {
//        return serialVersionUID;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Place getPlace() {
//        return place;
//    }
//
//    public void setPlace(Place place) {
//        this.place = place;
//    }
//
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFavoritePlacesKey that = (UserFavoritePlacesKey) o;
        return username.equals(that.username) && placeId.equals(that.placeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, placeId);
    }
}