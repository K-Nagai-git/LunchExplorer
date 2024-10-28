package com.example.lunchex.repository;
/**作成日：2024/10/22  */
/**作成者：糸山  		*/
/**更新： 2024/10/28　永井　  			*/


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lunchex.entity.Detail;

/**
 * Detail：リポジトリ
 */
@Mapper
public interface DetailMapper {

    /**
     * 全ての「レビュー等」を取得します。
     */
    List<Detail> selectAllDetail();

    /**
     * 指定されたIDに対応する「レビュー等」を取得します。
     */
    Detail selectByIdDetail(@Param("id") Integer id);

    /**
     * 「レビュー等」を登録します。
     */
    void insertDetail(Detail detail);

    /**
     * 「レビュー等」を更新します。
     */
    void updateDetail(Detail detail);

    /**
     * 指定されたIDの「レビュー等」を削除します。
     */
    void deleteDetail(@Param("id") Integer id);
}


//*****************
//
//@Mapper
//public interface DetailMapper {
//	/***/
//	/**店舗IDで１件取得*/
//	Detail getDetailsByUser(int id);
//	/**登録*/
//	void addDetail(Detail detail);
//	/**更新*/
//	void updateDetail(Detail detail);
//	/**削除*/
//	void deleteDetail(int id);
//}
