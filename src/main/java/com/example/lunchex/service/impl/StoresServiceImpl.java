// 作成　深田　1017　
//内容をあまり理解してない節がある
//Integer id のidは別の名前でいいかも
//作成時点でStoresマッパーが存在しないことによるエラーが出る。
//一旦、全てコードにコメントアウトしている。
// 更新　糸山　10241105
//　更新内容：全面修正

package com.example.lunchex.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lunchex.entity.Stores;
import com.example.lunchex.repository.StoresMapper;
import com.example.lunchex.service.StoresService;

@Service
public class StoresServiceImpl implements StoresService {

    @Autowired
    private StoresMapper storeMapper;
    	

    // 全店舗を取得する
    public List<Stores> getAllStores(){
    	return storeMapper.getStoreAll();
    }
    
    // IDで指定された店舗情報を取得する
	  @Override
	  public Stores getStoreById(int storeId) {
	      return storeMapper.getStoreById(storeId);  // IDで店舗を取得
	  }
    
    // 店名で指定された店舗情報を取得する
	  public Stores getStoreByName(String storeName) {
		  return storeMapper.getStoreByName(storeName);
	  }
	  
    // 新しい店舗を追加する
	  @Override
	  public void addStore(Stores stores) {
	  	Stores newStore = new Stores();
	      newStore.setStore_name(stores.getStore_name());
	      newStore.setStore_tel(stores.getStore_tel());
	      newStore.setStore_address(stores.getStore_address());
	      newStore.setStore_url(stores.getStore_url());
	      newStore.setUser_mail(stores.getUser_mail());
	      storeMapper.addStore(newStore);  // マッパーを使用してデータベースに登録
	  }

    // 既存の店舗情報を更新する
    public void updateStore(Stores stores) {
    	storeMapper.updateStore(stores);
    }
    
    // 既存の店舗を削除する
    public void deleteStore(int storeId) {
    	storeMapper.deleteStore(storeId);
    }

}

