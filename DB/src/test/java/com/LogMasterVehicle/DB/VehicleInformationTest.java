package com.LogMasterVehicle.DB;

import com.LogMasterVehicle.DB.model.VehicleInformation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleInformationTest {
    @Test
    public void testVehicleInformation() {
        VehicleInformation vehicleInformation = new VehicleInformation();
        vehicleInformation.setId(1);
        vehicleInformation.setMake("Toyota");
        vehicleInformation.setModel("Camry");
        vehicleInformation.setYear(2021);
        vehicleInformation.setVin("4T1C11AK0MU123456");
        assertEquals("Toyota", vehicleInformation.getMake());
    }

}