package com.LogMasterVehicle.DB.controller;


import com.LogMasterVehicle.DB.common.InsuranceLogRepo;
import com.LogMasterVehicle.DB.model.InsuranceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InsuranceLogController {

    @Autowired
    InsuranceLogRepo repo;

    // GET ALL
    // localhost:8080/InsuranceLogs
    @GetMapping("/InsuranceLogs")
    public List<InsuranceLog> getAllInsuranceLogs(){
        List<InsuranceLog> insuranceLogs = repo.findAll();
        return insuranceLogs;
    }

    // GET BY NAME
    // localhost:8080/InsuranceLogs/Global Insurers
    @GetMapping("/InsuranceLogs/{provider}")
    public InsuranceLog getInsuranceLog(@PathVariable String provider){
        InsuranceLog insuranceLog = repo.findByProvider(provider).get(0);
        return insuranceLog;
    }

    // POST CREATE NEW
    // localhost:8080/InsuranceLogs/add
    @PostMapping("/InsuranceLogs/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createNewInsuranceLog(@RequestBody InsuranceLog insuranceLog){
        repo.save(insuranceLog);
    }

    // DELETE
    // localhost:8080/InsuranceLogs/add
    @DeleteMapping("/InsuranceLogs/delete/{provider}")
    public void removeInsuranceLog(@PathVariable String provider){
        InsuranceLog insuranceLog = repo.findByProvider(provider).get(0);
        repo.delete(insuranceLog);
    }

}
