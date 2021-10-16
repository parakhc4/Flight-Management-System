package com.mycompany.springbootproject.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "deptTable")
public class Department {
    @Column(name = "departId", nullable = false)
    private int departId;
    private String departName;
}
