package com.example.assignment.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.example.assignment.dto.CarDetailsDto;
import com.example.assignment.dto.CarDto;
import com.example.assignment.mapper.CarMapper;
import com.example.assignment.model.Car;
import com.example.assignment.repository.CarRepository;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public ResponseEntity<?> getAllCars() {
        List<Car> carList = carRepository.findAll();
        List<CarDto> carDtoList = carList.stream().map(CarMapper::mapToCarDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(carDtoList, HttpStatus.OK);

    }

    public ResponseEntity<?> addNewCar(CarDto carDto) {
        try {
            Car car = CarMapper.maptToCar(carDto);
            Car savedCar = carRepository.save(car);
            CarDto carDtoCreated = CarMapper.mapToCarDto(savedCar);
            return new ResponseEntity<>(carDtoCreated, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_GATEWAY);
        }
    }

    public ResponseEntity<?> deleteCar(Long carId) {
        boolean exists = carRepository.existsById(carId);
        if (!exists) {
            return new ResponseEntity<>("Car with ID :" + carId + " not exist", HttpStatus.BAD_REQUEST);
        }
        carRepository.deleteById(carId);
        return new ResponseEntity<>("Car with ID :" + carId + " deleted successfully", HttpStatus.OK);
    }

    public ResponseEntity<?> updateCar(Long carId, Map<String, Object> fields) {
        try {
            Optional<Car> existingCar = carRepository.findById(carId);
            if (existingCar.isPresent()) {
                fields.forEach((key, value) -> {
                    Field field = ReflectionUtils.findField(Car.class, key);
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, existingCar.get(), value);
                });

                Car car = carRepository.save(existingCar.get());
                return new ResponseEntity<>(CarMapper.mapToCarDto(car), HttpStatus.OK);

            } else {
                return new ResponseEntity<>("Car with ID :" + carId + " not exist", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error in updating car",
                    HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    public ResponseEntity<?> getCarById(Long carId) {
        Optional<Car> existingCar = carRepository.findById(carId);

        if(existingCar.isPresent()) {
            Car car  = existingCar.get();
            CarDetailsDto carDtoDetails = CarMapper.mapToCarDetailsDto(car);
            return new ResponseEntity<>(carDtoDetails, HttpStatus.OK);
        }

        return new ResponseEntity<>("Car with ID :" + carId + " not exist", HttpStatus.BAD_REQUEST);
    }

}
