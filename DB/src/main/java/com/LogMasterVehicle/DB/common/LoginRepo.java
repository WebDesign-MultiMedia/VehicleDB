package com.LogMasterVehicle.DB.common;

import com.LogMasterVehicle.DB.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepo extends JpaRepository<Login, Integer> {
    Optional<Login> findById(Integer id);
    Optional<Login> findByEmail(String email);
    Optional<Login> findByEmailAndPassword(String email, String password);
}
