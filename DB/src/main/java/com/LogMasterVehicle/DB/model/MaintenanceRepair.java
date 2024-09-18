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
@Table(name = "MaintenanceAndRepair")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceRepair {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;
 private Date date;
 private Integer mileage;
 private String change_Replace;
 private String vehicleSide;
 private String serviceProvider;
private String serviceProviderLocation;
private double CostOfService;
private Month nextServiceDue;
private Integer receipt_InvoiceNumber;
private String note_Issues;
}
