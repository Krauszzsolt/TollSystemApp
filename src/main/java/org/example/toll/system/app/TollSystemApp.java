package org.example.toll.system.app;


import org.example.toll.system.app.entities.MotorwayVignette;
import org.example.toll.system.app.entities.RequestDto;
import org.example.toll.system.app.entities.Vehicle;
import org.example.toll.system.app.API.TollSystemPresenter;
import org.example.toll.system.app.plugin.VehiclePlugin;
import org.example.toll.system.app.storage.TollSystempersistenceStorage;
import org.example.toll.system.app.API.loadVignettesByCarRegistrationNumberAPI;
import org.example.toll.system.app.parser.VehicleParser;
import org.example.toll.system.app.parser.loadVignettesParser;
import org.example.toll.system.app.validator.VignettesValidator;

import java.util.ArrayList;

public class TollSystemApp implements loadVignettesByCarRegistrationNumberAPI {

    private VignettesValidator vignettesValidator = new VignettesValidator();
    private loadVignettesParser loadVignettesParser = new loadVignettesParser();
    private VehicleParser vehicleParser = new VehicleParser();

    private VehiclePlugin vehiclePlugin;
    private TollSystempersistenceStorage tollSystempersistenceStorage;
    private TollSystemPresenter presenter;

    public TollSystemApp( TollSystempersistenceStorage tollSystempersistenceStorage, TollSystemPresenter presenter, VehiclePlugin vehiclePlugin) {
        this.tollSystempersistenceStorage = tollSystempersistenceStorage;
        this.presenter = presenter;
        this.vehiclePlugin = vehiclePlugin;
    }



    @Override
    public void loadVignettesByCarRegistrationNumber(String registrationNumberJSON) {
        vignettesValidator.validateString(registrationNumberJSON);
        RequestDto regNumber = vehicleParser.JsonToRegistrationRequestDto(registrationNumberJSON);
        Vehicle vehicle = vehiclePlugin.getVehicleByRegistrationNumber(regNumber.regisrationNumber);
        ArrayList<MotorwayVignette> vignettes = tollSystempersistenceStorage.loadVignettesByRegistrationNumber(regNumber.regisrationNumber);
        String dto = loadVignettesParser.parseToResponseModel(vignettes,vehicle);
        presenter.displayVignette(dto);
    }
}
