//作成 木和田 1016
package com.example.lunchex.service;

import java.util.List;

import com.example.lunchex.entity.Users;

public interface UserService {

	    // 全ユーザーを取得する
	    List<Users> getAllUsers();

	    // メールアドレスで指定されたユーザー情報を取得する
	    Users getUserByMail(String user_mail);

	    // 新しいユーザーを追加する
	    void addUser(Users user);

	    // 既存のユーザー情報を更新する
	    void updateUser(Users user);

	    // ユーザーを削除する
	    void deleteUser(String user_mail);
	}

