package org.example.controller;

import org.json.JSONObject;

public interface VehicleRequestInterface {
    void getVehicleById(JSONObject json);
    void save(JSONObject vehicleJson);
}
