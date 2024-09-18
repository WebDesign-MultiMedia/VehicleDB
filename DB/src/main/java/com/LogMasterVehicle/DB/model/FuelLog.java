package com.LogMasterVehicle.DB.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "FuelLog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuelLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private Date date;
    @Column
    private double gallon_LiterPurchased;
    @Column
    private double pricePerGallon_Liter;
    @Column
    private double totalCost;
    @Column
    private String fuelType;
    @Column
    private String gasStationName;
    @Column
    private String gasStationLocation;
    @Column
    private String paymentMethod;
    @Column
    private Integer odometerReading;
    @Column
    private String tripPurpose;
    @Column
    private String fuelEfficiency;

}
