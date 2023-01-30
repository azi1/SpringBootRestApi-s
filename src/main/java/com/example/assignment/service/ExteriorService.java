package com.example.assignment.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.example.assignment.model.Exterior;
import com.example.assignment.repository.CarRepository;
import com.example.assignment.repository.ExteriorRepository;
import java.lang.reflect.Field;



@Service
public class ExteriorService {
    private final CarRepository carRepository;
    private final ExteriorRepository exteriorRepository;

    public ExteriorService(CarRepository carRepository, ExteriorRepository exteriorRepository) {
        this.carRepository = carRepository;
        this.exteriorRepository = exteriorRepository;
    }


    public List<Exterior> getCarExterior(Long carId) {
        return exteriorRepository.findByCarId(carId);
    }

    public void addCarExterior(Long carId, Exterior exterior) {
        carRepository.findById(carId).map(car -> {
        exterior.setCar(car);
            return exteriorRepository.save(exterior);
           }).orElseThrow(() -> new IllegalStateException("car with id " + carId + " does not exist"));
    }

    public void deleteExterior(Long id) {
        boolean exists = exteriorRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Exterior with id " + id + " does not exist");
        }
        exteriorRepository.deleteById(id);
    }

    public Exterior updateExterior(Long id, Map<String, Object> fields) {
        Optional<Exterior> existingExterior = exteriorRepository.findById(id);
               
        if(existingExterior.isPresent()) {
            fields.forEach((key, value) ->  {
                Field field = ReflectionUtils.findField(Exterior.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingExterior.get(), value);
            });

            return exteriorRepository.save(existingExterior.get());

        }
         throw new IllegalStateException("exterior not found");
    }

    
}
