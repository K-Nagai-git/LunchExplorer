// 作成　深田　1017　
//内容をあまり理解してない節がある
//Integer id のidは別の名前でいいかも
//作成時点でDetailマッパーが存在しないことによるエラーが出る。
//一旦、全てコードにコメントアウトしている。
// 更新　糸山　1105
// 更新内容：全面修正　


package com.example.lunchex.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lunchex.entity.Detail;
import com.example.lunchex.repository.DetailMapper;
import com.example.lunchex.service.DetailService;

/**Detail：サービス実装クラス**/
 
@Service

public class DetailServiceImpl implements DetailService {

    /** DI */
   // private final DetailMapper detailMapper;

	@Autowired
	private DetailMapper detailMapper;
	
 // 全ての詳細情報を取得する
    @Override
    public List<Detail> getAllDetails() {
        return detailMapper.getAllDetails();
    }
    
 // IDで指定された詳細情報を取得する
    @Override
    public Detail getDetailById(int detail_id) {
        return detailMapper.getDetailById(detail_id);
    }

 // 特定のユーザーの詳細情報を取得する
    @Override
    public List<Detail> getDetailsByUser(String user_mail) {
        return detailMapper.getDetailsByUser(user_mail);
    }

 // 特定の店舗の詳細情報を取得する   
    @Override
    public List<Detail> getDetailsByStoreId(int store_id) {
        return detailMapper.getDetailsByStoreId(store_id);
    }

   // 新しい詳細情報を追加する
    @Override
    public void addDetail(Detail detail) {
        detailMapper.addDetail(detail);
    }
   // 既存の詳細情報を更新する
    
    @Override
    public void updateDetail(Detail detail) {
        detailMapper.updateDetail(detail);
    }

    // 詳細情報を削除する
    @Override
    public void deleteDetail(int detail_id) {
        detailMapper.deleteDetail(detail_id);
    }
}

