//
////★★★★★★★★★★★★
//// ここは新規店舗のレビュー登録・投稿のコントローラーです。
////ここで店舗の詳細レビューを投稿や画面の遷移をします。
////★★★★★★★★★★★★★★ 
//
////作成者　深田　1021　
////メモ：
////現時点でヘルパーが未実装。
////全てコメントアウトしている。
////また「こうなるだろう」という予測の元、名称をつけているので注意
////本人の理解力が低いため足りてない部分があるかも
////更新　深田　1030　頑張ります
////更新：糸山　2024/11/01　
////全面修正
////更新　2024/11/14 永井　ニックネーム取得等を修正
//
//package com.example.lunchex.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.example.lunchex.entity.Detail;
//import com.example.lunchex.entity.LoginUser;
//import com.example.lunchex.entity.Stores;
//import com.example.lunchex.form.DetailForm;
//import com.example.lunchex.form.StoresForm;
//import com.example.lunchex.helper.DetailHelper;
//import com.example.lunchex.helper.StoresHelper;
//import com.example.lunchex.repository.LunchexListMapper;
//import com.example.lunchex.service.DetailService;
//import com.example.lunchex.service.FileService;
//import com.example.lunchex.service.StoresService;
//
//import lombok.RequiredArgsConstructor;
//
//@Controller
//@RequestMapping("/detail")
//@RequiredArgsConstructor
//public class DetailController2 {
//	//店舗情報が判明してる場合の店舗ID一時保存用変数
//	Integer storeId = null;	
//
//	/** DI */
//	private final StoresService storesService; 
//	private final DetailService detailService;
//	private final LunchexListMapper mapper;
//	private final FileUploadController fileUploadController;
//
//	@Autowired
//	private HomeController homeController;  // ログイン者ニックネーム取得用
//
//	/**画面表示*/
//	//店舗データなし
//	@GetMapping()
//	public String showDetail(@ModelAttribute DetailForm form, StoresForm storesForm, Model model,
//			@AuthenticationPrincipal LoginUser user) {
//
//		//--↓ログイン判定処理　深田さんコード参照　2024/11/08　糸山----------------------------
//		List<Stores> storeList;
//
//		// ユーザー情報が存在するか確認を行う。
//		storeList = mapper.selectStoreListPickDt();
//
//		String loginNickname=homeController.loginNicknameGet(user);  // ログイン者のニックネーム取得	
//
//		//判別が終了したLisｔををモデルにぶち込む
//		model.addAttribute("stores", storeList);
//		model.addAttribute("login_nickname",loginNickname);
//
//		//--↑ログイン判定処理　深田さんコード参照　2024/11/08　糸山----------------------------
//
//		model.addAttribute("storesForm", new StoresForm()); // StoreFormはデータクラス
//		return "detail";
//	}
//
//	//店舗データあり
//	@GetMapping("/{id}")
//	public String showStoresDetail(@PathVariable("id") int id, @ModelAttribute DetailForm form, StoresForm storesForm, Model model) {
//		model.addAttribute("storesForm", new StoresForm()); // StoreFormはデータクラス
//		//店舗情報を取得
//		Stores stores = storesService.getStoreById(id);
//
//		//DBから取得した店舗データを格納
//		Stores storesData = new Stores();
//		storesData.setStore_name(stores.getStore_name());
//		storesData.setStore_tel(stores.getStore_tel());
//		storesData.setStore_address(stores.getStore_address());
//		storesData.setStore_url(stores.getStore_url());
//		storesData.setUser_mail(stores.getUser_mail());
//
//		//既に登録されている場合の現在ID
//		storeId =id;
//
//		//対象のある場合はFormへの変換
//		StoresForm dataform = StoresHelper.convertStoresForm(storesData);
//
//		//対象データがある場合はモデルにFormを追加
//		model.addAttribute("storesForm", dataform);
//
//		return "detail";
//	}
//
//	@GetMapping("/newView")
//	public String newDetailView(@RequestParam("stores_id") Integer stores_id , Model model,RedirectAttributes attributes) {
//
//		//記録者IDに対する情報を取得
//		Stores stores = storesService.getStoreById(stores_id);
//
//		if(stores != null) {
//
//			//対象のある場合はFormへの変換
//			StoresForm form = StoresHelper.convertStoresForm(stores);
//
//			//対象データがある場合はモデルにFormを追加
//			model.addAttribute("storesForm", form);
//
//			return "/detail";
//
//		}else {
//			System.out.println("データなし");
//			//対象データがない場合はフラッシュメッセージを設定
//			attributes.addFlashAttribute("errorMessage", "対象データはありません");
//			return "detail";
//		}		
//	}
//
//	/** 店舗・詳細登録*/
//	@PostMapping("/detailsave")
//	public String newStoresDetailRegister(StoresForm storesForm, DetailForm detailForm ,@AuthenticationPrincipal LoginUser user) {
//
//		//画像のアップロード処理
//		String UploadFileName = fileUploadController.handleFileUpload(detailForm.getFile());
//
//		//ｈｔｍｌフォームから取得した店舗データを格納
//		StoresForm storesDate = new StoresForm();
//		storesDate.setStoreName(storesForm.getStoreName());
//		storesDate.setStoreTel(storesForm.getStoreTel());
//		storesDate.setStoreAddress(storesForm.getStoreAddress());
//		storesDate.setStoreUrl(storesForm.getStoreUrl());
//		//storesDate.setStoreUserMail(storesForm.getStoreUserMail());
//
//
//		if (this.storeId != null) {
//			if(storesDate.getStoreName() == null) {
//				Stores keyStoresID = storesService.getStoreById(storeId);
//				storesDate.setStoreId(storeId);
//				storesDate.setStoreName(keyStoresID.getStore_name());
//				storesDate.setStoreTel(keyStoresID.getStore_address());
//				storesDate.setStoreAddress(keyStoresID.getStore_address());
//				storesDate.setStoreUrl(keyStoresID.getStore_url());
//			}
//		}
//
//		//店舗登録者のユーザーメールアドレスを取得
//		Stores stores = storesService.getStoreByName(storesDate.getStoreName());
//		//店舗登録がすでにある
//		if(stores != null) {
//
//			storesDate.setStoreUserMail(stores.getUser_mail());
//		}
//		//店舗登録がない場合
//		else {
//
//			storesDate.setStoreUserMail(user.getUsername());
//		}
//
//		//店舗情報登録（新規・更新）
//		newStoresInsert(storesDate);
//
//		//店舗ID取得
//		Stores storesID = new Stores();
//		storesID = storesService.getStoreByName(storesDate.getStoreName());
//
//		//htmlフォームから取得した詳細データを格納
//		DetailForm detailData = new DetailForm();
//
//		detailData.setStoreId(storesID.getStore_id());
//		detailData.setDetailPostdt(detailForm.getDetailPostdt());
//		detailData.setDitailUserMail(user.getUsername());
//		detailData.setDetailMenu(detailForm.getDetailMenu());
//		detailData.setDetailPrice(detailForm.getDetailPrice());
//		detailData.setDetailRating(detailForm.getDetailRating());
//		detailData.setDetailReviewFlag(detailForm.getDetailReviewFlag());
//		detailData.setDetailReview(detailForm.getDetailReview());
//		detailData.setDetailImage(UploadFileName);
//		detailData.setDetailMemo(detailForm.getDetailMemo());
//		detailData.setDetailUsedt(detailForm.getDetailUsedt());
//		detailData.setDetailVisits(detailForm.getDetailVisits());
//
//		//詳細情報登録(新規)
//		newDetail(detailData);
//
//		// 画像の保存処理が終わるまで待機(Eclipseで保存にタイムラグが出るため)
//		try {
//			Thread.sleep(4000);
//		} catch (Exception e) {
//		}
//
//		return "redirect:/lunchexplorer/details/" + detailData.getStoreId();
//	}
//	/** 店舗登録*/
//	//登録されていない店舗は新規登録、すでに登録されている店舗は更新として登録する
//	public void newStoresInsert(StoresForm form) {
//		//登録されているIDかどうか確認
//		Stores stores = storesService.getStoreByName(form.getStoreName());
//
//		if(stores != null) {
//
//			//エンティティへの変換
//			stores = StoresHelper.convertNewStores(form);
//
//			//登録実行
//			storesService.updateStore(stores);
//		}else {
//
//			//エンティティへの変換
//			stores = StoresHelper.convertNewStores(form);
//
//			//登録実行
//			storesService.addStore(stores);
//		}
//	}
//	/** 詳細登録*/
//	//詳細登録はすべて新規（時間が出きれな更新処理も追加）
//	public void newDetail(DetailForm form) {
//
//		//エンティティへの変換
//		Detail detail = DetailHelper.convertRecorder(form);
//
//
//		//登録実行
//		detailService.addDetail(detail);
//
//		// ファイル名を初期化
//		fileService.clearUploadedFileName();  // ここでファイル名を初期化
//	}
//
//	@Autowired
//	private FileService fileService;
//
//	@GetMapping("/getFileName")
//	public String getFileName() {
//		return fileService.getUploadedFileName();
//	}
//
//}	