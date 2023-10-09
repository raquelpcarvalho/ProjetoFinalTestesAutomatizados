package com.ada.ProjetoFinalProgramacaoWeb2.utils;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.EmployeeRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.EmployeeResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.model.Employee;
import com.ada.ProjetoFinalProgramacaoWeb2.model.User;

import java.util.ArrayList;
import java.util.List;

public class EmployeeConvert {
    public static Employee toEntity(EmployeeRequest employeeRequest, User user){
        Employee employee = new Employee();
        //employee.setAdmissionDate(employeeRequest.getAdmissionDate());
        employee.setAddress(employeeRequest.getAddress());
        employee.setSalary(employeeRequest.getSalary());
        employee.setUser(user);
        return employee;
    }

    public static EmployeeResponse toResponse(Employee employee){
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setMatricula(employee.getMatricula());
        employeeResponse.setAddress(employee.getAddress());
        employeeResponse.setSalary(employee.getSalary());
        //employeeResponse.setAdmissionDate(employee.getAdmissionDate());
        employeeResponse.setUser(UserConvert.toResponse(employee.getUser()));
        return employeeResponse;
    }

    public static List<EmployeeResponse> toResponseList(List<Employee> employees){
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        for(Employee employee : employees){
            employeeResponses.add(toResponse(employee));
        }
        return employeeResponses;
    }

}
