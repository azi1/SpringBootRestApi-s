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

import com.example.assignment.service.FeatureService;
import com.example.assignment.model.Feature;

@RestController
@RequestMapping(path = "api/v1/car")
public class FeatureController {

    private final FeatureService featureService;

    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;

    }

    @GetMapping(path= "{carId}/feature")
    public List<Feature> getCarFeatures(@PathVariable("carId") Long carId) {
        return featureService.getCarFeatures(carId);
    }

    @PostMapping(path= "{carId}/feature")
    public void addCarFeatures(@PathVariable("carId") Long carId, @RequestBody Feature feature) {
        featureService.addCarFeatures(carId, feature);
    }

    @DeleteMapping(path= "{carId}/feature/{id}")
    public void deleteFeature(@PathVariable("id") Long id) {
        featureService.deleteFeature(id);
    }
    @PatchMapping(path= "{carId}/feature/{id}")
    public void updateFeature(@PathVariable("id") Long id, @RequestBody Map<String, Object> fields) {
        featureService.updateFeature(id, fields);
    }
    
}
