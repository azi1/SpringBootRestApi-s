package com.example.assignment.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString   
public class Car {

    @Id
    @SequenceGenerator(name = "car_sequence", sequenceName = "car_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_sequence")

    private long id;
    private String carMake;
    private String model;
    private String priceStartFrom;
 
    @OneToMany(
        mappedBy = "car",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Feature> feature = new ArrayList<>();
    @OneToMany(
        mappedBy = "car",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Exterior> exteriorColors = new ArrayList<>();

    @OneToMany(
        mappedBy = "car",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Interior> interiorType = new ArrayList<>();

    public Car(String carMake, String model, String priceStartFrom) {
        this.carMake = carMake;
        this.model = model;
        this.priceStartFrom = priceStartFrom;
    }

}
