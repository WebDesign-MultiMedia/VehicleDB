package com.LogMasterVehicle.DB.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ExpensesLog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpensesLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "type")
    private String entryType;
    @Column(name = "name")
    private String name;
    @Column(name = "amount")
    private String amount;
}
