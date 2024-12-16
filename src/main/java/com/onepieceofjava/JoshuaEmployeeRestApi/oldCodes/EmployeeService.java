package com.onepieceofjava.JoshuaEmployeeRestApi.oldCodes;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    List<Employee> employees = new ArrayList<>();

    private Long employeeId = 1001L;

    //CRUD

    //GET ALL
    public List<Employee> getAllEmployees(){
        return  employees;
    }

    //GET BY ID
    public Optional<Employee> getEmployeeById(Long id){
        return employees.stream().filter(employee ->  employee.getId().equals(id)).findFirst();
    }


    //ADD
    public Employee addEmployee(Employee employee){
        employee.setId(employeeId++);
        employees.add(employee);

        return employee;
    }

    //UPDATE
    public Employee updateEmployee(Long id,Employee updatedEmployee){
        Optional<Employee> employee = getEmployeeById(id);
        if(employee.isPresent()){
            updatedEmployee.setId(id);
            employees.set(employees.indexOf(employee.get()), updatedEmployee);
            return  updatedEmployee;
        }

        return null;
    }

    //DELETE
    public void deleteEmployeeById(Long id){
        employees.removeIf(employee -> employee.getId().equals(id));
    }

}
