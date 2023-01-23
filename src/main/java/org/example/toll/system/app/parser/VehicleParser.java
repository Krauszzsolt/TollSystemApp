package org.example.toll.system.app.parser;

import org.example.toll.system.app.entities.Vehicle;
import org.json.JSONException;
import org.json.JSONObject;

public class VehicleParser {
    public Vehicle StringToEntity(String v) {
        JSONObject vehicle;
        String model;
        String registrationNumber;
        String make;
        Integer numberOfSeats;
        String vehicleType;
        try {
            vehicle = new JSONObject(v);
            model = vehicle.getString("model");
            registrationNumber = vehicle.getString("registrationNumber");
            make = vehicle.getString("make");
            numberOfSeats = vehicle.getInt("numberOfSeats");
            vehicleType = vehicle.getString("vehicleType");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return new Vehicle(model, registrationNumber, make, numberOfSeats, vehicleType);
    }

    public String RegistrationNumberToJson(String r) {
        JSONObject registrationNumber = new JSONObject();
        try {
            registrationNumber.put("registrationNumber", r);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return registrationNumber.toString();
    }

    public String JsonToRegistrationNumber(String r) {
        JSONObject registrationNumber;
        try {
            registrationNumber = new JSONObject(r);
            return registrationNumber.getString("registrationNumber");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
