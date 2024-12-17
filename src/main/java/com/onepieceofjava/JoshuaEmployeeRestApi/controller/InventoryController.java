package com.onepieceofjava.JoshuaEmployeeRestApi.controller;

import com.onepieceofjava.JoshuaEmployeeRestApi.model.Asset;
import com.onepieceofjava.JoshuaEmployeeRestApi.model.Employee;
import com.onepieceofjava.JoshuaEmployeeRestApi.service.AssetService;
import com.onepieceofjava.JoshuaEmployeeRestApi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {


   @Autowired
    AssetService assetService;

    @Autowired
    EmployeeService employeeService;


   //EMPLOYEES
   @GetMapping("/employees")
   public List<Employee> getAllEmployees(){
       return employeeService.getAllEmployee();
   }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id).orElse(null);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee){
        return employeeService.updatedEmployee(id, updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }

   //ASSETS
   @GetMapping("/assets")
    public List<Asset> getAllAssets(){
       return assetService.getAllAssets();
   }

   @GetMapping("/assets/{id}")
    public Asset getAssetById(@PathVariable Long id){
       return assetService.getAssetById(id).orElse(null);
   }


   @PostMapping("/assets")
    public Asset addAsset(@RequestBody Asset asset){
       return assetService.addAsset(asset);
   }

   @PutMapping("/assets/{id}")
    public Asset updateAsset(@PathVariable Long id, @RequestBody Asset updatedAsset){
       return assetService.updatedAsset(id, updatedAsset);
   }

    @DeleteMapping("/assets/{id}")
    public void deleteAssetById(@PathVariable Long id){
       assetService.deleteAssetById(id);
    }
}
