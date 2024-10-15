//作成 木和田 1015
package com.example.lunchex.entity;
import lombok.Data;



	@Data
	public class Stores {
	    private int store̠id;        // 店舗ID（主キー）
	    private String store̠name;   // 店舗名(NULL不可)
	    private String store̠tel;    // 店舗電話番号(NULL不可)
	    private String store̠address; // 店舗住所（NULL可）
	    private String store̠url;    // 店舗URL（NULL可）
	    private String user̠mail;    // 登録者のメールアドレス(NULL不可)
	}

