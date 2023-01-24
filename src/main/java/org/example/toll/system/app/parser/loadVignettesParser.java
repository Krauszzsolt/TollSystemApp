package org.example.toll.system.app.parser;

import org.example.toll.system.app.entities.MotorwayVignette;
import org.example.toll.system.app.entities.Vehicle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class loadVignettesParser {
    public String parseToResponseModel(ArrayList<MotorwayVignette> vignettes, Vehicle vehicle) {
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
                vignetteJSON.put("validTo",getValidTo(vignette).toString());
                vignetteJSON.put("validFrom",vignette.validFrom.toString());
                vignetteJSON.put("dateOfPurchase",vignette.dateOfPurchase.toString());
                vignetteJSON.put("isValid", isValid(vignette));
                vignettesJSON.put(vignetteJSON);
            }
            dto.put("vignettes", vignettesJSON);
            dto.put("vehicle", vehicleJson);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return dto.toString();
    }

    private boolean isValid(MotorwayVignette vignette){
        Date today = new Date();
        return vignette.validFrom.compareTo(today) * today.compareTo(getValidTo(vignette)) >= 0;
    }

    private Date getValidTo(MotorwayVignette vignette) {
        Calendar c = Calendar.getInstance();
        c.setTime(vignette.validFrom);
        switch(vignette.motorwayVignetteType) {
            case "10days":
                c.add(Calendar.DATE, 10);
                break;
            case "monthly":
                c.add(Calendar.MONTH, 1);

                break;
            case "yearly":
                c.add(Calendar.YEAR, 1);
                break;
            default:break;
        }
        return c.getTime();
    }
}
