package com.LogMasterVehicle.DB.common;

import com.LogMasterVehicle.DB.model.VehicleRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import  java.util.List;

@Repository
public interface VehicleRegistrationRepo extends JpaRepository<VehicleRegistration, Integer>{
    List<VehicleRegistration> findByid(Integer id);
}