package com.example.lunchex.repository;
import org.apache.ibatis.annotations.Mapper;

/**作成日：2024/10/22  */
/**作成者：糸山  		*/
/**更新日：  			*/
/**更新者：  			*/
import com.example.lunchex.entity.Users;

@Mapper
public interface UsersMapper {
	/** ユーザー名でログイン情報を取得します。*/
	Users selectByUsername(String username);
	/**ユーザー全件検索 */
	Users getAllUsers();
	/**ユーザーIDで１件取得*/
	Users getUserByMail(String userMail);
	/**ユーザー登録*/
	void addUser(Users users);
	/**ユーザー更新*/
	void updateUser(Users users);
	/**ユーザー削除*/
	void deleteUser(String userMail);
}
