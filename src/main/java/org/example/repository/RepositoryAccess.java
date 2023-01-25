package org.example.repository;

import org.example.entity.Vehicle;

public interface RepositoryAccess {
    Vehicle registerVehicle(Vehicle vehicle);
    Vehicle getVehicleByRegistrationNumber(String registrationNumber);
}
