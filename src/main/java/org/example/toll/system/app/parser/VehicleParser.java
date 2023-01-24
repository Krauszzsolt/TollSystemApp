package org.example.toll.system.app.parser;

import org.example.toll.system.app.entities.RequestDto;
import org.example.toll.system.app.entities.Vehicle;
import org.json.JSONException;
import org.json.JSONObject;

public class VehicleParser {

    public RequestDto JsonToRegistrationRequestDto(String jsonInput) {
        JSONObject registrationNumber;
        try {
            registrationNumber = new JSONObject(jsonInput);
            RequestDto dto = new RequestDto();
            dto.regisrationNumber = registrationNumber.getString("regNumber");
            return dto;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
