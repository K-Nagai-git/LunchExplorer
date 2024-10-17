// 作成　深田　1017　
//内容をあまり理解してない節がある
//Integer id のidは別の名前でいいかも
//作成時点でStoresマッパーが存在しないことによるエラーが出る。
//一旦、全てコードにコメントアウトしている。

package com.example.lunchex.service.impl;

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

/**Stores：サービス実装クラス*/

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
