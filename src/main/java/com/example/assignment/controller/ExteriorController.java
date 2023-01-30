package com.example.assignment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.service.ExteriorService;
import com.example.assignment.model.Exterior;

@RestController
@RequestMapping(path = "api/v1/car")
public class ExteriorController {

    private final ExteriorService exteriorService;

    @Autowired
    public ExteriorController(ExteriorService exteriorService) {
        this.exteriorService = exteriorService;
    }

    @GetMapping(path= "{carId}/exterior")
    public List<Exterior> getCarExterior(@PathVariable("carId") Long carId) {
        return exteriorService.getCarExterior(carId);
    }

    @PostMapping(path= "{carId}/exterior")
    public void addCarExterior(@PathVariable("carId") Long carId, @RequestBody Exterior exterior) {
        exteriorService.addCarExterior(carId, exterior);
    }

    @DeleteMapping(path= "{carId}/exterior/{id}")
    public void deleteExterior(@PathVariable("id") Long id) {
        exteriorService.deleteExterior(id);
    }
    @PatchMapping(path= "{carId}/exterior/{id}")
    public void updateExterior(@PathVariable("id") Long id, @RequestBody Map<String, Object> fields) {
        exteriorService.updateExterior(id, fields);
    }

    
}
