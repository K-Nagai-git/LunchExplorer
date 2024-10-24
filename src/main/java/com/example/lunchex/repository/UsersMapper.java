package com.example.lunchex.repository;
/**作成日：2024/10/22  */
/**作成者：糸山  		*/
/**更新日：  			*/
/**更新者：  			*/
import com.example.lunchex.entity.Users;

public interface UsersMapper {
	/**ユーザーIDで１件取得*/
	Users getUserByMail(String userMail);
	/**ユーザー登録*/
	Users addUser(Users users);
	/**ユーザー更新*/
	Users updateUser(Users users);
	/**ユーザー削除*/
	Users deleteUser(String userMail);
}
