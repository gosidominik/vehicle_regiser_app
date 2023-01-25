package org.example;

import org.example.controller.VehicleRequestInterface;
import org.example.entity.Vehicle;
import org.example.exception.NotSupportedInputJson;
import org.example.presenter.VehicleResponseInterface;
import org.example.repository.RepositoryAccess;
import org.example.utils.JSONParser;
import org.example.utils.Validator;
import org.json.JSONException;
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
    public void getVehicleById(String inputData) {
        JSONObject json = null;
        try {
            json = new JSONObject(inputData);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        if (!Validator.validate(json).has("message")) {
            Vehicle vehicle = repositoryAccess.getVehicleByRegistrationNumber(JSONParser.parseFindRequestJson(json).getRegistrationNumber());
            JSONObject vehicleJson = JSONParser.createResponseJson(vehicle);
            vehicleResponseInterface.displayFind(vehicleJson);
        } else {
           throw new NotSupportedInputJson();
        }
    }

    @Override
    public void save(String inputData) {
        JSONObject vehicleJson = null;
        try {
             vehicleJson = new JSONObject(inputData);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        if (!Validator.validate(vehicleJson).has("message")) {
            Vehicle vehicle = repositoryAccess.registerVehicle(JSONParser.parseJSONtoVehicleModel(vehicleJson));
            JSONObject saveResponseJson = JSONParser.createResponseJson(vehicle);
            vehicleResponseInterface.displaySave(saveResponseJson);
        } else {
            vehicleResponseInterface.displaySave(vehicleJson);
        }
    }
}
