package com.LogMasterVehicle.DB.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "vehicleRegistraion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "RegistrationRenewalDate")
    private Date registrationRenewalDate;
    @Column(name = "FeesAndTaxesPaid")
    private double feesAndTaxesPaid;




}
