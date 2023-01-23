package org.example.toll.system.app.storage;

import org.example.toll.system.app.entities.MotorwayVignette;

import java.util.ArrayList;

public interface TollSystempersistenceStorage {
    ArrayList<MotorwayVignette> loadVignettesByRegistrationNumber(String RegistrationNumber);
}
