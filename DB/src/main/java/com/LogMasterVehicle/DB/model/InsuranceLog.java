package com.LogMasterVehicle.DB.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "InsuranceLog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Policy Number")
    private String policyNumber;
    @Column(name = "Provider")
    private String provider;
    @Column(name = "Coverage Details")
    private String coverageDetails;
    @Column(name = "Premium Payments")
    private double premiumPayment;
    @Column(name = "Claim Records")
    private String claimRecords;
    private Date renewlDate;
}
