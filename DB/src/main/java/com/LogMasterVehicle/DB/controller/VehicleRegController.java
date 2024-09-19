package com.LogMasterVehicle.DB.controller;

import com.LogMasterVehicle.DB.common.VehicleRegistrationRepo;
import com.LogMasterVehicle.DB.model.VehicleRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleRegController {

    @Autowired
    VehicleRegistrationRepo repo;

    // GET ALL
    // localhost:8080/vehicleRegistraions
    @GetMapping("/vehicleRegistraions")
    public List<VehicleRegistration> getAllVehicleRegistration(){
        List<VehicleRegistration> vehicleRegistrations = repo.findAll();
        return  vehicleRegistrations;
    }

    // GET BY ID
    //localhost:8080/vehicleRegistraions/1
    @GetMapping("/vehicleRegistraions/{id}")
    public VehicleRegistration getVehicleRegistration(@PathVariable int id){
        VehicleRegistration vehicleRegistration = repo.findById(id).get();
        return vehicleRegistration;
    }


    // POST CREATE NEW
    // localhost:8080/vehicleRegistraions/add
    @PostMapping("/vehicleRegistraions/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createNewVehicleRegistration(@RequestBody VehicleRegistration vehicleRegistration){
        repo.save(vehicleRegistration);
    }

    // DELETE
    //  localhost:8080/vehicleRegistraions/delete/1
    @DeleteMapping("/vehicleRegistraions/delete/{id}")
    public void removeVehicleRegistration(@PathVariable int id) {
        VehicleRegistration vehicleRegistration = repo.findById(id).get();
        repo.delete(vehicleRegistration);

    }

}
