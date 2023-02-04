package com.example.assignment.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.service.CarService;
import com.example.assignment.dto.CarDto;

@RestController
@RequestMapping(path = "api/v1/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(path = "{carId}")
    public ResponseEntity<?> getCarById(@PathVariable("carId") Long carId) {
        return carService.getCarById(carId);
    }

    @GetMapping
    public ResponseEntity<?> getCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public ResponseEntity<?> addNewCar(@RequestBody CarDto carDto) {
        return carService.addNewCar(carDto);
    }

    @DeleteMapping(path = "{carId}")
    public ResponseEntity<?> deleteCar(@PathVariable("carId") Long carId) {

        return carService.deleteCar(carId);
    }

    @PatchMapping(path = "{carId}")
    public ResponseEntity<?> updateCar(@PathVariable("carId") Long carId, @RequestBody Map<String, Object> fields) {
        return carService.updateCar(carId, fields);

    }

}
