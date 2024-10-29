package com.example.lunchex.repository;
/**作成日：2024/10/22  */
/**作成者：糸山  		*/
/**更新：　2024/10128　永井　ファイル名をDetailMapper.javaから変更　*/

import org.apache.ibatis.annotations.Mapper;

import com.example.lunchex.entity.Detail;

@Mapper
public interface DetailListMapper {
	/***/
	/**店舗IDで１件取得*/
	Detail getDetailsByUser(int id);
	/**登録*/
	void addDetail(Detail detail);
	/**更新*/
	void updateDetail(Detail detail);
	/**削除*/
	void deleteDetail(int id);
}
