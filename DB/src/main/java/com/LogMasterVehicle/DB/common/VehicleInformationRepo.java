package com.LogMasterVehicle.DB.common;

import com.LogMasterVehicle.DB.model.VehicleInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import  java.util.List;

@Repository
public interface VehicleInformationRepo extends JpaRepository<VehicleInformation, String>{
    List<VehicleInformation> findByMake(String make);
    List<VehicleInformation> findByModel(String model);

}