package com.example.lunchex.form;
/** 作成日：2024/10/25		*/
/** 作成者：糸山  			*/
/** 更新日：  				*/
/** 更新者：  				*/
import lombok.Data;

@Data
public class UsersForm {
	/**ユーザーメールアドレス*/
	public String userMail;
	/**ユーザーニックネーム*/
	public String userNickname;
	/**パスワード*/
	public String userPassword;
	/**新規判定*/
	private Boolean isNew;
}
