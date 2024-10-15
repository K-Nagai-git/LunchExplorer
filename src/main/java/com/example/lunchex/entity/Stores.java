//作成 木和田 1015
package com.example.lunchex.entity;
import lombok.Data;



	@Data
	public class Stores {
	    private int storeId;        // 店舗ID（主キー）
	    private String storeName;   // 店舗名(NULL不可)
	    private String storeTel;    // 店舗電話番号(NULL不可)
	    private String storeAddress; // 店舗住所（NULL可）
	    private String storeUrl;    // 店舗URL（NULL可）
	    private String userMail;    // 登録者のメールアドレス(NULL不可)
	}

