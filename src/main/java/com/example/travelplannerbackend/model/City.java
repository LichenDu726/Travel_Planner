package com.example.travelplannerbackend.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
@Entity
@Table(name = "city")
@JsonDeserialize(builder = City.Builder.class)
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String cityName;

    // ? mappedBy "place" ?
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JsonIgnore
    private List<Place> places;

    public City() {
    }

    public City(Builder builder) {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public static class Builder {
        private String cityName;
        private List<Place> places;


        public Builder setCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public Builder setPlaces(List<Place> places) {
            this.places = places;
            return this;
        }
        public City build() {
            return new City(this);
        }
    }
}
