package com.example.travelplannerbackend.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user_favorite_places")
@JsonDeserialize(builder = UserFavoritePlaces.Builder.class)
@IdClass(UserFavoritePlacesKey.class)
public class UserFavoritePlaces implements Serializable{

    private static final long serialVersionUID = 1L;

//    @EmbeddedId
//    private UserFavoritePlacesKey id;

    @Id
    private String username;

//    // ? mappedBy "place" ?
//    @OneToMany(mappedBy = "userfavoriteplaces", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//    @JsonIgnore
//    private List<Place> places;

    @Id
    private String placeId;

    public UserFavoritePlaces() {}

    public UserFavoritePlaces(Builder builder) {
        this.username = builder.username;
        this.placeId = builder.placeId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserId() {
        return username;
    }

    public String getPlaceId() {
        return placeId;
    }


    public static class Builder {
        @JsonProperty("username")
        private String username;

        @JsonProperty("placeId")
        private String placeId;

        public String getUsername() {
            return username;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public String getPlaceId() {
            return placeId;
        }

        public Builder setPlaceId(String placeId) {
            this.placeId = placeId;
            return this;
        }

        public UserFavoritePlaces build() {
            return new UserFavoritePlaces(this);
        }
    }

}

