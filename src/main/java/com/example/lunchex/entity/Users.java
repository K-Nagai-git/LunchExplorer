// 作成　深田　1015　メモ：エンティティの作成　お土産をもらった
//更新　深田　1021
//メモ：
//深田が「entity」の「Userクラス」を当初、「Users」と名前をつけ。クラスを作成していたため、
//「User」に変更し、それにともないコードを修正
//更新　深田　1021　
//メモ：上記の修正をもとに戻す。クラス名を「Users」に変更

package com.example.lunchex.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	
	    private String user_mail;        //ユーザーメールアドレス（PK）
	    private String user_nickname ;   // ニックネーム（必須）
	    private String user_password ;   // パスワード（必須）
	
	
	
}
