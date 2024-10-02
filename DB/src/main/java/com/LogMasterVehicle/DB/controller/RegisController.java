package com.LogMasterVehicle.DB.controller;

import com.LogMasterVehicle.DB.common.RegisRepo;
import com.LogMasterVehicle.DB.model.Registers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class RegisController {

    @Autowired
    RegisRepo repo;

    // localhost:8080/Register
    @GetMapping("/Register")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Registers> getAllRegisters() {
        List<Registers> registers = repo.findAll();
        return registers;
    }


    @PostMapping("/Register/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createNewRegister(@RequestBody Registers registers) {
        repo.save(registers);
    }


    @GetMapping("/Register/{id}")
    public Registers getRegister(@PathVariable int id){
        Registers registers = repo.findById(id).orElse(null);
        return registers;
    }

//    @PostMapping("/add")
//    @ResponseStatus(code = HttpStatus.CREATED)
//    public ResponseEntity<Registers> createNewRegister(@RequestBody Registers registers) {
//        repo.save(registers);
//        return ResponseEntity.ok(registers);
//    }
}
