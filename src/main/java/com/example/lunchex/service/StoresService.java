package com.example.lunchex.service;

import java.util.List;

import com.example.lunchex.entity.Stores;

public interface StoresService {
    
    // 全店舗を取得する
    List<Stores> getAllStores();
    
    // IDで指定された店舗情報を取得する
    Stores getStoreById(int storeId);  
    
    // 店名で指定された店舗情報を取得する
    Stores getStoreByName(String storeName);  
    
    // 新しい店舗を追加する
    void addStore(Stores stores);  

    // 既存の店舗情報を更新する
    void updateStore(Stores stores);
    
    // 既存の店舗を削除する
    void deleteStore(int storeId);

	
}
