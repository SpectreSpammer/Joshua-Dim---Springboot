package com.onepieceofjava.JoshuaEmployeeRestApi.model;


import java.util.List;

public class Employee {

    private Long id;
    private String name;
    private String dept;
    private List<Asset> assets;

    public Employee(Long id, String name, String dept, List<Asset> assets) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.assets = assets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public void setAsset(List<Asset> assets){
        this.assets = assets;
    }

    public void addAsset(Asset asset){
        this.assets.add(asset);
    }

    public void removeAsset(Asset asset){
        this.assets.remove(asset);
    }
}
