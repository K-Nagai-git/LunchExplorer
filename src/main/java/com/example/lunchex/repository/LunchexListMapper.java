package com.example.lunchex.repository;
/** 作成日：10/15			*/
/** 作成者：糸山     		*/
/** 更新日：1017				*/
/** 更新者：永井		　　 		*/
/************************/
/**StoresList:リポジトリ		*/

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.example.lunchex.entity.Stores;

@Mapper
public interface LunchexListMapper {
    /** 全ての店舗情報を取得します。 */
     List<Stores> selectStoreListAll();

    /** 指定したIDの店舗を取得する */
    Stores findById(int id);

    /** 店舗を登録する */
    @Options(useGeneratedKeys = true, keyProperty = "store_id")
    void insert(Stores stores);

    /** 店舗情報を更新する */
    void update(Stores stores);

    /** 指定したIDの店舗を削除する */
    void delete(int id); 
}
