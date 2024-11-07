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

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.lunchex.entity.LoginUser;
import com.example.lunchex.entity.Stores;
import com.example.lunchex.entity.Users;
import com.example.lunchex.form.StoresForm;
import com.example.lunchex.repository.AuthenticationMapper;
import com.example.lunchex.repository.LunchexListMapper;
import com.example.lunchex.repository.UsersMapper;
import com.example.lunchex.service.StoresService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/lunchexplorer")
@RequiredArgsConstructor

public class HomeController {

	/** DI */
	private final LunchexListMapper mapper;
	private final AuthenticationMapper authenticationMapper;
	private final UsersMapper usersMapper;  // ログインニックネーム取得用
	private final StoresService storesService; 

	//	
	//	テストまち！！！！！！！！！！！！！！！！！！！！！！！深田
	//	
	//	//
	//トップページ表示のコントローラー（このコントローラー内でログインか未ログインか判別してHTMLに渡す
	//@AuthenticationPrincipalでログインした人の情報をuserに格納	
	@GetMapping()
	public String showIndex(Model model,@AuthenticationPrincipal LoginUser user) {

		//		　　テスト用深田
		System.out.println("------------------------------------通過チェック------------------------------------");
		System.out.println(user);//ログインの情報なのでニックネームは格納されていない



		List<Stores> storeList;
		List<LoginUser> userList = new ArrayList<>(); // ユーザー情報を格納するためのリスト

		// ユーザー情報が存在するか確認を行う。
		//ユーザー情報が存在する場合はこちらのListを渡す
		if (user != null) {
			storeList = mapper.selectStoreListPickDt();

			userList.add(user); // ログインしているユーザー情報をリストに追加

			String loginEmail=user.getUsername();  // ログイン者のニックネーム取得（この３行）永井
			Users loginUser=usersMapper.getUserByMail(loginEmail);
			String loginNickname=loginUser.getUser_nickname();            
			model.addAttribute("login_nickname",loginNickname);
			System.out.println("★"+loginNickname); // 削除可

		} 
		// ユーザー情報がない場合はこちらのListを渡す
		else {storeList = mapper.selectStoreListPickDt();
		}

		//判別が終了したLisｔををモデルにぶち込む
		model.addAttribute("stores", storeList);
		model.addAttribute("users",userList);
		// HTMLのテンプレートをそっと返す

		//			テスト用　深田
		//			System.out.println(userList);

		return "index";
	}

	//詳細画面表示のコントローラー 
	//店舗一覧から詳細ページの遷移確率OK　1030　深田
	@GetMapping("/details/{id}")
	public String showDetail
	( @PathVariable("id") int id,Model model,@AuthenticationPrincipal LoginUser user)//ストアIDを受け取ってint型のidに格納			
	{		
		//コンソールのテスト用　深田
		//				System.out.println("lllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");

		if (user != null) {
			String loginEmail=user.getUsername();  // ログイン者のニックネーム取得（この３行）永井
			Users loginUser=usersMapper.getUserByMail(loginEmail);
			String loginNickname=loginUser.getUser_nickname();            
			model.addAttribute("login_nickname",loginNickname);
			System.out.println("★"+loginNickname); // 削除可
		} 

		//idに対応した店舗のレビュー情報を格納
		List<Stores> detailList=mapper.selectPickStoreList(id);

		//モデルに追加
		model.addAttribute("stores",detailList);				

		//コンソールのテスト用　深田
		//				System.out.println(detailList);

		return "test2";
	}

//トップページの店舗検索機能　深田///////すごく長い！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
	@GetMapping("/topSearch")
	public String topSearch(StoresForm storesForm ,Model model,RedirectAttributes attributes,@AuthenticationPrincipal LoginUser user) {	
	
			//ｈｔｍｌフォームから取得した店舗データを格納
			StoresForm storesDate = new StoresForm();
			Stores storesID = new Stores();
			storesDate.setStoreName(storesForm.getStoreName());
		    storesID = storesService.getStoreByName(storesDate.getStoreName());	
   
    //トップページの店舗検索コントローラー		
	//分岐！店舗情報があるときはこれを渡す
			if(storesID!=null) {
				if (user != null) {
					String loginEmail=user.getUsername();  // ログイン者のニックネーム取得（この３行）永井
					Users loginUser=usersMapper.getUserByMail(loginEmail);
					String loginNickname=loginUser.getUser_nickname();            
					model.addAttribute("login_nickname",loginNickname);
					System.out.println("★"+loginNickname); // 削除可
				} 
				int id=storesID.getStore_id();
			//idに対応した店舗のレビュー情報を格納
			List<Stores> detailList=mapper.selectPickStoreList(id);
				//モデルに追加して渡す
			model.addAttribute("stores",detailList);
			return  "test2";
			}
			
	//トップページの店舗検索コントローラー		
	//分岐！店舗情報がないときはこれを渡す
			else {
				model.addAttribute("errorMessage", "該当する店舗が見つかりませんでした。");
			List<Stores> storeList;
			List<LoginUser> userList = new ArrayList<>(); // ユーザー情報を格納するためのリスト
			if (user != null) {
				storeList = mapper.selectStoreListPickDt();
				userList.add(user); // ログインしているユーザー情報をリストに追加
				String loginEmail=user.getUsername();  // ログイン者のニックネーム取得（この３行）永井
				Users loginUser=usersMapper.getUserByMail(loginEmail);
				String loginNickname=loginUser.getUser_nickname();            
				model.addAttribute("login_nickname",loginNickname);
				System.out.println("★"+loginNickname); // 削除可
			} 
			else {storeList = mapper.selectStoreListPickDt();
			}
			model.addAttribute("stores", storeList);
			model.addAttribute("users",userList);
			return "index";
		}
	}
}

//	//トップページ表示のコントローラー（一旦非表示　避難用に　実行：深田　）
//	@GetMapping()
//	public String showIndex(Model model) {
//		
//		
//		List<Stores> storeList = mapper.selectStoreListPickDt();//深田慶太郎　追記
//	
//		
//		
//		
//		 model.addAttribute("stores", storeList);
//		
//		return "index";
//	}
//	
//	//詳細画面表示のコントローラー 
//		@GetMapping("/details/2")
//		public String showDetail(  Model model) {
//			
//			System.out.println("lllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
//			
//			
//			List<Stores> detailList=mapper.selectPickStoreList(2);
//			
//			model.addAttribute("stores",detailList);
//			System.out.println(detailList);
//			
//			return "test2";
//		}

	
	
	
	

//@GetMapping("/lunchexplorer")
//public String home(Model model) {
//	model.addAttribute("lunchexList" , lunchexListMapper.selectStoreListAll());
//	 return "index";
//}
/**作成中他機能を作成の為一時作業停止　エラーになるのでコメントアウト：2024/10/17：糸山*/
////店舗検索
//@GetMapping("/storesSearch")
//public String storeSearch(@RequestParam("store_id") Integer store_id , Model model,RedirectAttributes attributes) {
////記録者IDに対する情報を取得
//		Stores store = StoreService.findByIdRecorder(store_id);
//
//		if(store != null) {
//			System.out.println("登録済みデータ表示");
//			//対象のある場合はFormへの変換
//			StoreForm form = StorsHelper.convertStoresForm(store);
//			form.setIsNew(false);
//			//対象データがある場合はモデルにFormを追加
//	        model.addAttribute("storesForm", form);
//
//			return "index";
//			
//		}else {
//			System.out.println("データなし");
//			//対象データがない場合はフラッシュメッセージを設定
//			attributes.addFlashAttribute("errorMessage", "対象データはありません");
//			return "redirect:/HomeController/lunchexplorer";
//		}
//	}

//}