package org.example.toll.system.app.validator;

import org.example.toll.system.app.entities.MotorwayVignette;

public class VignettesValidator {
    public void validateString(String v) {
        if (v == null) {
            throw new RuntimeException("Hiba");
        }
    }

}
