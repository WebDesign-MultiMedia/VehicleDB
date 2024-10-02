package com.LogMasterVehicle.DB.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
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

 private Date date;
 private Integer mileage;
 private String maintenance_repair;
 private String parts;
 private String vehicleSide;
 private String serviceProvider;
 private String serviceProviderLocation;
 private double costOfService;
 private String nextServiceDue;
 private Integer receipt_InvoiceNumber;
 private String note_Issues;



//
// @ManyToOne
// @JoinColumn(name = "creator_id", nullable = false)
// private MyAppUser creator;
}
