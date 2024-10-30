package com.example.lunchex.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authentication {
	/** ユーザー名 */
	private String users_mail;
	/** ユーザーニックネーム */
	private String users_nickname;
	/** パスワード */
	private String users_password;

}
