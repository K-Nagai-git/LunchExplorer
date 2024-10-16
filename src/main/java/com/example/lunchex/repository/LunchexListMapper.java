/** 作成日：10/15			*/
/** 作成者：糸山     		*/
/** 更新日：1015				*/
/** 更新者：木和田		　　 		*/
/************************/
/**StoresList:リポジトリ		*/
package com.example.lunchex.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.lunchex.entity.Stores;

@Mapper
public interface LunchexListMapper {
    /** 全ての店舗情報を取得します。 */
    /** トップページ全店舗一覧表示用 */
    @Select("SELECT * FROM stores")
    List<Stores> selectStoreListAll();

    /** 指定したIDの店舗を取得する */
    @Select("SELECT * FROM stores WHERE store_id = #{store_id}")
    Stores findById(int id);

    /** 店舗を登録する */
    @Insert("INSERT INTO stores (store_name, store_tel, store_address, store_url, user_mail) VALUES (#{store_name}, #{store_tel}, #{store_address}, #{store_url}, #{user_mail})")
    @Options(useGeneratedKeys = true, keyProperty = "store_id")
    void insert(Stores stores);

    /** 店舗情報を更新する */
    @Update("UPDATE stores SET store_name = #{store_name}, store_tel = #{store_tel}, store_address = #{store_address}, store_url = #{store_url} WHERE store_id = #{store_id}")
    void update(Stores stores);

    /** 指定したIDの店舗を削除する */
    @Delete("DELETE FROM stores WHERE store_id = #{store_id}")
    void delete(int id); 
}
