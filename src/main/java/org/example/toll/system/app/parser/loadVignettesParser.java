package org.example.toll.system.app.parser;

import org.example.toll.system.app.entities.MotorwayVignette;
import org.example.toll.system.app.entities.Vehicle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class loadVignettesParser {
    public String loadVignettesParser(ArrayList<MotorwayVignette> vignettes, Vehicle vehicle) {
        JSONArray vignettesJSON = new JSONArray();
        JSONObject vehicleJson = new JSONObject();
        JSONObject dto = new JSONObject();
        try {
            vehicleJson.put("model", vehicle.model);
            vehicleJson.put("registrationNumber", vehicle.registrationNumber);
            vehicleJson.put("make", vehicle.make);
            vehicleJson.put("numberOfSeats", vehicle.numberOfSeats);
            vehicleJson.put("vehicleType", vehicle.vehicleType);
            for (MotorwayVignette vignette: vignettes) {
                JSONObject vignetteJSON = new JSONObject();
                vignetteJSON.put("motorwayVignetteType",vignette.motorwayVignetteType);
                vignetteJSON.put("vehicleCategory",vignette.vehicleCategory);
                vignetteJSON.put("price",vignette.price);
                vignetteJSON.put("validTo",vignette.validTo);
                vignetteJSON.put("validFrom",vignette.validFrom);
                vignetteJSON.put("dateOfPurchase",vignette.dateOfPurchase);
                vignettesJSON.put(vignetteJSON);
            }
            dto.put("vignettes", vignettesJSON);
            dto.put("vehicle", vehicleJson);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return dto.toString();
    }
}
