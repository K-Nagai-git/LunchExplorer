//作成 木和田 1016
package com.example.lunchex.service;

import java.util.List;

import com.example.lunchex.entity.User;

public interface UserService {

	    // 全ユーザーを取得する
	    List<User> getAllUsers();

	    // メールアドレスで指定されたユーザー情報を取得する
	    User getUserByMail(String user_mail);

	    // 新しいユーザーを追加する
	    void addUser(User user);

	    // 既存のユーザー情報を更新する
	    void updateUser(User user);

	    // ユーザーを削除する
	    void deleteUser(String user_mail);
	}

