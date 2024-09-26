package com.LogMasterVehicle.DB.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Login")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

}
