package com.example.travelplannerbackend.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "plan_places")
@JsonDeserialize(builder = PlanPlaces.Builder.class)
@IdClass(PlanPlacesKey.class)
public class PlanPlaces implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private String planId;

    @Id
    private String placeId;

    public PlanPlaces() {}

    public PlanPlaces(Builder builder){
        this.planId = builder.planId;
        this.placeId = builder.placeId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public static class Builder {
        @JsonProperty("planId")
        private String planId;

        @JsonProperty("placeId")
        private String placeId;

        public String getPlanId() {
            return planId;
        }

        public Builder setPlanId(String planId) {
            this.planId = planId;
            return this;
        }

        public String getPlaceId() {
            return placeId;
        }

        public Builder setPlaceId(String placeId) {
            this.placeId = placeId;
            return this;
        }

        public PlanPlaces build() {
            return new PlanPlaces(this);
        }
    }

}