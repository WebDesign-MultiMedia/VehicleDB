package com.LogMasterVehicle.DB.common;

import com.LogMasterVehicle.DB.model.MaintenanceRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaintenanceRepairRepo extends JpaRepository<MaintenanceRepair, Integer>{
    Optional<MaintenanceRepair> findById(Integer id);
}