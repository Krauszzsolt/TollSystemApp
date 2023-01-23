package org.example.toll.system.app.validator;

import org.example.app.entity.Vehicle;
import org.example.app.exceptions.VehicelNotValidException;

public class VehicleValidator {
    public void validateString(String v) {
        if (v == null) {
            throw new VehicelNotValidException("Hiba");
        }
    }

    public void validateEntity(Vehicle v) {
        if (v == null) {
            throw new VehicelNotValidException("Hiba");
        }
    }
}
