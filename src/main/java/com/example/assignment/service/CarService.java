package com.example.assignment.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.example.assignment.model.Car;
import com.example.assignment.repository.CarRepository;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void addNewCar(Car car) {
        carRepository.save(car);
    }

    public void deleteCar(Long carId) {
        boolean exists = carRepository.existsById(carId);
        if (!exists) {
            throw new IllegalStateException("Car with id " + carId + " does not exist");
        }
        carRepository.deleteById(carId);
    }

    public Car updateCar(Long carId, Map<String, Object> fields) {
        Optional<Car> existingCar = carRepository.findById(carId);
               
        if(existingCar.isPresent()) {
            fields.forEach((key, value) ->  {
                Field field = ReflectionUtils.findField(Car.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingCar.get(), value);
            });

            return carRepository.save(existingCar.get());

        }
         throw new IllegalStateException("Car not found");
     
    }


}
