package com.example.assignment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.service.InteriorService;
import com.example.assignment.model.Interior;

@RestController
@RequestMapping(path = "api/v1/car")
public class InteriorController {

    private final InteriorService interiorService;

    public InteriorController(InteriorService interiorService) {
        this.interiorService = interiorService;

    }

    @GetMapping(path= "{carId}/interior")
    public List<Interior> getCarInteriors(@PathVariable("carId") Long carId) {
        return interiorService.getCarInteriors(carId);
    }

    @PostMapping(path= "{carId}/interior")
    public void addCarInterior(@PathVariable("carId") Long carId, @RequestBody Interior interior) {
        interiorService.addCarInterior(carId, interior);
    }

    @DeleteMapping(path= "{carId}/interior/{id}")
    public void deleteInterior(@PathVariable("id") Long id) {
        interiorService.deleteInterior(id);
    }
    @PatchMapping(path= "{carId}/interior/{id}")
    public void updateInterior(@PathVariable("id") Long id, @RequestBody Map<String, Object> fields) {
        interiorService.updateInterior(id, fields);
    }

    
}
