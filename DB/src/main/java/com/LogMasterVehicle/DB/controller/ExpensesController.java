package com.LogMasterVehicle.DB.controller;

import com.LogMasterVehicle.DB.common.ExpensesRepo;
import com.LogMasterVehicle.DB.model.ExpensesLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ExpensesController {

    @Autowired
    ExpensesRepo expensesRepo;

    // GET ALL Expenses Logs
    // localhost:8080/ExpensesLogs
    @GetMapping("/ExpensesLogs")
    public List<ExpensesLog> getAllExpensesLogs() {
        List<ExpensesLog> expensesLogs = expensesRepo.findAll();
        return expensesLogs;
    }

    // ADD Expenses Logs
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createNewExpensesLog(ExpensesLog expensesLog) {
        expensesRepo.save(expensesLog);
    }

}
