package com.LogMasterVehicle.DB;

import com.LogMasterVehicle.DB.model.ExpensesLog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpenseLogTest{

    @Test
    void test () {
        ExpensesLog expenseLog = new ExpensesLog();
        expenseLog.setId(1);
        assertEquals(1, expenseLog.getId());
        expenseLog.setDate("2021-09-01");
    }

    @Test
    void test2 () {
        ExpensesLog expenseLog = new ExpensesLog();
        expenseLog.setId(1);
        assertEquals(1, expenseLog.getId());
        expenseLog.setType("Fuel");
    }
}
