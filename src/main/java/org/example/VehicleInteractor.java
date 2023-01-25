package org.example;

import org.example.controller.VehicleRequestInterface;
import org.example.entity.Vehicle;
import org.example.presenter.VehicleResponseInterface;
import org.example.repository.RepositoryAccess;
import org.example.utils.JSONParser;
import org.json.JSONObject;

public class VehicleInteractor implements VehicleRequestInterface {

    RepositoryAccess repositoryAccess;
    VehicleResponseInterface vehicleResponseInterface;

    public VehicleResponseInterface getVehicleResponseInterface() {
        return vehicleResponseInterface;
    }

    public void setVehicleResponseInterface(VehicleResponseInterface vehicleResponseInterface) {
        this.vehicleResponseInterface = vehicleResponseInterface;
    }

    public VehicleInteractor(RepositoryAccess repositoryAccess, VehicleResponseInterface vehicleResponseInterface) {
        this.repositoryAccess = repositoryAccess;
        this.vehicleResponseInterface = vehicleResponseInterface;
    }

    @Override
    public void getVehicleById(JSONObject json) {

        Vehicle vehicle = repositoryAccess.getVehicleByRegistrationNumber(JSONParser.parseFindRequestJson(json).getRegistrationNumber());
        JSONObject vehicleJson = JSONParser.createResponseJson(vehicle);
        vehicleResponseInterface.displayFind(vehicleJson);
    }

    @Override
    public void save(JSONObject vehicleJson) {
        Vehicle vehicle = repositoryAccess.registerVehicle(JSONParser.parseJSONtoVehicleModel(vehicleJson));
        JSONObject saveResponseJson = JSONParser.createResponseJson(vehicle);
        vehicleResponseInterface.displaySave(saveResponseJson);
    }
}
