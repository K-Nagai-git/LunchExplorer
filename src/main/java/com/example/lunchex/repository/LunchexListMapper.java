/** 作成日：10/15			*/
/** 作成者：糸山     		*/
/** 更新日：10/23				*/
/** 更新者：川口　トップページの動作確認用修正		　　 		*/
/************************/
/**StoresList:リポジトリ		*/
package com.example.lunchex.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.lunchex.entity.Stores;

@Mapper
public interface LunchexListMapper {
    /** 全ての店舗情報を取得します。 */
    /** トップページ全店舗一覧表示用 */
//    @Select("SELECT * FROM stores")
    List<Stores> selectStoreListPickDt();
	List<Stores> selectPickStoreList(int id);	//一覧表示用SQL用に変更　2024/10/21：糸山

    /** 指定したIDの店舗を取得する */
    @Select("SELECT * FROM stores WHERE store_id = #{store_id}")
    Stores findById(int id);
    
    /** 店舗を登録する */
//    @Insert("INSERT INTO stores (store_name, store_tel, store_address, store_url, user_mail) VALUES (#{store_name}, #{store_tel}, #{store_address}, #{store_url}, #{user_mail})")
    @Options(useGeneratedKeys = true, keyProperty = "store_id")
    void insert(Stores stores);

    /** 店舗情報を更新する */
//    @Update("UPDATE stores SET store_name = #{store_name}, store_tel = #{store_tel}, store_address = #{store_address}, store_url = #{store_url} WHERE store_id = #{store_id}")
    void update(Stores stores);

    /** 指定したIDの店舗を削除する */
//    @Delete("DELETE FROM stores WHERE store_id = #{store_id}")
    void delete(int id); 
}
