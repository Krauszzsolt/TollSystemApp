package org.example.toll.system.app.plugin;

import org.example.toll.system.app.entities.Vehicle;

public interface VehiclePlugin {
    Vehicle getVehicleByRegistrationNumber(String registrationNumber);
}
