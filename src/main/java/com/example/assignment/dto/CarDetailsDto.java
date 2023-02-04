package com.example.assignment.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.assignment.model.Exterior;
import com.example.assignment.model.Feature;
import com.example.assignment.model.Interior;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarDetailsDto {

    private long id;
    private String carMake;
    private String model;
    private String priceStartFrom;
    private List<Feature> feature = new ArrayList<>();
    private List<Exterior> exteriorColors = new ArrayList<>();
    private List<Interior> interiorType = new ArrayList<>();
    
}
