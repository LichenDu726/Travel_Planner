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
@Table(name = "user_saved_plan1")
@JsonDeserialize(builder = com.example.travelplannerbackend.model.UserSavedPlan.Builder.class)
@IdClass(UserSavedPlanKey.class)
public class UserSavedPlan implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private String username;

    @Id
    private String planId;

    public UserSavedPlan() {}

    public UserSavedPlan(Builder builder){
        this.username = builder.username;
        this.planId = builder.planId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public static class Builder {
        private String username;
        private String planId;

        public String getUsername() {
            return username;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public String getPlanId() {
            return planId;
        }

        public Builder setPlanId(String planId) {
            this.planId = planId;
            return this;
        }

        public UserSavedPlan build() {
            return new UserSavedPlan(this);
        }
    }

}