package com.example.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment.model.Interior;

public interface InteriorRepository extends JpaRepository<Interior, Long> {

    List<Interior> findByCarId(Long id);
    
}
