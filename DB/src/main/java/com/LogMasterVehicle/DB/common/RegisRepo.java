package com.LogMasterVehicle.DB.common;

import com.LogMasterVehicle.DB.model.Registers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisRepo extends JpaRepository<Registers, String> {

    List<Registers> findByEmail(String email);

}
