package com.carmanagement.model;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Model class representing a car in the rental fleet.
 */
public class CarInfo {
    private static final AtomicLong ID_GENERATOR = new AtomicLong(1);
    
    public Long id;
    public String make;
    public String model;
    public Integer year;
    public CarStatus status;
    public String condition;
    
    public CarInfo() {
        this.id = ID_GENERATOR.getAndIncrement();
    }
    
    public CarInfo(String make, String model, Integer year, CarStatus status) {
        this();
        this.make = make;
        this.model = model;
        this.year = year;
        this.status = status;
        this.condition = "Good";
    }
}

// Made with Bob
