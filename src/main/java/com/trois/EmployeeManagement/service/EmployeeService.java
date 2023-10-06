package com.trois.EmployeeManagement.service;

import com.trois.EmployeeManagement.model.EmployeeBean;
import com.trois.EmployeeManagement.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class EmployeeService{
    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeBean addEmployee(EmployeeBean employee){
        employeeRepo.save(employee);
        return employee;
    }

    public String getEmployeeById(Long id) {
        EmployeeBean employee = employeeRepo.getByEmployeeId(id);
        if(employee ==null) return "Id Not Found";
        return "Employee Details: \n"+employee;
    }

    public List<EmployeeBean> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public String deleteEmployeeById(Long id) {
        EmployeeBean employee = employeeRepo.getByEmployeeId(id);
        if(employee ==null) return "Id Not Found";
        employeeRepo.deleteById(id);

        return "Employee Deleted Successfully.\n Details of deleted employee: \n"+employee;
    }

    public String updateEmployeeById(Long id, EmployeeBean employee) {
        EmployeeBean emp= employeeRepo.getByEmployeeId(id);
        if(emp ==null) return "Id Not Found";
        emp.setEmployeeName(employee.getEmployeeName());
        emp.setEmployeeAddress(employee.getEmployeeAddress());
        emp.setAge(employee.getAge());
        employeeRepo.save(emp);
        return "Employee updated Successfully.\n Details of employee after updated \n"+employeeRepo.getByEmployeeId(id);


    }

    public String updateEmployeeAgeById(Long id, int age) {
        EmployeeBean emp= employeeRepo.getByEmployeeId(id);
        if(emp ==null) return "Id Not Found";
        emp.setAge(age);
        employeeRepo.save(emp);

        return "Employee age updated Successfully.\n Details of employee after updated \n"+employeeRepo.getByEmployeeId(id);

    }

    public String updateEmployeeAddressById(Long id, String address) {
        EmployeeBean emp= employeeRepo.getByEmployeeId(id);
        if(emp ==null) return "Id Not Found";
        emp.setEmployeeAddress(address);
        employeeRepo.save(emp);

        return "Employee address updated Successfully.\n Details of employee after updated \n"+employeeRepo.getByEmployeeId(id);

    }

    public String updateEmployeeNameById(Long id, String name) {
        EmployeeBean emp= employeeRepo.getByEmployeeId(id);
        if(emp ==null) return "Id Not Found";;
        emp.setEmployeeName(name);
        employeeRepo.save(emp);

        return "Employee name updated Successfully.\n Details of employee after updated \n"+employeeRepo.getByEmployeeId(id);

    }
}
