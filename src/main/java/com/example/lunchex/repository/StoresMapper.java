package com.example.lunchex.repository;
/**作成日：2024/10/21  */
/**作成者：糸山  		*/
/**更新日：  			*/
/**更新者：  			*/
import org.apache.ibatis.annotations.Mapper;

import com.example.lunchex.entity.Stores;

@Mapper
public interface StoresMapper {
	/**店舗IDで１件取得*/
	Stores getStoreById(int id);
	/**登録*/
	void  addStore(Stores stores);
	/**更新*/
	void updateStore(Stores stores);
	/**削除*/
	void  deleteStore(int id);
	
}
