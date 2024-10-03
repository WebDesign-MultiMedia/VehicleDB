package com.LogMasterVehicle.DB.controller;

import com.LogMasterVehicle.DB.common.ExpensesRepo;
import com.LogMasterVehicle.DB.model.ExpensesLog;
import com.LogMasterVehicle.DB.model.VehicleRegistration;
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
    // localhost:8080/ExpensesLogs/add
//    @PostMapping("/ExpensesLogs/add")
//    @ResponseStatus(code = HttpStatus.CREATED)
//    public void createNewExpensesLog(ExpensesLog expensesLog) {
//        expensesRepo.save(expensesLog);
//    }

    @PostMapping("/ExpensesLogs/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createNewExpensesLog(@RequestBody ExpensesLog expensesLog) {
        expensesRepo.save(expensesLog);
    }

    // DELETE
    //  localhost:8080/ExpensesLogs/delete/1
    @DeleteMapping("/ExpensesLogs/delete/{id}")
    public void removeExpensesLog(@PathVariable int id) {
        ExpensesLog expensesLog = expensesRepo.findById(id).get();
        expensesRepo.delete(expensesLog);

    }
//    public void removeExpensesLog(@PathVariable int id) {
//        VehicleRegistration vehicleRegistration = repo.findById(id).get();
//        repo.delete(vehicleRegistration);
//
//    }

}
