package com.LogMasterVehicle.DB.controller;

import com.LogMasterVehicle.DB.common.MaintenanceRepairRepo;
import com.LogMasterVehicle.DB.model.MaintenanceRepair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class MaintenanceRepairController {

    @Autowired
    MaintenanceRepairRepo repo;

    // GET ALL MaintenanceRepairs
    // localhost:8080/MaintenanceRepairs
    @GetMapping("/MaintenanceRepairs")
    public List<MaintenanceRepair> getAllMaintenanceRepair(){
        List<MaintenanceRepair> maintenanceRepairs = repo.findAll();
        return maintenanceRepairs;
    }

    // GET by Id
    // localhost:8080/MaintenanceRepairs/1
    @GetMapping("/MaintenanceRepairs/{id}")
    public MaintenanceRepair getMaintenanceRepair(@PathVariable int id){
       MaintenanceRepair maintenanceRepair = repo.findById(id).get();
       return maintenanceRepair;
    }

    // POST Create new MaintenanceRepairs
    // localhost:8080/MaintenanceRepairs/add
    @PostMapping("/MaintenanceRepairs/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createNewMaintenanceRepair(@RequestBody MaintenanceRepair maintenanceRepair){
        repo.save(maintenanceRepair);
    }

    // DELETE
    // localhost:8080/MaintenanceRepairs/delete/1
    @DeleteMapping("/MaintenanceRepairs/delete/{id}")
    public void removeMaintenanceRepair(@PathVariable int id){
        MaintenanceRepair maintenanceRepair = repo.findById(id).get();
        repo.delete(maintenanceRepair);
    }

}
