package com.example.assignment.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;


import com.example.assignment.model.Feature;
import com.example.assignment.repository.CarRepository;
import com.example.assignment.repository.FeatureRepository;

@Service
public class FeatureService {

    private final FeatureRepository featureRepository;
    private final CarRepository carRepository;

    @Autowired
    public FeatureService(FeatureRepository featureRepository, CarRepository carRepository) {
        this.featureRepository = featureRepository;
        this.carRepository = carRepository;
    }

    public List<Feature> getCarFeatures(Long Id) {
        return featureRepository.findByCarId(Id);
    }

    public void addCarFeatures(Long carId, Feature feature) {
       carRepository.findById(carId).map(car -> {
        feature.setCar(car);
        return featureRepository.save(feature);
       }).orElseThrow(() -> new IllegalStateException("car with id " + carId + " does not exist"));
   
    }

    public void deleteFeature(Long id) {
        boolean exists = featureRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Feature with id " + id + " does not exist");
        }
        featureRepository.deleteById(id);
    }

    public Feature updateFeature(Long id, Map<String, Object> fields) {
        Optional<Feature> existingFeature = featureRepository.findById(id);
               
        if(existingFeature.isPresent()) {
            fields.forEach((key, value) ->  {
                Field field = ReflectionUtils.findField(Feature.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingFeature.get(), value);
            });

            return featureRepository.save(existingFeature.get());

        }
         throw new IllegalStateException("feature not found");
     
    }

}
