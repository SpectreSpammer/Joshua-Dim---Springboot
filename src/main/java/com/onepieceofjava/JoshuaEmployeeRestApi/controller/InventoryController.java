package com.onepieceofjava.JoshuaEmployeeRestApi.controller;


import com.onepieceofjava.JoshuaEmployeeRestApi.model.Asset;
import com.onepieceofjava.JoshuaEmployeeRestApi.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private List<Employee> employeeList = new ArrayList<>();

    private List<Asset> assetList = new ArrayList<>();

    private Long employeeId = 1001L;
    private Long assetId = 2001L;

    //for employees

    //GET ALL
    //localhost:8080/api/inventory/employees/
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeList;
    }

    //GET BY ID
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeList.stream()
                .filter(employee -> employee.getId()
                        .equals(id))
                .findFirst().orElse(null);

    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(employeeId);

        if(employee.getAssets() != null && !employee.getAssets().isEmpty()){
            List<Asset> processAsset= new ArrayList<>();
            for(Asset asset : employee.getAssets()){
                asset.setId(assetId);
                assetList.add(asset);
                processAsset.add(asset);
            }
            employee.setAsset(processAsset);
        }
        employeeList.add(employee);

        return employee;
    }

    //update
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee){
        for(int i = 0; i < employeeList.size();i++){
            if(employeeList.get(i).getId().equals(id)){
                updatedEmployee.setId(id);
                employeeList.set(i,updatedEmployee);
                return updatedEmployee;

            }
        }
        return null;
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        employeeList.removeIf(employee -> employee.getId().equals(id));
    }

    //ASSET
}
