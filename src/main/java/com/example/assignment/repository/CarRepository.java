package com.example.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
    
}
