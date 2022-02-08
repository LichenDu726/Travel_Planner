package com.example.travelplannerbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "plan")
@JsonDeserialize(builder = Plan.Builder.class)
public class Plan implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("plan_id")
    private int planId;

//    @JsonProperty("planned_places")
//    @OneToMany
//    private List<Place> plannedPlaces;
    //private String plannedPlaces;

    @JsonProperty("daily_plan")
    private String dailyPlan;

    public Plan() {}

    public Plan(Builder builder) {
        //this.plannedPlaces = builder.plannedPlaces;
        this.dailyPlan = builder.dailyPlan;
        this.planId = builder.planId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    //public List<Place> getPlannedPlaces() {
//        return plannedPlaces;
//    }

    //public void setPlannedPlaces(List<Place> plannedPlaces) {
//        this.plannedPlaces = plannedPlaces;
//    }

    public String getDailyPlan() {
        return dailyPlan;
    }

    public void setDailyPlan(String dailyPlan) {
        this.dailyPlan = dailyPlan;
    }

    public static class Builder {
        @JsonProperty("plan_id")
        private int planId;

        private List<Place> plannedPlaces;

        @JsonProperty("daily_plan")
        private String dailyPlan;

        public Builder setPlanId(int planId) {
            this.planId = planId;
            return this;
        }

        public Builder setPlannedPlaces(List<Place> plannedPlaces) {
            this.plannedPlaces = plannedPlaces;
            return this;
        }

        public Builder setDailyPlan(String dailyPlan) {
            this.dailyPlan = dailyPlan;
            return this;
        }


        public Plan build() {
            return new Plan(this);
        }
    }
}