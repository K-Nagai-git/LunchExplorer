
//★★★★★★★★★★★★
// ここは新規店舗のレビュー登録・投稿のコントローラーです。
//ここで店舗の詳細レビューを投稿や画面の遷移をします。
//★★★★★★★★★★★★★★ 

//作成者　深田　1021　
//メモ：
//現時点でヘルパーが未実装。
//全てコメントアウトしている。
//また「こうなるだろう」という予測の元、名称をつけているので注意
//本人の理解力が低いため足りてない部分があるかも
//更新　深田　1030　頑張ります
//更新：糸山　2024/11/01　
//全面修正

package com.example.lunchex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.lunchex.entity.Detail;
import com.example.lunchex.entity.LoginUser;
import com.example.lunchex.entity.Stores;
import com.example.lunchex.entity.Users;
import com.example.lunchex.form.DetailForm;
import com.example.lunchex.form.StoresForm;
import com.example.lunchex.helper.DetailHelper;
import com.example.lunchex.helper.StoresHelper;
import com.example.lunchex.repository.AuthenticationMapper;
import com.example.lunchex.repository.LunchexListMapper;
import com.example.lunchex.repository.UsersMapper;
import com.example.lunchex.service.DetailService;
import com.example.lunchex.service.FileService;
import com.example.lunchex.service.StoresService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/detail")
@RequiredArgsConstructor
public class DetailController {
	private final AuthenticationMapper authenticationMapper;
	//店舗情報が判明してる場合の店舗ID一時保存用変数
	Integer storeId = null;	//時間がないための緊急処置　別の方法があるはずなのでのちに確認：糸山
	
	/** DI */
	private final StoresService storesService; 
	private final DetailService detailService;
	private final UsersMapper usersMapper;  // ログインニックネーム取得用
	private final LunchexListMapper mapper;
	
	/**画面表示*/
	//店舗データなし
	@GetMapping()
	public String showDetail(@ModelAttribute DetailForm form, StoresForm storesForm, Model model) {
		//login.htmlに遷移
		//return "/lunchexplorer";
		model.addAttribute("storesForm", new StoresForm()); // StoreFormはデータクラス
		return "detail";
	}
	
	//店舗データあり
	@GetMapping("/{id}")
	public String showStoresDetail(@PathVariable("id") int id, @ModelAttribute DetailForm form, StoresForm storesForm, Model model) {
		model.addAttribute("storesForm", new StoresForm()); // StoreFormはデータクラス
		System.out.println("通過チェック");
		System.out.println("IDチェック" + id);
		//店舗情報を取得
		Stores stores = storesService.getStoreById(id);
		
		System.out.println("データ取得チェック1" + stores.getStore_name());
		
		//DBから取得した店舗データを格納
		Stores storesData = new Stores();
		storesData.setStore_name(stores.getStore_name());
		storesData.setStore_tel(stores.getStore_tel());
		storesData.setStore_address(stores.getStore_address());
		storesData.setStore_url(stores.getStore_url());
		storesData.setUser_mail(stores.getUser_mail());
		
		//既に登録されている場合の現在ID
		storeId =id;
		
		System.out.println("登録済みデータ表示");
		//対象のある場合はFormへの変換
		StoresForm dataform = StoresHelper.convertStoresForm(storesData);
				
		System.out.println("データ取得チェック2" + dataform.getStoreName());
		
		//対象データがある場合はモデルにFormを追加
        model.addAttribute("storesForm", dataform);

		
        return "detail";
	}
	
	@GetMapping("/newView")
	public String newDetailView(@RequestParam("stores_id") Integer stores_id , Model model,RedirectAttributes attributes) {
		System.out.println("IDは" + stores_id);
		//記録者IDに対する情報を取得
		Stores stores = storesService.getStoreById(stores_id);
		System.out.println("店舗登録済み有無を確認");
		if(stores != null) {
			System.out.println("登録済みデータ表示");
			//対象のある場合はFormへの変換
			StoresForm form = StoresHelper.convertStoresForm(stores);

			//対象データがある場合はモデルにFormを追加
	        model.addAttribute("storesForm", form);

			return "/detail";
			
		}else {
			System.out.println("データなし");
			//対象データがない場合はフラッシュメッセージを設定
			attributes.addFlashAttribute("errorMessage", "対象データはありません");
			return "detail";
		}		
	}
	
	/** 店舗・詳細登録*/
	@GetMapping("/detailsave")
	public String newStoresDetailRegister(StoresForm storesForm, DetailForm detailForm ,@AuthenticationPrincipal LoginUser user) {
		
		//ｈｔｍｌフォームから取得した店舗データを格納
		StoresForm storesDate = new StoresForm();
		storesDate.setStoreName(storesForm.getStoreName());
		storesDate.setStoreTel(storesForm.getStoreTel());
		storesDate.setStoreAddress(storesForm.getStoreAddress());
		storesDate.setStoreUrl(storesForm.getStoreUrl());
		//storesDate.setStoreUserMail(storesForm.getStoreUserMail());
		
		System.out.println("★店舗ID変数チェック：" + storeId);
		System.out.println("★店舗IDチェック：" + storesDate.getStoreId());
		System.out.println("★店舗名チェック：" + storesDate.getStoreName());
		
		if (this.storeId != null) {
			if(storesDate.getStoreName() == null) {
				Stores keyStoresID = storesService.getStoreById(storeId);
				storesDate.setStoreId(storeId);
				storesDate.setStoreName(keyStoresID.getStore_name());
				storesDate.setStoreTel(keyStoresID.getStore_address());
				storesDate.setStoreAddress(keyStoresID.getStore_address());
				storesDate.setStoreUrl(keyStoresID.getStore_url());
			}
		}
		
		//店舗登録者のユーザーメールアドレスを取得
		Stores stores = storesService.getStoreByName(storesDate.getStoreName());
		//店舗登録がすでにある
		if(stores != null) {
			System.out.println("通過チェックストアユーザーID" + storesDate.getStoreUserMail());
			storesDate.setStoreUserMail(stores.getUser_mail());
		}
		//店舗登録がない場合
		else {
			System.out.println("通過チェックログインユーザーID" + user.getUsername());
			storesDate.setStoreUserMail(user.getUsername());
		}
		
		//DetailForm detailform = new DetailForm();
		System.out.println("★登録処理入り口" + storesDate);
		//店舗情報登録（新規・更新）
		System.out.println("★メールアドレス" + storesDate.getStoreUserMail());
		newStoresInsert(storesDate);
		
		//店舗ID取得
		Stores storesID = new Stores();
		storesID = storesService.getStoreByName(storesDate.getStoreName());
		
		//htmlフォームから取得した詳細データを格納
		DetailForm detailDate = new DetailForm();
		
		detailDate.setStoreId(storesID.getStore_id());
		detailDate.setDetailPostdt(detailForm.getDetailPostdt());
		//detailDate.setDitailUserMail(detailForm.getDitailUserMail());
		detailDate.setDitailUserMail(user.getUsername());
		detailDate.setDetailMenu(detailForm.getDetailMenu());
		detailDate.setDetailPrice(detailForm.getDetailPrice());
		detailDate.setDetailRating(detailForm.getDetailRating());
		detailDate.setDetailReviewFlag(detailForm.getDetailReviewFlag());
		detailDate.setDetailReview(detailForm.getDetailReview());
		//detailDate.setDetailImage(detailForm.getDetailImage());
		detailDate.setDetailMemo(detailForm.getDetailMemo());
		detailDate.setDetailUsedt(detailForm.getDetailUsedt());
		detailDate.setDetailVisits(detailForm.getDetailVisits());

		//ファイル名の取得
		if(getFileName() != null) {
			System.out.println("★ファイル名" + getFileName());
			detailDate.setDetailImage(getFileName());
			System.out.println("★画像イメージファイル名" + getFileName());
		}else {
			System.out.println("★アップロードファイルなし");
			detailDate.setDetailImage(detailForm.getDetailImage());
		}
		
		//詳細情報登録(新規)
		newDetail(detailDate);
		
		System.out.println("最終チェック" + detailDate.getStoreId());
		//return "redirect:/detail/";
		return "redirect:/lunchexplorer/details/" + detailDate.getStoreId();
	}
	/** 店舗登録*/
	//登録されていない店舗は新規登録、すでに登録されている店舗は更新として登録する
	public void newStoresInsert(StoresForm form) {
		System.out.println("店舗登録ユーザー" + form.getStoreUserMail());
		System.out.println("★" +form);
		System.out.println("通過チェック(店舗)");
		//登録されているIDかどうか確認
		Stores stores = storesService.getStoreByName(form.getStoreName());
		System.out.println("店舗登録済み有無を確認");
		if(stores != null) {
			System.out.println("すでに登録されている店舗IDです");
			//attributes.addFlashAttribute("errorMessage", "すでに登録されているIDです");
			//form.setIsNew(true);
			
			System.out.println("店舗更新登録");
		    System.out.println("店舗名: " + form.getStoreName());
		    System.out.println("★ユーザーメールアドレス: " + form.getStoreUserMail());
			//エンティティへの変換
			stores = StoresHelper.convertNewStores(form);
			System.out.println("エンティティへの変換通過");
			//登録実行
			storesService.updateStore(stores);
		}else {
			System.out.println("登録されていない店舗IDです");
			System.out.println("店舗新規登録");
			System.out.println("店舗名: " + form.getStoreName());
			//エンティティへの変換
			stores = StoresHelper.convertNewStores(form);
			System.out.println("エンティティへの変換通過");
			//登録実行
			storesService.addStore(stores);
		}
	}
	/** 詳細登録*/
		//詳細登録はすべて新規（時間が出きれな更新処理も追加）
		public void newDetail(DetailForm form) {
			System.out.println("通過チェック(詳細)");
			//エンティティへの変換
			Detail detail = DetailHelper.convertRecorder(form);
			System.out.println("エンティティへの変換通過");
			
//			//ファイル名の取得
//			if(getFileName() != null) {
//			System.out.println("★ファイル名" + getFileName());
//			detail.setDetail_image(getFileName());
//			System.out.println("★画像イメージファイル名" + getFileName());
//			}
			//登録実行
			detailService.addDetail(detail);
			
			// ファイル名を初期化
		    fileService.clearUploadedFileName();  // ここでファイル名を初期化
		}
		
		@Autowired
		private FileService fileService;

		@GetMapping("/getFileName")
		public String getFileName() {
		    return fileService.getUploadedFileName();
		}
	
//詳細ページの店舗検索機能　深田///////すごく長い！！！！！！！！！！！！！！！！！！！！！！！！		
		@GetMapping("/detailSearch")
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
//深田さんが書いたコード
////レビューする内容を登録する
////	@GetMapping("/search")
//	public String newDetailRegister() {
//		
//		
//		
//		
//		return null;
//		
//	}
//}






//避難用　深田
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.example.lunchex.entity.Detail;
//import com.example.lunchex.form.StoresForm.ReviewForm;
//import com.example.lunchex.helper.StoresHelper;
//import com.example.lunchex.service.DetailService;
//
//import jakarta.validation.Valid;
//
//@Controller
//@RequestMapping("/details")
//public class DetailController {
//    
//    private final DetailService detailService;
//    
//    public DetailController(DetailService detailService) {
//        this.detailService = detailService;
//    }
//
//    //  全ての詳細情報を表示する
//    @GetMapping
//    public String listDetails(Model model) {
//        List<Detail> detailsList = detailService.getAllDetails();
//        model.addAttribute("detailsList", detailsList);
//        return "details/list"; // 詳細一覧のページを表示する
//    }
//
//    // 新規詳細情報登録フォームを表示する
//    @GetMapping("/register")
//    public String showRegisterForm(Model model) {
//        model.addAttribute("reviewForm", new ReviewForm());
//        return "details/register"; // 登録フォームのページを表示する
//    }
//
//    // 新しい詳細情報を登録する
//    @PostMapping("/register")
//    public String registerDetail(@Valid @ModelAttribute("reviewForm") ReviewForm reviewForm, 
//                                 BindingResult result) {
//        if (result.hasErrors()) {
//            return "details/register"; // エラーがあれば再度フォームを表示
//        }
//        Detail detail = StoresHelper.convertToDetail(reviewForm); // フォームをエンティティに変換
//        detailService.addDetail(detail); // サービスを使って新しい詳細情報を保存
//        return "redirect:/details"; // 登録後、一覧ページにリダイレクト
//    }
//
//    // 特定の詳細情報を表示する
//    @GetMapping("/{detail_id}")
//    public String showDetail(@PathVariable("detail_id") int detailId, Model model) {
//        Detail detail = detailService.getDetailById(detailId);
//        model.addAttribute("detail", detail); // 詳細情報をモデルに追加
//        return "details/details"; // 詳細ページを表示する
//    }
//
//    //  詳細情報の編集フォームを表示する
//    @GetMapping("/edit/{detail_id}")
//    public String showEditForm(@PathVariable("detail_id") int detailId, Model model) {
//        Detail detail = detailService.getDetailById(detailId);
//        ReviewForm reviewForm = StoresHelper.convertToReviewForm(detail);
//        model.addAttribute("reviewForm", reviewForm);
//        return "details/edit"; // 編集フォームを表示
//    }
//
//    //  詳細情報を更新する
//    @PostMapping("/edit")
//    public String updateDetail(@Valid @ModelAttribute("reviewForm") ReviewForm reviewForm, 
//                               BindingResult result) {
//        if (result.hasErrors()) {
//            return "details/edit"; // エラーがあれば再度編集フォームを表示
//        }
//        Detail detail = StoresHelper.convertToDetail(reviewForm);
//        detailService.updateDetail(detail); // データベース内の情報を更新
//        return "redirect:/details"; // 更新後、一覧ページにリダイレクト
//    }
//
//    //  詳細情報を削除する
//    @PostMapping("/delete/{detail_id}")
//    public String deleteDetail(@PathVariable("detail_id") int detailId) {
//        detailService.deleteDetail(detailId); // 指定されたレビューを削除
//        return "redirect:/details"; // 削除後、一覧ページにリダイレクト
//    }
//}
