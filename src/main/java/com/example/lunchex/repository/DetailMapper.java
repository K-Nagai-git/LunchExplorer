package com.example.lunchex.repository;
/**作成日：2024/10/22  */
/**作成者：糸山  		*/
/**更新日：  			*/
/**更新者：  			*/
import org.apache.ibatis.annotations.Mapper;

import com.example.lunchex.entity.Detail;

@Mapper
public interface DetailMapper {
	/***/
	/**店舗IDで１件取得*/
	Detail getDetailsByUser(int id);
	/**登録*/
	Detail addDetail(Detail detail);
	/**更新*/
	Detail updateDetail(Detail detail);
	/**削除*/
	Detail deleteDetail(int id);
}
