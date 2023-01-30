package com.example.assignment.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.example.assignment.model.Interior;
import com.example.assignment.repository.CarRepository;
import com.example.assignment.repository.InteriorRepository;

@Service
public class InteriorService {

    private final InteriorRepository interiorRepository;
    private final CarRepository carRepository;

    @Autowired
    public InteriorService(InteriorRepository interiorRepository, CarRepository carRepository) {
        this.interiorRepository = interiorRepository;
        this.carRepository = carRepository;
    }

    public List<Interior> getCarInteriors(Long carId) {
        return  interiorRepository.findByCarId(carId);
    }

    public void addCarInterior(Long carId, Interior interior) {
        carRepository.findById(carId).map(car -> {
            interior.setCar(car);
            return interiorRepository.save(interior);
           }).orElseThrow(() -> new IllegalStateException("car with id " + carId + " does not exist"));
    }

    public void deleteInterior(Long id) {
        boolean exists = interiorRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Interior with id " + id + " does not exist");
        }
        interiorRepository.deleteById(id);
    }

    public Interior updateInterior(Long id, Map<String, Object> fields) {
        Optional<Interior> existingInterior = interiorRepository.findById(id);
               
        if(existingInterior.isPresent()) {
            fields.forEach((key, value) ->  {
                Field field = ReflectionUtils.findField(Interior.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingInterior.get(), value);
            });

            return interiorRepository.save(existingInterior.get());

        }
         throw new IllegalStateException("Interior not found");
    }

    
}
