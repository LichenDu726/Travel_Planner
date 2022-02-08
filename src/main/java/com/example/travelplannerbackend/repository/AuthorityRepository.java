package com.example.travelplannerbackend.repository;


import com.example.travelplannerbackend.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// first project DAO
public interface AuthorityRepository extends JpaRepository<Authority, String> {

}