package com.example.lunchex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lunchex.entity.Stores;
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

	
//	** 新規登録
	@GetMapping
	public String newStore(Model model) {
		Stores stores = new Stores();
		stores.setStore_name("俺のフレンチ");
		stores.setStore_tel("9876-5732");
		stores.setStore_address("京都市～");
		stores.setStore_url("www.abc.com");
		stores.setUser_mail("kiwada@gmail.com");           
		storesMapper.addStore(stores);
		System.out.println("=== 登録確認 ===");
		model.addAttribute("lunchex", storesMapper.getStoreById(9));
		System.out.println(storesMapper.getStoreById(9));
		System.out.println();
		return "test";
	}
	
	
//	@GetMapping("/form")
//	public String newLunch(@ModelAttribute LunchForm form) {
//	
//		// 新規登録画面の設定
//		form.setIsNew(true);
//		return "lunch/form";
//	}
//	
//	/**
//	 * 新規登録を実行します。
//	 */
//	@PostMapping("/save")
//	public String create(LunchForm form,RedirectAttributes attributes) {
//		// エンティティへの変換
//		// 文字列を LocalDate に変換
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate date = LocalDate.parse("2024-01-01", formatter);
//		// 変換した LocalDate を recentDate にセット
//		form.setRecentDate(date);
//		form.setTimes(0);
//		Lunch Lunch = LunchHelper.convertLunch(form);
//		// 登録実行
//		lunchService.insertLunch(Lunch);
//		// フラッシュメッセージ
//		attributes.addFlashAttribute("message", "新しいランチが登録されました");
//		// PRGパターン
//		return "redirect:/lunches";
//	}
	
	
	//
	///**
	// * 指定されたIDの修正画面を表示します。
	// */
	//@GetMapping("/edit/{id}")
	//public String edit(@PathVariable Integer id, Model model,
	//		RedirectAttributes attributes) {
	//	// IDに対応する「ランチ」を取得
	//	Lunch target = lunchService.findByIdLunch(id);
	//	if (target != null) {
	//		// 対象データがある場合はFormへの変換
	//		LunchForm form = LunchHelper.convertLunchForm(target);
	//		// モデルに格納
	//		model.addAttribute("lunchForm", form);
	//		return "lunch/form";            
	//	} else {
	//		// 対象データがない場合はフラッシュメッセージを設定
	//		attributes.addFlashAttribute("errorMessage", "対象データがありません");
	//		// 一覧画面へリダイレクト
	//		return "redirect:/lunches";            
	//	}
	//}
	//
	///**
	// * 「ランチ」の情報を更新します。
	// */
	//@PostMapping("/update")
	//public String update(LunchForm form, 
	//		RedirectAttributes attributes) {
	//	// エンティティへの変換
	//	Lunch Lunch = LunchHelper.convertLunch(form);
	//	// 更新処理
	//	lunchService.updateLunch(Lunch);
	//	// フラッシュメッセージ
	//	attributes.addFlashAttribute("message", "ランチが更新されました");
	//
	//	// ★フォームデータが正しくマッピングされているか確認
	//	System.out.println("Recent Date: " + form.getRecentDate()); 	
	//
	//	// PRGパターン
	//	return "redirect:/lunches";
	//}
	//// △△△△△ 13.7追加 △△△△△
	//
	///**
	// * 指定されたIDの前回利用日を更新します。
	// */
	//@PostMapping("/today/{id}")
	//public String today(@PathVariable Integer id, Model model,
	//		RedirectAttributes attributes) {
	//
	//	// IDに対応する「ランチ」を取得-1       
	//	Lunch target = lunchService.findByIdLunch(id);
	//	int times=target.getTimes()+1;
	//	System.out.println("times "+times);
	//
	//	// ★今日の日付を取得
	//	LocalDate today = LocalDate.now();
	//	// ★サービスでランチのrecentDateを今日に更新
	//	lunchService.updateRecentDate(id, today, times);
	//
	//	// IDに対応する「ランチ」を取得-2       
	//	target = lunchService.findByIdLunch(id);
	//
	//	if (target != null) {
	//
	//		// 対象データがある場合はFormへの変換
	//		LunchForm form = LunchHelper.convertLunchForm(target);
	//		System.out.println("form "+form.getTimes());
	//
	//		// モデルに格納
	//		model.addAttribute("lunchForm", form);
	//
	//		// エンティティへの変換
	//		Lunch Lunch = LunchHelper.convertLunch(form);
	//		// 更新処理
	//		lunchService.updateLunch(Lunch);
	//		// フラッシュメッセージ
	//		attributes.addFlashAttribute("message", "利用日が更新されました");
	//		// PRGパターン
	//		return "redirect:/lunches";
	//
	//	} else {
	//		// 対象データがない場合はフラッシュメッセージを設定
	//		attributes.addFlashAttribute("errorMessage", "対象データがありません");
	//		// 一覧画面へリダイレクト
	//		return "redirect:/lunches";            
	//	}
	//}
	//
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

}