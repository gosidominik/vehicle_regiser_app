package org.example.utils;

import org.example.entity.Vehicle;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {
    public static Vehicle parseJSONtoVehicleModel(JSONObject object) {
        Vehicle vehicle = new Vehicle();
        try {
            vehicle.setRegistrationNumber(object.getString("registrationNumber"));
            vehicle.setMake(object.getString("make"));
            vehicle.setModel(object.getString("model"));
            vehicle.setNumberOfSeats(object.getString("numberOfSeats"));
            vehicle.setVehicleType(object.getString("vehicleType"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return vehicle;
    }

    public static Vehicle parseFindRequestJson(JSONObject json) {
        Vehicle vehicle = new Vehicle();
        try {
            vehicle.setRegistrationNumber(json.getString("registrationNumber"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    public static JSONObject createResponseJson(Vehicle vehicle) {
        JSONObject json = new JSONObject();
        try {
            if (!vehicle.isEmpty()) {
                json.put("registrationNumber", vehicle.getRegistrationNumber());
                json.put("make", vehicle.getMake());
                json.put("model", vehicle.getModel());
                json.put("numberOfSeats", vehicle.getNumberOfSeats());
                json.put("vehicleType", vehicle.getVehicleType());
                json.put("message", vehicle.getMessage());
            } else {
                json.put("registrationNumber", "");
                json.put("make", "");
                json.put("model", "");
                json.put("numberOfSeats", "");
                json.put("vehicleType", "");
                json.put("message", vehicle.getMessage());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
return json;
    }
}
