package com.LogMasterVehicle.DB.common;

import com.LogMasterVehicle.DB.model.FuelLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import  java.util.List;

@Repository
public interface FuelLogRepo extends JpaRepository<FuelLog, Date>{
    List<FuelLog> findByDate(Date date);
}