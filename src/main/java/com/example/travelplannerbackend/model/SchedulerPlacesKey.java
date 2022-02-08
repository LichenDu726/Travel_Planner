package com.example.travelplannerbackend.model;

import java.time.LocalDate;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SchedulerPlacesKey implements Serializable {
    private static final long serialVersionUID = 1L;

    private String schedulerId;

    private String placeId;

    public SchedulerPlacesKey() {}

    public SchedulerPlacesKey(String schedulerId, String placeId) {
        this.schedulerId = schedulerId;
        this.placeId = placeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchedulerPlacesKey that = (SchedulerPlacesKey) o;
        return schedulerId.equals(that.schedulerId) && placeId.equals(that.placeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schedulerId, placeId);
    }
}