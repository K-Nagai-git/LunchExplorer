package com.example.lunchex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lunchex.repository.StoresMapper;

import lombok.RequiredArgsConstructor;

/**
 * Lunchex：テスト用コントローラー
 */
@Controller
@RequestMapping("/lunchex")
@RequiredArgsConstructor
public class TestController {

	//** DI *
	//	private final LunchexListMapper mapper;

	//	 * トップ画面用データの表示
	//	@GetMapping
	//	public String list(Model model) {
	//		model.addAttribute("lunchex", mapper.selectStoreListPickDt());
	//		System.out.println();
	//		System.out.println(model);
	//		System.out.println();
	//		return "test";
	//	}

	//	//	 * 指定されたIDの「ランチ」の詳細を表示します。
	////		@GetMapping("/{id}")
	//		@GetMapping
	////		public String detail(@PathVariable Integer id, Model model,
	//		public String detail(Model model,
	//				RedirectAttributes attributes) {
	//			// IDに対応する「レビュー」情報を取得
	//			model.addAttribute("lunchex", mapper.selectPickStoreList(2));
	//			System.out.println();
	//			System.out.println(model);
	//			System.out.println();	
	//			return "test";
	//		}
	//**********************************************************************	

	//** DI *	
	private final StoresMapper storesMapper;

	//	//** 指定されたIDの店舗を表示
	//	@GetMapping
	//	public String store(Model model) {
	//		model.addAttribute("lunchex", storesMapper.getStoreById(2));
	//		System.out.println();
	//		System.out.println(model);
	//		System.out.println();		
	//		return "test";
	//	}


//	////	** 新規登録
//	@GetMapping
//	public String newStore(Model model) {
//		Stores stores = new Stores();
//		stores.setStore_name("俺のフレンチ");
//		stores.setStore_tel("9876-5732");
//		stores.setStore_address("京都市～");
//		stores.setStore_url("www.abc.com");
//		stores.setUser_mail("kiwada@gmail.com");           
//		storesMapper.addStore(stores);
//		System.out.println("=== 登録確認 ===");
//		model.addAttribute("lunchex", storesMapper.getStoreById(9));
//		System.out.println(storesMapper.getStoreById(9));
//		System.out.println();
////		return "test";
//
//		// ★更新
//		Stores target = storesMapper.getStoreById(9);
//		target.setStore_name("あたいのイタリアン");
//		target.setStore_tel("0000-0000");
//		target.setStore_address("心斎橋～");
//		target.setStore_url("www.def.com");
//		target.setUser_mail("kiwada@gmail.com");          
//		storesMapper.updateStore(target);
//		System.out.println("=== 更新確認 ===");
//		System.out.println(storesMapper.getStoreById(9));
//		System.out.println();
//		return "test";
//	}
	
	// ★削除
//	storesMapper.deleteStore(9);
//	System.out.println("=== 削除確認 ===");
//	System.out.println(storesMapper.getStoreById(8));
//	model.addAttribute("lunchex", storesMapper.getStoreById(8));
//	System.out.println(storesMapper.getStoreById(9));
//	model.addAttribute("lunchex", storesMapper.getStoreById(9));
//	System.out.println();
//	return "test";
}	


	//// ▽▽▽▽▽ 13.11追加 ▽▽▽▽▽
	///**
	// * 指定されたIDの「ランチ」を削除します。
	// */
	//@PostMapping("/delete/{id}")
	//public String delete(@PathVariable Integer id, RedirectAttributes attributes) {
	//	// 削除処理
	//	lunchService.deleteLunch(id);
	//	// フラッシュメッセージ
	//	attributes.addFlashAttribute("message", "ランチが削除されました");
	//	// PRGパターン
	//	return "redirect:/lunches";
	//}
	//// △△△△△ 13.11追加 △△△△△
