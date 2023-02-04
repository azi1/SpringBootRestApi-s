package com.example.assignment.mapper;

import com.example.assignment.dto.CarDto;
import com.example.assignment.dto.CarDetailsDto;
import com.example.assignment.model.Car;

public class CarMapper {

    public static CarDto mapToCarDto(Car car) {
        CarDto carDto = new CarDto(
                car.getId(),
                car.getCarMake(),
                car.getModel(),
                car.getPriceStartFrom()
                );

        return carDto;

    }

    public static Car maptToCar(CarDto carDto) {

        Car car = new Car(
            carDto.getCarMake(),
            carDto.getModel(),
            carDto.getPriceStartFrom()
        );

        return car;
    }

    public static CarDetailsDto mapToCarDetailsDto(Car car) {
        CarDetailsDto carDto = new CarDetailsDto(
                car.getId(),
                car.getCarMake(),
                car.getModel(),
                car.getPriceStartFrom(),
                car.getFeature(),
                car.getExteriorColors(),
                car.getInteriorType()
                
                );

        return carDto;

    }

}
