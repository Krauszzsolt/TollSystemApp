package org.example.toll.system.app.entities;

public class Vehicle {
    public String registrationNumber;
    public String model;
    public String make;
    public Integer numberOfSeats;
    public String vehicleType;

    public Vehicle(String model, String registrationNumber, String make, Integer numberOfSeats, String vehicleType) {
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.numberOfSeats = numberOfSeats;
        this.vehicleType = vehicleType;
    }
}
