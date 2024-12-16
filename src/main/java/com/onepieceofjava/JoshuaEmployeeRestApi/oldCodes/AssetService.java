package com.onepieceofjava.JoshuaEmployeeRestApi.oldCodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AssetService {

    List<Asset> assets = new ArrayList<>();

    private Long assetId = 2001L;

    //GET ALL
    public List<Asset> getAllAsset(){
        return  assets;
    }

    //GET BY ID
    public Optional<Asset> getAssetById(Long id){
        return assets.stream().filter(asset ->  asset.getId().equals(id)).findFirst();
    }


    //ADD
    public Asset addAsset(Asset asset){
        asset.setId(assetId++);
        assets.add(asset);

        return asset;
    }

    //UPDATE
    public Asset updateAsset(Long id,Asset updatedAsset){
        Optional<Asset> asset = getAssetById(id);
        if(asset.isPresent()){
            updatedAsset.setId(id);
            assets.set(assets.indexOf(asset.get()), updatedAsset);
            return  updatedAsset;
        }

        return null;
    }

    //DELETE
    public void deleteEmployeeById(Long id){
        assets.removeIf(asset -> asset.getId().equals(id));
    }
}
