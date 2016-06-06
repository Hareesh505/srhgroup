package com.srh.model;


import lombok.Data;
import javax.persistence.*;

/**
 * Created by RaghavendraKulkarni on 6/6/2016.
 */
@Data
@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String empName;

    @Column(name="state")
    private String empState;

    public Employee(String empName,String empState){
        this.empName = empName;
        this.empState = empState;
    }
}
