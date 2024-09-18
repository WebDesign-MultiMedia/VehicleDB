package com.LogMasterVehicle.DB.model;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicleInformation")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class VehicleInformation {
// VIN, MAKE,MODEL, YEAR

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String make;
    private String model;
    private Integer year;
    private String vin;
}
