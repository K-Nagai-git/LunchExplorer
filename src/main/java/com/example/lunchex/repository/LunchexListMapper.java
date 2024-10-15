/************************/
/**StoresList:リポジトリ		*/
/** 作成日：10/15			*/
/** 作成者：糸山     		*/
/** 更新日：				*/
/** 更新者：		　　 		*/
/*********************/
package com.example.lunchex.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.lunchex.entity.Stores;

@Mapper
public interface LunchexListMapper {
	/**全ての店舗情報を取得します。*/
	/**トップページ全店舗一覧表示用*/
	List<Stores> selectStoreListAll();
	/**指定されたIDに対応する「すること」を取得します。*/
}
