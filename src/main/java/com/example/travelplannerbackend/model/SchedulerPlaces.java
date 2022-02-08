package com.example.travelplannerbackend.model;

import java.time.LocalDate;

import com.example.travelplannerbackend.model.UserFavoritePlacesKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "scheduler_places")
@JsonDeserialize(builder = com.example.travelplannerbackend.model.SchedulerPlaces.Builder.class)
@IdClass(SchedulerPlacesKey.class)
public class SchedulerPlaces implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private String schedulerId;

    @Id
    private String placeId;

    public SchedulerPlaces() {}

    public SchedulerPlaces(Builder builder){
        this.schedulerId = builder.schedulerId;
        this.placeId = builder.placeId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSchedulerId() {
        return schedulerId;
    }

    public void setSchedulerId(String schedulerId) {
        this.schedulerId = schedulerId;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public static class Builder {
        private String schedulerId;
        private String placeId;

        public String getSchedulerId() {
            return schedulerId;
        }

        public Builder setSchedulerId(String schedulerId) {
            this.schedulerId = schedulerId;
            return this;
        }

        public String getPlaceId() {
            return placeId;
        }

        public Builder setPlaceId(String placeId) {
            this.placeId = placeId;
            return this;
        }

        public SchedulerPlaces build() {
            return new SchedulerPlaces(this);
        }
    }

}