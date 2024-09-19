package com.LogMasterVehicle.DB.controller;

import com.LogMasterVehicle.DB.common.FuelLogRepo;
import com.LogMasterVehicle.DB.model.FuelLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class FuelLogController {

    @Autowired
    FuelLogRepo repo;

    // GET ALL Fuel Logs
    // localhost:8080/FuelLogs
    @GetMapping("/FuelLogs")
    public List<FuelLog> getAllFuelLogs() {
        List<FuelLog> fuelLogs = repo.findAll();
        return fuelLogs;
    }

    //localhost:8080/FuelLogs/1
    // GET Fuel Logs by Id
    @GetMapping("/FuelLogs/{id}")
    public FuelLog getFuelLog(@PathVariable int id) {
        FuelLog fuelLog = repo.findById(id).get();
        return fuelLog;
    }

    //localhost:8080/FuelLogs/add
    // POST Create Fuel Logs
    @PostMapping("/FuelLogs/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createNewFuelLog(@RequestBody FuelLog fuelLog) {
        repo.save(fuelLog);
    }

//    @PutMapping("/FuelLogs/update{id}")
//    public FuelLog updateFuelLogs(@PathVariable int id) {
//        FuelLog fuelLog = repo.findById(id).get();
//        fuelLog.setId(id);
//        return null;
//    }

    // DELETE
    @DeleteMapping("/FuelLogs/delete/{id}")
    public void removeFuelLog(@PathVariable int id){
       FuelLog fuelLog = repo.findById(id).get();
        repo.delete(fuelLog);
    }
}

