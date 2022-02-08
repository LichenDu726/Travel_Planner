package com.example.travelplannerbackend.repository;

import com.example.travelplannerbackend.model.City;
import com.example.travelplannerbackend.model.Place;
import com.example.travelplannerbackend.model.PlaceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findByCity(City city);

   // @Query(value = "SELECT id, name, category from Place WHERE (city.cityName = 'New York' AND category = 1)")
   //@Query(value = "SELECT id, name, category from Place WHERE category = ?1")
    List<Place> findDistinctByCityAndCategory(City city, PlaceCategory category);

    List<Place> findByCategory(PlaceCategory category);

//    // @Query(value = "SELECT id, name, category FROM Place WHERE ( name LIKE '%keyword%' OR category = ?2)")
//    @Query(value = "SELECT id, name, category FROM Place WHERE ( name LIKE '%keyword%')")
//    //List<Place> findPlaceByKeywords(String keyword, PlaceCategory searchCategory);
//    List<Place> findPlaceByKeywords(String keyword);

    List<Place> findAllByNameContaining(String keyword);

    List<Place> findDistinctByCityAndNameContaining(City city, String keyword);

    //Place getById(Long id);
    //Place findById(Long id);
}
