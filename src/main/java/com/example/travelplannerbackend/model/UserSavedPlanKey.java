package com.example.travelplannerbackend.model;

import java.time.LocalDate;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserSavedPlanKey implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;

    private String planId;

    public UserSavedPlanKey() {}

    public UserSavedPlanKey(String username, String placeId) {
        this.username = username;
        this.planId = placeId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSchedulerId() {
        return username;
    }

    public void setSchedulerId(String schedulerId) {
        this.username = schedulerId;
    }

    public String getPlaceId() {
        return planId;
    }

    public void setPlaceId(String placeId) {
        this.planId = placeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSavedPlanKey that = (UserSavedPlanKey) o;
        return username.equals(that.username) && planId.equals(that.planId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, planId);
    }
}