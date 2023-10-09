package com.ada.ProjetoFinalProgramacaoWeb2.repository;

import com.ada.ProjetoFinalProgramacaoWeb2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT employee FROM Employee employee WHERE employee.user.id = :userId")
    List<Employee> findEmployeeByUser(Integer userId);

    @Query("SELECT e FROM Employee e WHERE e.salary >= :minSalary")
    List<Employee> findBySalaryGreaterThanEqual(BigDecimal minSalary);
}
