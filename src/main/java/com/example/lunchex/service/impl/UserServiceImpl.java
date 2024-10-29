// 作成　深田　1017　
//内容をあまり理解してない節がある
//Integer id のidは別の名前でいいかも
//作成時点でUserマッパーが存在しないことによるエラーが出る。
//一旦、全てコードにコメントアウトしている。

package com.example.lunchex.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.lunchex.entity.Users;
import com.example.lunchex.repository.UsersMapper;
import com.example.lunchex.service.UsersService;

import lombok.RequiredArgsConstructor;

/**User：サービス実装クラス*/


@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService {

    /** DI (UserMapperを依存注入) */
    private final UsersMapper usersMapper;

    //全ユーザーを取得する
//    @Override
//    public List<Users> getAllUsers() {
//        return usersMapper.getAllUsers(); 
//    
//    }

    //メールアドレスで指定されたユーザー情報を取得する
    @Override
    public Users getUserByMail(String user_mail) {
        return usersMapper.getUserByMail(user_mail);  
    }

    //新しいユーザーを追加する
    @Override
    public void addUser(Users user) {
        usersMapper.addUser(user);  
    }

    //既存のユーザー情報を更新する
    @Override
    public void updateUser(Users user) {
        usersMapper.updateUser(user);  
    }

    // ユーザーを削除する
    @Override
    public void deleteUser(String user_mail) {
        usersMapper.deleteUser(user_mail);  
    }
}
