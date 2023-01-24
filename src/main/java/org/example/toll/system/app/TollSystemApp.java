package org.example.toll.system.app;


import org.example.app.VehicleRegister;
import org.example.app.interfaces.Presenter;
import org.example.toll.system.app.entities.MotorwayVignette;
import org.example.toll.system.app.entities.Vehicle;
import org.example.toll.system.app.API.TollSystemPresenter;
import org.example.toll.system.app.storage.TollSystempersistenceStorage;
import org.example.toll.system.app.API.loadVignettesByCarRegistrationNumberAPI;
import org.example.toll.system.app.parser.VehicleParser;
import org.example.toll.system.app.parser.loadVignettesParser;
import org.example.toll.system.app.validator.VehicleValidator;
import org.example.toll.system.app.validator.VignettesValidator;

import java.util.ArrayList;

public class TollSystemApp implements Presenter, loadVignettesByCarRegistrationNumberAPI {

    private VehicleValidator vehicleValidator = new VehicleValidator();
    private VignettesValidator vignettesValidator = new VignettesValidator();
    private loadVignettesParser loadVignettesParser = new loadVignettesParser();
    private VehicleParser vehicleParser = new VehicleParser();

    private VehicleRegister vehicleRegister;

    private TollSystempersistenceStorage tollSystempersistenceStorage;
    private TollSystemPresenter presenter;

    public TollSystemApp( TollSystempersistenceStorage tollSystempersistenceStorage, TollSystemPresenter presenter) {
        this.tollSystempersistenceStorage = tollSystempersistenceStorage;
        this.presenter = presenter;
    }

    public void setVehicleRegister(VehicleRegister vehicleRegister) {
        this.vehicleRegister = vehicleRegister;
    }

    @Override
    public void DisplayVehicle(String data) {
        vehicleValidator.validateString(data);
        Vehicle vehicle = vehicleParser.StringToEntity(data);
        ArrayList<MotorwayVignette> vignettes = tollSystempersistenceStorage.loadVignettesByRegistrationNumber(vehicle.registrationNumber);
        String dto = loadVignettesParser.loadVignettesParser(vignettes,vehicle);
        presenter.displayVignette(dto);
    }

    @Override
    public void DisplaySuccess() {

    }

    @Override
    public void DisplayError() {

    }

    @Override
    public void loadVignettesByCarRegistrationNumber(String registrationNumberJSON) {
        vignettesValidator.validateString(registrationNumberJSON);
        vehicleRegister.loadVehicle(registrationNumberJSON);
    }
}
