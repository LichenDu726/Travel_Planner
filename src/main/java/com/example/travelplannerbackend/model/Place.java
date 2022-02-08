package com.example.travelplannerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "place")
@JsonDeserialize(builder = Place.Builder.class)
public class Place implements Serializable{
    private static final long serialVersionUID = 1L;;

    // place id, name, address, geolocation, category, description
    // City, duration, picture url;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;

    @JsonProperty("latitude")
    private String latitude;

    @JsonProperty("longtitude")
    private String longtitude;

    @JsonProperty("category")
    private PlaceCategory category;

    @JsonProperty("description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "city_name")
    @JsonIgnore
    private City city;
    // question: duration in hours?

    @JsonProperty("duration")
    private int duration;

    @JsonProperty("url")
    private String url;

//    @ManyToMany
//    @JsonIgnore
//    private List<Scheduler> scheduler;

    // constructor
    public Place () {}

    private Place(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.latitude = builder.latitude;
        this.longtitude = builder.longtitude;
        this.category = builder.category;
        this.description = builder.description;
        this.duration = builder.duration;
        this.url = builder.url;
        this.city = builder.city;
        //this.scheduler = builder.scheduler;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public PlaceCategory getCategory() {
        return category;
    }

    public void setCategory(PlaceCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //public List<Scheduler> getScheduler() {
//        return scheduler;
//    }

   // public void setScheduler(List<Scheduler> scheduler) {
//        this.scheduler = scheduler;
//    }

    public static class Builder {
        @JsonProperty("id")
        private Long id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("address")
        private String address;

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public void setLongtitude(String longtitude) {
            this.longtitude = longtitude;
        }

        // private String geolocation;
        @JsonProperty("latitude")
        private String latitude;

        @JsonProperty("longtitude")
        private String longtitude;

        @JsonProperty("category")
        private PlaceCategory category;

        @JsonProperty("description")
        private String description;


        private City city;
        // question: duration in hours?

        @JsonProperty("duration")
        private int duration;

        @JsonProperty("url")
        private String url;

//        private List<Scheduler> scheduler;
//
//        public List<Scheduler> getScheduler() {
//            return scheduler;
//        }

//        public Builder setScheduler(List<Scheduler> scheduler) {
//            this.scheduler = scheduler;
//            return this;
//        }

        public void setId(Long id) {
            this.id = id;
        }

        public Place.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Place.Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Place.Builder setCategory(PlaceCategory category) {
            this.category = category;
            return this;
        }

        public Place.Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Place.Builder setCity(City city) {
            this.city = city;
            return this;
        }

        public Place.Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public Place.Builder setUrl(String url) {
            this.url = url;
            return this;
        }
        public Place build() {
            return new Place(this);
        }
    }
}
