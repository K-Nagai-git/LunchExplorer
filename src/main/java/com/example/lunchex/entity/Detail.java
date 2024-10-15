package com.example.lunchex.entity;
// 永井 241015

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
//詳細ID（主キー）	detail_id	INTEGER	NOT NULL
//店舗ID	store_id	INTEGER	NOT NULL
//投稿日	detail_postdt	DATE	NOT NULL
//ユーザーメールアドレス	user_mail	VARCHAR	NOT NULL
//メニュー名	detail_menu	VARCHAR	NOT NULL
//金額	detail_price	INTEGER	NOT NULL
//評価	detail_rating	INTEGER	NOT NULL
//レビュー表示フラグ	detail_review_flag	BOOLEAN	NOT NULL
//レビュー	detail_review	VARCHAR	
//レビュー用画像	detail_image	VARCHAR	
//メモ	detail_memo	VARCHAR	
//利用日付	detail_usedt	DATE	NOT NULL
//来店回数	detail_visits	INTEGER	NOT NULL
