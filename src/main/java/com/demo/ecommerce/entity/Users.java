package com.demo.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="users")
public class Users {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "surName", nullable = false)
    private String surName;

    @Column(name = "userMail", nullable = false)
    private String userMail;

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "lastLogin", nullable = false)
    private LocalDate lastLogin;

    @Column(name = "isActive", nullable = false)
    private boolean isActive;
}
