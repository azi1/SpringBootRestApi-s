package com.example.assignment.model;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Interior {
    @Id
    @SequenceGenerator(name = "interior_sequence", sequenceName = "interior_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interior_sequence")

    private Long id;
    private String type;
    private String price;
    @ManyToOne
    @JoinColumn(name= "car_id")
    private Car car;



    public Interior(String type, String price, Car car) {
        this.type = type;
        this.price = price;
        this.car = car;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
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
