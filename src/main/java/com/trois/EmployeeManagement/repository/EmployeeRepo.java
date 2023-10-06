package com.trois.EmployeeManagement.repository;

import com.trois.EmployeeManagement.model.EmployeeBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeBean,Long> {
    EmployeeBean getByEmployeeId(Long id);
}
