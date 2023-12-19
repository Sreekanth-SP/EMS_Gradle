package com.trois.EmployeeManagement.controller;

import com.trois.EmployeeManagement.model.EmployeeBean;
import com.trois.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/add")
    public ResponseEntity<EmployeeBean> saveEmployee(@RequestBody EmployeeBean employee){
        EmployeeBean employeeSaveToDB = this.employeeService.addEmployee(employee);
        return new ResponseEntity<EmployeeBean>(employeeSaveToDB, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public String getEmployeeById(@PathVariable Long id){

        return employeeService.getEmployeeById(id);
    }

    @GetMapping("list")
    public List<EmployeeBean> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @DeleteMapping("delete/id/{id}")
    public String deleteEmployeeById(@PathVariable Long id){
        return employeeService.deleteEmployeeById(id);
    }
    @PutMapping("update/id/{id}")
    public String updateEmployeeById(@PathVariable Long id,@RequestParam EmployeeBean employee){
        return employeeService.updateEmployeeById(id,employee);
    }

    @PutMapping("update/id/{id}/age/{age}")
    public String updateEmployeeAgeById(@PathVariable  Long id,@PathVariable int age){
        return employeeService.updateEmployeeAgeById(id,age);
    }
    @PutMapping("update/id/{id}/address/{address}")
    public String updateEmployeeAddressById(@PathVariable Long id,@PathVariable String address){
        return employeeService.updateEmployeeAddressById(id,address);
    }

    @PutMapping("update/id/{id}/name/{name}")
    public String updateEmployeeNameById(@PathVariable Long id,@PathVariable String name){
        return employeeService.updateEmployeeNameById(id,name);
    }
}
