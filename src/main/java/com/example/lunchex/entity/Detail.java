package com.example.lunchex.entity;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ランチEX：エンティティ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Detail {
	/** 詳細ID（主キー） */
	private Integer detail_id;
	/** 店舗ID */
	private Integer store_id;
	/** 投稿日 */
	private LocalDate detail_postdt;   
	/** ユーザーメールアドレス */
	private String user_mail;
	/** ユーザーメールアドレス ★10/30 09:26永井追加　*/
	private String user_nickname;
	/** メニュー名 */
	private String detail_menu;
	/** 金額 */
	private Integer detail_price;	
	/** 評価 */
	private Integer detail_rating;	
	/** レビュー表示フラグ */
	private Boolean detail_review_flag;		
	/** レビュー */
	private String detail_review;	
	/** レビュー用画像 */
	private String detail_image;			
	/** メモ */
	private String detail_memo;  
	/** 利用日付 */
	private LocalDate detail_usedt;  	
	/** 来店回数 */
	private Integer detail_visits;   

}
