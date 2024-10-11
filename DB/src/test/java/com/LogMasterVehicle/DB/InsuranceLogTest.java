package com.LogMasterVehicle.DB;

import com.LogMasterVehicle.DB.model.InsuranceLog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsuranceLogTest {
    @Test
    void InsuranceLogtest() {
        InsuranceLog insuranceLog = new InsuranceLog();
        insuranceLog.setId(1);
        assertEquals(1, insuranceLog.getId());
        insuranceLog.setPolicyNumber("1234");
        assertEquals("1234", insuranceLog.getPolicyNumber());
    }

    @Test
    void InsuranceLogtest2() {
        InsuranceLog insuranceLog = new InsuranceLog();
        insuranceLog.setId(1);
        assertEquals(1, insuranceLog.getId());
        insuranceLog.setProvider("Geico");
        assertEquals("Geico", insuranceLog.getProvider());
    }
}
