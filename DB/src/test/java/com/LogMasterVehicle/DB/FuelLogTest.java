package com.LogMasterVehicle.DB;

import com.LogMasterVehicle.DB.model.FuelLog;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuelLogTest {
    @Test
    public void testFuelLog() {
        FuelLog fuelLog = new FuelLog();
        fuelLog.setId(1);
        fuelLog.setDate(new Date());
        fuelLog.setGallon_LiterPurchased(10.0);
        fuelLog.setPricePerGallon_Liter(2.0);
        fuelLog.setTotalCost(20.0);
        fuelLog.setFuelType("Gasoline");
        fuelLog.setGasStationName("Shell");
        fuelLog.setGasStationLocation("1234 Main St");
        fuelLog.setPaymentMethod("Credit Card");
        fuelLog.setOdometerReading(10000);
        fuelLog.setTripPurpose("Work");
        fuelLog.setFuelEfficiency("10.0");
        assertEquals(2.0, fuelLog.getPricePerGallon_Liter());
        assertEquals(20.0, fuelLog.getTotalCost());
        assertEquals("Gasoline", fuelLog.getFuelType());
        assertEquals("Shell", fuelLog.getGasStationName());
        assertEquals("1234 Main St", fuelLog.getGasStationLocation());
        assertEquals("Credit Card", fuelLog.getPaymentMethod());
        assertEquals(10000, fuelLog.getOdometerReading());
        assertEquals("Work", fuelLog.getTripPurpose());
        assertEquals("10.0", fuelLog.getFuelEfficiency());
    }
}
