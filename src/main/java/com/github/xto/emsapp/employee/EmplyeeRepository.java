package com.github.xto.emsapp.employee;

import java.util.List;
import java.util.Optional;

interface EmployeeRepository {
    Optional<Employee> findById(int id);

    Employee save(Employee entity);

    List<Employee> findAll();
}
