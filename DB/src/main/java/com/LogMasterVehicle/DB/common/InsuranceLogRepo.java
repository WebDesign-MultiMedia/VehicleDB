package com.LogMasterVehicle.DB.common;

import com.LogMasterVehicle.DB.model.InsuranceLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import  java.util.List;

@Repository
public interface InsuranceLogRepo extends JpaRepository<InsuranceLog, String>{
    List<InsuranceLog> findByProvider(String provider);
}