package com.example.assignment.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Feature {
    @Id
    @SequenceGenerator(name = "feature_sequence", sequenceName = "feature_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feature_sequence")

    private long id;
    private String performance;
    private String longRange;
    @ManyToOne
    @JoinColumn(name= "car_id")
    private Car car;


    public Feature(String performance, String longRange, Car car) {
        this.performance = performance;
        this.longRange = longRange;
        this.car = car;
    }

    public String getPerformance() {
        return performance;
    }

    public String getLongRange() {
        return longRange;
    }
    
    public long getId() {
        return id;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public void setLongRange(String longRange) {
        this.longRange = longRange;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    public void setId(long id) {
        this.id = id;
    }

  
}
