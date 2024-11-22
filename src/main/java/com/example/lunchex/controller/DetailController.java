package com.example.lunchex.controller;

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
//更新　2024/11/14 永井　ニックネーム取得等を修正

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lunchex.entity.Detail;
import com.example.lunchex.entity.LoginUser;
import com.example.lunchex.entity.Stores;
import com.example.lunchex.form.DetailForm;
import com.example.lunchex.form.StoresForm;
import com.example.lunchex.helper.DetailHelper;
import com.example.lunchex.helper.StoresHelper;
import com.example.lunchex.service.DetailService;
import com.example.lunchex.service.FileService;
import com.example.lunchex.service.StoresService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/detail")
@RequiredArgsConstructor
public class DetailController {
	//店舗情報が判明してる場合の店舗ID一時保存用変数
	Integer storeId = null;	

	/** DI */
	private final StoresService storesService; 
	private final DetailService detailService;
	private final FileUploadController fileUploadController;

	@Autowired
	private FileService fileService; // 画像データ用	
	@Autowired
	private HomeController homeController;  // ログイン者ニックネーム取得用

	// ** 画面表示 ** 店舗データなし *********************************************************
	@GetMapping()
	public String showDetail(@ModelAttribute DetailForm form, StoresForm storesForm, Model model,
			@AuthenticationPrincipal LoginUser user) {

		model.addAttribute("storesForm", new StoresForm()); // StoreFormはデータクラス

		String loginNickname=homeController.loginNicknameGet(user);  // ログイン者のニックネーム取得	
		model.addAttribute("login_nickname",loginNickname);

		return "detail";
	}

	// ** 画面表示 ** 店舗データあり *********************************************************
	@GetMapping("/{id}")
	public String showStoresDetail(@PathVariable("id") int id, @ModelAttribute DetailForm detailform,
			StoresForm storesForm, Model model,	@AuthenticationPrincipal LoginUser user) {

		//店舗情報を取得、コンバートし、モデルに追加
		Stores stores = storesService.getStoreById(id);
		StoresForm dataform = StoresHelper.convertStoresForm(stores);	
		model.addAttribute("storesForm", dataform);

		//既に登録されている場合の現在ID
		storeId =id;

		String loginNickname=homeController.loginNicknameGet(user);  // ログイン者のニックネーム取得	
		model.addAttribute("login_nickname",loginNickname);

		return "detail";
	}


	//	** 登録 ******************************************************************************
	@PostMapping("/detailsave")
	public String newStoresDetailRegister(StoresForm storesForm, DetailForm detailForm ,
			@AuthenticationPrincipal LoginUser user) {

		// ** 店舗登録 ***********************************************************************
		if (storesForm.getStoreName() != null) {  // 店舗登録をする場合の処理

			storesForm.setStoreUserMail(user.getUsername());  // ログイン者のアドレスを店舗データにセット

			// 既存のデータに、同店名がある場合（データを更新）
			Stores stores = storesService.getStoreByName(storesForm.getStoreName());
			if (stores != null) {  // 同名店がある場合の処理（更新）
				storesForm.setStoreId(stores.getStore_id());  // 既存登録のIDを取得しセット
				stores = StoresHelper.convertNewStores(storesForm);
				storesService.updateStore(stores);  // 既存の登録を差し替え

				storeId=storesForm.getStoreId();  // 店舗IDを代入							

			// 同店名がない場合の処理（データを追加）
			} else {  
				stores = StoresHelper.convertNewStores(storesForm);
				storesService.addStore(stores);  // 追加登録

				// 新規登録したstore_idを取得
				Stores idGet = storesService.getStoreByName(storesForm.getStoreName());	
				storeId=idGet.getStore_id();
			}
		}
		
		// ** レビュー等登録 *****************************************************************

		detailForm.setStoreId(storeId);  // 店舗IDをレビューへセット	

		detailForm.setDitailUserMail(user.getUsername());  // ログイン者のアドレスをレビューへセット

		//画像のアップロード処理
		String UploadFileName = fileUploadController.handleFileUpload(detailForm.getFile());
		detailForm.setDetailImage(UploadFileName);  // 画像データをレビューへセット

		Detail detail = DetailHelper.convertRecorder(detailForm);
		detailService.addDetail(detail);  // レビューデータを追加

		// ファイル名を初期化
		fileService.clearUploadedFileName();  // ここでファイル名を初期化

		// 画像の保存処理が終わるまで待機(Eclipseで保存にタイムラグが出るため)
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}
		
		return "redirect:/lunchexplorer/details/" + storeId;

	}
}