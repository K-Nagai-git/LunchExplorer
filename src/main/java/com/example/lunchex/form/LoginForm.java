package com.example.lunchex.form;
/** 作成日：2024/10/24		*/
/** 作成者：糸山  			*/
/** 更新日：  				*/
/** 更新者：  				*/

import lombok.Data;

@Data
public class LoginForm {
	/**ログイン用ユーザーメールアドレス（ID）*/
	private String username;
	/**ログイン用パスワード*/
	private String password;

}
