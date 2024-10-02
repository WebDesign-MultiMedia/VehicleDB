package com.LogMasterVehicle.DB.controller;

import com.LogMasterVehicle.DB.common.ImgVidRepo;
import com.LogMasterVehicle.DB.model.ImgVidCapture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ImgVidController {

    @Autowired
    ImgVidRepo repo;

    @GetMapping("/ImgVidCapture")
    public  List<ImgVidCapture> getAllImgVid(){
        List<ImgVidCapture> imgVidCaptures = repo.findAll();
        return imgVidCaptures;
    }

    @PostMapping("/ImgVidCapture/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createNewImgVid(@RequestBody ImgVidCapture imgVidCapture) {
        repo.save(imgVidCapture);
    }
}
