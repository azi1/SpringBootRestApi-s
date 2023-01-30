package com.example.assignment.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.assignment.model.Exterior;

public interface ExteriorRepository extends JpaRepository<Exterior, Long> {
    
    List<Exterior> findByCarId(Long id);
    
} 
    

