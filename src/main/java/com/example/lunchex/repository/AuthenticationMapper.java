package com.example.lunchex.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.lunchex.entity.Authentication;
@Mapper

public interface AuthenticationMapper {
	/**	* ユーザー名でログイン情報を取得します。*/
	Authentication selectByUsername(String username);
}
