package org.example.entity;

public class Vehicle extends MessagableStorageEntity{
    private String registrationNumber;
    private String make;
    private String model;
    private String numberOfSeats;
    private String vehicleType;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isEmpty() {
        boolean result;

        if(make == null && registrationNumber == null && model == null && numberOfSeats == null && vehicleType == null)
            result = true;
        else
            result = false;

        return result;
    }
}
