package com.example.lunchex.service.impl;
/**作成日：2024/10/30 */
/**作成者：糸山  		*/
/**更新日：  			*/
/**更新者：  			*/
import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.lunchex.entity.Authentication;
import com.example.lunchex.entity.LoginUser;
import com.example.lunchex.repository.AuthenticationMapper;

import lombok.RequiredArgsConstructor;
/**
* カスタム認証サービス
*/
@Service
@RequiredArgsConstructor
public class LoginUserDatailsServiceImpl implements UserDetailsService {
	
	/** DI */
	private final AuthenticationMapper authenticationMapper;
	
@Override
	public UserDetails loadUserByUsername(String username) 
	throws UsernameNotFoundException {
		// 「認証テーブル」からデータを取得
		Authentication authentication = authenticationMapper.selectByUsername(username);
		System.out.println("unsernameデータチェック");
		System.out.println(authentication);
		// 対象データがあれば、UserDetailsの実装クラスを返す
		if (authentication != null) {
		// 対象データが存在する
		// UserDetailsの実装クラスを返す
		return new LoginUser(authentication.getUsers_mail(),
		authentication.getUsers_password(),
		Collections.emptyList()
		);
		} else {
		// 対象データが存在しない
		throw new UsernameNotFoundException(
		username + " => 指定しているユーザー名は存在しません");
		}
	}
}

//		//もともとあったコード
//		// 「ユーザー名：tarou」が入力されると、UserDetailsの実装クラスを返す
//		if (username.equals("tarou")) {
//		// 対象データが存在する
//		// UserDetailsの実装クラスを返す
//		return new LoginUser("tarou",
//		"pass",
//		Collections.emptyList());
//		} else {
//		// 対象データが存在しない
//		throw new UsernameNotFoundException(
//		username + " => 指定しているユーザー名は存在しません");
//		}
//	}
//}