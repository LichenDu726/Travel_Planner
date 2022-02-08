package com.example.travelplannerbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "scheduler")
@JsonDeserialize(builder = City.Builder.class)
public class Scheduler implements Serializable {

    private static final long serialVersionUID = 1L;

    public Scheduler() {}

    private Scheduler(Builder builder) {
        this.schedulerId = builder.id;
        //this.plannedPlaces = builder.plannedPlaces;
        this.dailyPlan = builder.dailyPlan;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long schedulerId;


//    @ManyToMany(mappedBy = "scheduler", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//    private List<Place> plannedPlaces;

    @JsonProperty("daily_plan")
    private String dailyPlan;

    public Long getSchedulerID() {
        return schedulerId;
    }

    public void setSchedulerID(Long schedulerId) {
        this.schedulerId = schedulerId;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    private LocalDate date;

    public static class Builder {
        public void setId(Long id) {
            this.id = id;
        }

        public void setPlannedPlaces(List<Place> plannedPlaces) {
            this.plannedPlaces = plannedPlaces;
        }

        public void setDailyPlan(String dailyPlan) {
            this.dailyPlan = dailyPlan;
        }

        private Long id;

        private List<Place> plannedPlaces;

        @JsonProperty("daily_plan")
        private String dailyPlan;

        public Scheduler build() {
            return new Scheduler(this);
        }
    }
}