package com.LogMasterVehicle.DB.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.Month;
import java.util.Date;

@Entity
@Table(name = "MaintenanceRepair")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceRepair {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;
 @Column(name = "Date")
 private Date date;
 @Column(name = "Mileage")
 private Integer mileage;
 @Column(name = "MainRepair")
 private String change_Replace;
 @Column(name = "Vehicle Side")
 private String vehicleSide;
 @Column(name = "Service Provider")
 private String serviceProvider;
 @Column(name = "Service Provider Location")
private String serviceProviderLocation;
 @Column(name = "Cost of Service")
private double CostOfService;
 @Column(name = "Next Service Due")
private Month nextServiceDue;
 @Column(name = "Receipt and/or Invoice Number")
private Integer receipt_InvoiceNumber;
 @Column(name = "Notes or Issues")
private String note_Issues;

 @ManyToOne
 @JoinColumn(name = "creator_id", nullable = false)
 private MyAppUser creator;
}
