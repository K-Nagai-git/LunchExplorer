/** 作成日：10/15			*/
/** 作成者：川口     		*/
/** 更新日：10/16				*/
/** 更新者：糸山　「home」の修正	　　 		*/
/** 更新日：10/23				*/
/** 更新者：川口　トップページの表示確認用home.htmlからindex.htmlへ	
 ** 更新者：深田　トップページの用のコードを追記　　 		
 ** 更新者：深田　詳細画面用のコードを追記
 ** 更新者：深田　ログイン時のトップページ画面のコードを追記
 */
/************************/

package com.example.lunchex.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.lunchex.entity.LoginUser;
import com.example.lunchex.entity.Stores;
import com.example.lunchex.entity.Users;
import com.example.lunchex.form.StoresForm;
import com.example.lunchex.repository.LunchexListMapper;
import com.example.lunchex.repository.UsersMapper;
import com.example.lunchex.service.StoresService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/lunchexplorer")
@RequiredArgsConstructor
@Service
public class HomeController {

	/** DI */
	private final LunchexListMapper mapper;
	private final UsersMapper usersMapper;  // ログインニックネーム取得用
	private final StoresService storesService; 

	// トップページ表示のコントローラー
	// @AuthenticationPrincipalでログインした人の情報をuserに格納	
	@GetMapping()
	public String showIndex(Model model,@AuthenticationPrincipal LoginUser user) {

		List<Stores> storeList;
		storeList = mapper.selectStoreListPickDt();

		String loginNickname=loginNicknameGet(user);  // ログイン者のニックネーム取得

		//モデルにぶち込む
		model.addAttribute("stores", storeList);
		model.addAttribute("login_nickname",loginNickname);
		// HTMLのテンプレートをそっと返す
		return "index";
	}

	//詳細画面表示のコントローラー 
	//店舗一覧から詳細ページの遷移　1030　深田
	@GetMapping("/details/{id}")
	public String showDetail
	( @PathVariable("id") int id,Model model,@AuthenticationPrincipal LoginUser user)//ストアIDを受け取ってint型のidに格納			
	{		

		//idに対応した店舗のレビュー情報を格納
		List<Stores> detailList=mapper.selectPickStoreList(id);

		String loginNickname=loginNicknameGet(user);  // ログイン者のニックネーム取得

		//モデルに追加
		model.addAttribute("stores",detailList);
		model.addAttribute("login_nickname",loginNickname);

		return "test2";
	}

	//トップページの店舗検索機能　深田
	@GetMapping("/topSearch")
	public String topSearch(StoresForm storesForm ,Model model,RedirectAttributes attributes,
			@AuthenticationPrincipal LoginUser user) {	

		// htmlフォームから取得した店舗データを格納
		Stores storesID = storesService.getStoreByName(storesForm.getStoreName());	

		//分岐！店舗情報があるときはこれを渡す
		if(storesID!=null) {
			int id=storesID.getStore_id();
			//idに対応した店舗のレビュー情報を格納
			List<Stores> detailList=mapper.selectPickStoreList(id);

			String loginNickname=loginNicknameGet(user);  // ログイン者のニックネーム取得

			//モデルに追加して渡す
			model.addAttribute("stores",detailList);
			model.addAttribute("login_nickname",loginNickname);

			return  "test2";
		}

		//分岐！店舗情報がないときはこれを渡す
		else {
			model.addAttribute("errorMessage", "該当する店舗が見つかりませんでした。");
			List<Stores> storeList;

			storeList = mapper.selectStoreListPickDt();

			String loginNickname=loginNicknameGet(user);  // ログイン者のニックネーム取得

			model.addAttribute("stores", storeList);
			model.addAttribute("login_nickname",loginNickname);

			return "index";
		}
	}

	// ログイン者のニックネームを取得（複数個所で使用）	
	public String loginNicknameGet(@AuthenticationPrincipal LoginUser user) {
		if (user != null) {    // ログインしている場合
			String loginEmail=user.getUsername();                  // ログイン者のe-mailを取得
			Users loginUser=usersMapper.getUserByMail(loginEmail); // ログイン者のユーザー情報を取得
			String loginNickname=loginUser.getUser_nickname();     // ログイン者のニックネームを取得            
			return loginNickname;     // ログイン者のニックネームを呼び出し元へ返す
		} else {    //  ログインしていない場合
			return null;
		}
	}

}
