package com.example.travelplannerbackend.model;

import java.time.LocalDate;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

public class PlanPlacesKey implements Serializable {
    private static final long serialVersionUID = 1L;

    private String planId;

    private String placeId;

    public PlanPlacesKey() {}

    public PlanPlacesKey(String planId, String placeId) {
        this.planId = planId;
        this.placeId = placeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanPlacesKey that = (PlanPlacesKey) o;
        return planId.equals(that.planId) && placeId.equals(that.placeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, placeId);
    }
}