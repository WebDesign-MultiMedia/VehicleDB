package com.LogMasterVehicle.DB.common;

import com.LogMasterVehicle.DB.model.MaintenanceRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import  java.util.List;

@Repository
public interface MaintenanceRepairRepo extends JpaRepository<MaintenanceRepair, Date>{
    List<MaintenanceRepair> findByDate(Date date);
}