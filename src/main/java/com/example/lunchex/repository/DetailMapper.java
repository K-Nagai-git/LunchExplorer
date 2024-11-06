package com.example.lunchex.repository;
/**作成日：2024/10/22  */
/**作成者：糸山  		*/
/**更新： 2024/10/28　永井　  			*/


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.lunchex.entity.Detail;

/**
 * Detail：リポジトリ
 */
@Mapper
public interface DetailMapper {
	
    // 全ての詳細情報を取得する
    List<Detail> getAllDetails();

    // IDで指定された詳細情報を取得する
    Detail getDetailById(int detail_id);

    // 特定のユーザーの詳細情報を取得する
    List<Detail> getDetailsByUser(String user_mail);

    // 特定の店舗の詳細情報を取得する
    List<Detail> getDetailsByStoreId(int store_id);

    // 新しい詳細情報を追加する
    void addDetail(Detail detail);

    // 既存の詳細情報を更新する
    void updateDetail(Detail detail);

    // 詳細情報を削除する
    void deleteDetail(int detail_id);
}

//    /**
//     * 全ての「レビュー等」を取得します。
//     */
//    List<Detail> selectAllDetail();
//
//    /**
//     * 指定されたIDに対応する「レビュー等」を取得します。
//     */
//    Detail selectByIdDetail(@Param("id") int detail_id);
//
//    /**
//     * 「レビュー等」を登録します。
//     */
//    void insertDetail(Detail detail);
//
//    /**
//     * 「レビュー等」を更新します。
//     */
//    void updateDetail(Detail detail);
//
//    /**
//     * 指定されたIDの「レビュー等」を削除します。
//     */
//    void deleteDetail(@Param("id") Integer id);
//
//	List<Detail> selectByStoreId(int store_id);
//}


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
