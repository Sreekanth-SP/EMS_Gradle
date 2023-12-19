package com.trois.EmployeeManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employee")
public class EmployeeBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long employeeId;

    String employeeName;

    String employeeAddress;

    int age;

}
