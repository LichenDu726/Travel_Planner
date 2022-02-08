package com.example.travelplannerbackend.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
@Entity
@Table(name = "city_list")
@JsonDeserialize(builder = City.Builder.class)
public class CityList implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String cityName;

    @OneToOne
    @JoinColumn(name = "city_name")
    private City city;

    public CityList() {
    }

    public CityList(Builder builder) {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCityName() {
        return cityName;
    }

    public City getCity() {
        return city;
    }


    public static class Builder {
        private String cityName;
        private City city;

        public Builder setCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }
        public Builder setCity(City city) {
            this.city = city;
            return this;
        }
        public CityList build() {
            return new CityList(this);
        }
    }
}