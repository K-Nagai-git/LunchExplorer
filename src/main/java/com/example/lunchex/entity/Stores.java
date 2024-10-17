//作成 木和田 1015
//更新　糸山　　1017
package com.example.lunchex.entity;
import java.util.List;

import org.apache.catalina.User;

import lombok.Data;



	@Data
	public class Stores {
	    private int store_id;        	// 店舗ID（主キー）
	    private String store_name;   	// 店舗名(NULL不可)
	    private String store_tel;    	// 店舗電話番号(NULL不可)
	    private String store_address; 	// 店舗住所（NULL可）
	    private String store_url;    	// 店舗URL（NULL可）
	    private String user_mail;    	// 登録者のメールアドレス(NULL不可)
	    private List<User> users;		// ユーザー情報　※店舗情報とユーザー情報は1対多：糸山
	    private List<Detail> detail;	// 詳細情報　※店舗情報と詳細情報は１対多：糸山
	
	}

