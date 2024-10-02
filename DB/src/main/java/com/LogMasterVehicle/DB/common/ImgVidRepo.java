package com.LogMasterVehicle.DB.common;

import com.LogMasterVehicle.DB.model.ImgVidCapture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImgVidRepo  extends JpaRepository<ImgVidCapture, Integer> {
    Optional<ImgVidCapture> findById(Integer id);
}
