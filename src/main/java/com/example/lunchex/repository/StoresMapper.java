package com.example.lunchex.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.lunchex.entity.Stores;

@Mapper
public interface StoresMapper {
	/**店舗IDで１件取得*/
	Stores getStoreById(Stores stores);
	/**登録*/
	Stores addStore(Stores stores);
	/**更新*/
	Stores updateStore(Stores stores);
	/**削除*/
	Stores deleteStore(Stores stores);
	
}
