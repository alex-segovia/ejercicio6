package com.example.ejercicio6.Repository;

import com.example.ejercicio6.Dtos.EmployeesMayorSalarioDto;
import com.example.ejercicio6.Entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {

    @Query(nativeQuery = true,value = "SELECT e.first_name, e.last_name,DATE_FORMAT(hire_date, '%d-%m-%Y') AS fecha_inicio,DATE_FORMAT(end_date, '%d-%m-%Y') AS fecha_fin,jo.job_title FROM employees e JOIN job_history j ON e.employee_id = j.employee_id JOIN jobs jo ON e.job_id = jo.job_id ORDER BY e.salary DESC;")
    List<EmployeesMayorSalarioDto> listarEmpleadorXmayorSalario();



}
