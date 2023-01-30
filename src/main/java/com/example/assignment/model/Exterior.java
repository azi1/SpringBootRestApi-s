package com.example.assignment.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Exterior {
    @Id
    @SequenceGenerator(name = "exterior_sequence", sequenceName = "exterior_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exterior_sequence")
    private Long id;
    private String color;
    private String price;
    @ManyToOne
    @JoinColumn(name= "car_id")
    private Car car;


    public Exterior(String color, String price, Car car) {
        this.color = color;
        this.price = price;
        this.car = car;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    
}
