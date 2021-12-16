package com.github.xto.emsapp.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface SqlEmployeeRepository extends EmployeeRepository, JpaRepository <Employee, Integer> {
    @Override
    @Query(nativeQuery = true, value = "select count(*) > 0 from employees where id=:id")
    boolean existsById(@Param("id") Integer id);
}
