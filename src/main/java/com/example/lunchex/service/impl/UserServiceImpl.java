// 作成　深田　1016　メモ：内容をあまり理解してない節がある
// 　　　　　　　　　メモ：Integer id のidは別の名前でいいかも

package com.example.lunchex.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//エンティティ
import com.example.lunchex.entity.Stores;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor


public class UserServiceImpl {

	private final UserMapper userMapper; 
	
	@Override
	public List<User> findAllUser() {
        return UserMapper.selectAll();
    }

	@Override
    public Stores findByIdUser (Integer id) {
        return UserMapper.selectById(id);
    }

	
	@Override
    public void insertUser(User user) {
        UserMapper.insert(user);
    }

	@Override
	    public void updateUser(User user) {
		   UserMapper.update(user);
	    }

	 @Override
	 public void deleteUser(Integer id) {
		   UserMapper.delete(id);
	    }
	
	
	
	
	
	
	
}
