package com.example.lunchex.helper;

import com.example.lunchex.entity.Users;
import com.example.lunchex.form.UsersForm;

public class UsersHelper {
	/**Usersへの変換*/
	public static Users convertRecorder(UsersForm form) {
		Users users = new Users();
		users.setUser_mail(form.getUserMail());
		users.setUser_nickname(form.getUserNickname());
		users.setUser_password(form.getUserPassword());

		return users;
	}
	/**UsersFormへの変換*/
	public static UsersForm convertRecorderForm(Users Users) {
		
		UsersForm form = new UsersForm();
		form.setUserMail(Users.getUser_mail());
		form.setUserNickname(Users.getUser_nickname());
		form.setUserPassword(Users.getUser_password());
		
		
		return form;
	}
}
