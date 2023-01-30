package com.example.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment.model.Feature;

public interface FeatureRepository extends JpaRepository<Feature, Long> {

    List<Feature> findByCarId(Long id);
    
}
