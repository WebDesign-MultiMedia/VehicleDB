package com.LogMasterVehicle.DB.common;

import com.LogMasterVehicle.DB.model.FuelLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuelLogRepo extends JpaRepository<FuelLog, Integer>{
    Optional<FuelLog> findById(Integer id);
}