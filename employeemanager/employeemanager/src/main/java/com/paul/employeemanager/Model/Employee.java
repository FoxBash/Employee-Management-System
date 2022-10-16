package com.paul.employeemanager.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "Email")
    private String email;
    @Column(name = "Telephone")
    private String telephone;


}
