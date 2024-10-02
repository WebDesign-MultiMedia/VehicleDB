package com.LogMasterVehicle.DB.controller;

import com.LogMasterVehicle.DB.common.VehicleInformationRepo;
import com.LogMasterVehicle.DB.model.VehicleInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class VehicleInfoController {

    @Autowired
    VehicleInformationRepo repo;

    // GET ALL
    // localhost:8080/vehicleInformations

    @GetMapping("/vehicleInformations")
    public List<VehicleInformation> getAllVehicleInformation(){
        List<VehicleInformation> vehicleInformations = repo.findAll();
        return vehicleInformations;
    }

    // GET BY MAKE
    //localhost:8080/vehicleInformations/bmw
    @GetMapping("/vehicleInformations/{make}")
    public VehicleInformation getVehicleInformation(@PathVariable String make){
        VehicleInformation vehicleInformation = repo.findByMake(make).get(0);
        return vehicleInformation;
    }

    // POST CREATE NEW
    //localhost:8080/vehicleInformations/add
    @PostMapping("/vehicleInformations/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createNewVehicleInformation(@RequestBody VehicleInformation vehicleInformation){
        repo.save(vehicleInformation);
    }


    // DELETE
    // localhost:8080/vehicleInformations/delete/Toyota
    @DeleteMapping("/vehicleInformations/delete/{make}")
    public void removeVehicleInformation(@PathVariable String make){
        VehicleInformation vehicleInformation = repo.findByMake(make).get(0);
        repo.delete(vehicleInformation);
    }
}

