package com.paul.employeemanager.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Account")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Username")
    private String username;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Email")
    private String email;
    @Column(name = "Telephone")
    private String telephone;
    @Column(name = "Password", nullable = false)
    private String password;


}
