// 作成　深田　1017　
//内容をあまり理解してない節がある
//Integer id のidは別の名前でいいかも
//作成時点でUserマッパーが存在しないことによるエラーが出る。
//一旦、全てコードにコメントアウトしている。

package com.example.lunchex.service.impl;

//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.lunchex.entity.Users;
//import com.example.lunchex.repository.UserMapper;
//import com.example.lunchex.service.UserService;
//
//import lombok.RequiredArgsConstructor;
//
///**User：サービス実装クラス*/
//
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class UserServiceImpl implements UserService {
//
//    /** DI (UserMapperを依存注入) */
//    private final UserMapper userMapper;
//
//    //全ユーザーを取得する
//    @Override
//    public List<Users> getAllUsers() {
//        return userMapper.selectAll(); 
//    }
//
//    //メールアドレスで指定されたユーザー情報を取得する
//    @Override
//    public Users getUserByMail(String user_mail) {
//        return userMapper.selectByMail(user_mail);  
//    }
//
//    //新しいユーザーを追加する
//    @Override
//    public void addUser(Users user) {
//        userMapper.insert(user);  
//    }
//
//    //既存のユーザー情報を更新する
//    @Override
//    public void updateUser(Users user) {
//        userMapper.update(user);  
//    }
//
//    // ユーザーを削除する
//    @Override
//    public void deleteUser(String user_mail) {
//        userMapper.delete(user_mail);  
//    }
//}
