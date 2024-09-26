package com.LogMasterVehicle.DB.controller;

import com.LogMasterVehicle.DB.common.LoginRepo;
import com.LogMasterVehicle.DB.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    LoginRepo repo;

    // localhost:8080/Login
    @GetMapping("/Logins")
    public List<Login> getAllLogins() {
        List<Login> logins = repo.findAll();
        return logins;
    }

    //localhost:8080/Login/add
    @PostMapping("/Logins/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createNewLogin(@RequestBody Login login) {
        repo.save(login);
;
    }


}
