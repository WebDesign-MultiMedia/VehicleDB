package com.LogMasterVehicle.DB.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "InsuranceLogs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String policyNumber;
    private String provider;
    private String coverageDetails;
    private double premiumPayment;
    private String claimRecrds;
}
