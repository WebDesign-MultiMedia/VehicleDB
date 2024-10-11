package com.LogMasterVehicle.DB;

import com.LogMasterVehicle.DB.model.MaintenanceRepair;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaintenanceRepairTest {
    @Test
    public void testMaintenanceRepair() {
        MaintenanceRepair maintenanceRepair = new MaintenanceRepair();
        maintenanceRepair.setId(1);
        maintenanceRepair.setDate(new Date());
        maintenanceRepair.setMileage(10000);
        maintenanceRepair.setMaintenance_repair("Oil Change");
        maintenanceRepair.setParts("Oil Filter");
        maintenanceRepair.setVehicleSide("Front");
        maintenanceRepair.setServiceProvider("Jiffy Lube");
        maintenanceRepair.setServiceProviderLocation("1234 Main St");
        maintenanceRepair.setCostOfService(50.0);
        maintenanceRepair.setNextServiceDue("2022-01-01");
        maintenanceRepair.setReceipt_InvoiceNumber(12345);
        maintenanceRepair.setNote_Issues("None");
        assertEquals(10000, maintenanceRepair.getMileage());
        assertEquals("Oil Change", maintenanceRepair.getMaintenance_repair());
        assertEquals("Oil Filter", maintenanceRepair.getParts());
        assertEquals("Front", maintenanceRepair.getVehicleSide());
        assertEquals("Jiffy Lube", maintenanceRepair.getServiceProvider());
        assertEquals("1234 Main St", maintenanceRepair.getServiceProviderLocation());
        assertEquals(50.0, maintenanceRepair.getCostOfService());
        assertEquals("2022-01-01", maintenanceRepair.getNextServiceDue());
        assertEquals(12345, maintenanceRepair.getReceipt_InvoiceNumber());
        assertEquals("None", maintenanceRepair.getNote_Issues());
    }
}
