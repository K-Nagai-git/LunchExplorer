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
    //private LunchexListMapper storeMapper;
    private StoresMapper storeMapper;
    	
//  public List<Users> getAllUsers() {
//  return usersMapper.getAllUsers(); 
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
 // 新規店舗を登録するメソッド
//  @Override
}

//    // 新規店舗を登録するメソッド
//    @Override
//    public void addStore(Stores stores) {
//    	Stores newStore = new Stores();
//        newStore.setStore_name(stores.getStore_name());
//        newStore.setStore_tel(stores.getStore_tel());
//        newStore.setStore_address(stores.getStore_address());
//        newStore.setStore_url(stores.getStore_url());
//        newStore.setUser_mail(stores.getUser_mail());
//        storeMapper.insert(newStore);  // マッパーを使用してデータベースに登録
//    }
//
//    // 全店舗を取得するメソッド
//    @Override
//    public List<Stores> getAllStores() {
//        return storeMapper.selectStoreListPickDt();  // メソッド名を変更
//    }
//
//    // IDで指定された店舗情報を取得するメソッド
//    @Override
//    public Stores getStoreById(int storeId) {
//        return storeMapper.findById(storeId);  // IDで店舗を取得
//    }
//
//    @Override
//    public Stores getStoreByname(String storeName) {
//    	return storeMapper.getStoreByame(storeName);
//    }
//    
//    // 既存の店舗情報を更新するメソッド
//    @Override
//    public void updateStore(Stores stores) {
//        storeMapper.update(stores);  // 更新メソッドを呼び出す
//    }
//
//    // 既存の店舗を削除するメソッド
//    @Override
//    public void deleteStore(int storeId) {
//        storeMapper.delete(storeId);  // 削除メソッドを呼び出す
//    }
//    
//    
//    
//    
//    
//}



//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.lunchex.entity.Stores;
//import com.example.lunchex.repository.StoresMapper;
//import com.example.lunchex.service.StoresService;
//
//import lombok.RequiredArgsConstructor;
//
///**Stores：サービス実装クラス*/
//
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class StoresServiceImpl implements StoresService {
//
//    /** DI */
//    private final StoresMapper storesMapper;
//
//  // 全店舗を取得する
//    @Override
//    public List<Stores> getAllStores() {
//        return storesMapper.selectAll();
//    }
//    
// // IDで指定された店舗情報を取得する
//    @Override
//    public Stores getStoreById(int store_id) {
//        return storesMapper.selectById(store_id);
//    }
//
// // 新しい店舗を追加する
//    @Override
//    public void addStore(Stores stores) {
//        storesMapper.insert(stores);
//    }
//
// // 既存の店舗情報を更新する
//    @Override
//    public void updateStore(Stores stores) {
//        storesMapper.update(stores);
//    }
//
// // 店舗を削除する
//    @Override
//    public void deleteStore(int store_id) {
//        storesMapper.delete(store_id);
//    }
//}
