package org.example.toll.system.app.validator;

import org.example.app.exceptions.VehicelNotValidException;
import org.example.toll.system.app.entities.MotorwayVignette;

public class VignettesValidator {
    public void validateString(String v) {
        if (v == null) {
            throw new VehicelNotValidException("Hiba");
        }
    }

    public void validateEntity(MotorwayVignette v) {
        if (v == null) {
            throw new VehicelNotValidException("Hiba");
        }
    }

}
