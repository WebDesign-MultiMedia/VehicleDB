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
    private Integer id;
    @Column(name = "Date")
    private Date date;
    @Column(name = "Gallon/Liter Purchased")
    private double gallon_LiterPurchased;
    @Column(name = "Price Per Gallon/Liter")
    private double pricePerGallon_Liter;
    @Column(name = "Total Cost")
    private double totalCost;
    @Column(name = "Fuel Type")
    private String fuelType;
    @Column(name = "Gas Station Name")
    private String gasStationName;
    @Column(name = "Gas Station Location")
    private String gasStationLocation;
    @Column(name = "Payment Methods")
    private String paymentMethod;
    @Column(name = "Odometer Reading")
    private Integer odometerReading;
    @Column(name = "Trip Purpose")
    private String tripPurpose;
    @Column(name = "Fuel Efficiency")
    private String fuelEfficiency;

}
