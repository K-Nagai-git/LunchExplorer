// 作成　深田　1015　メモ：エンティティの作成　お土産をもらった

package com.example.lunchex.entity;
import lombok.Data;

@Date
public class Users {
	
	    private int userId;        // ユーザーID（主キー）
	    private String nickname;   // ニックネーム（必須）
	    private String password;   // パスワード（必須）
	
	
	
}
