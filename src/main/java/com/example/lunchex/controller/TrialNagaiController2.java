package com.example.lunchex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.lunchex.repository.LunchexListMapper;

import lombok.RequiredArgsConstructor;

/**
 * Lunchex：テスト用コントローラー
 */
@Controller
@RequestMapping("/lunchex")
@RequiredArgsConstructor
public class TrialNagaiController2 {

	//** DI *
	private final LunchexListMapper mapper;

	//	 * 詳細画面用データを表示
	//@GetMapping("/{id}")
	@GetMapping
	//public String detail(@PathVariable Integer id, Model model,
	public String detail(Model model,RedirectAttributes attributes) {
		// IDに対応する「レビュー」情報を取得
		model.addAttribute("lunchex", mapper.selectPickStoreList(2));
		System.out.println();
		System.out.println(model);
		System.out.println();	
		return "trial_nagai2";
	}
}
	
	
	//** DI *
	//	private final LunchexListMapper mapper;

	//	//	 * トップ画面用データの表示
	//	@GetMapping
	//	public String list(Model model) {
	//		model.addAttribute("lunchex", mapper.selectStoreListPickDt());
	//		System.out.println();
	//		System.out.println(model);
	//		System.out.println();
	//		return "trial_nagai";
	//	}

	//	//	 * 詳細画面用データを表示
	//	//@GetMapping("/{id}")
	//	@GetMapping
	//	//public String detail(@PathVariable Integer id, Model model,
	//	public String detail(Model model,RedirectAttributes attributes) {
	//		// IDに対応する「レビュー」情報を取得
	//		model.addAttribute("lunchex", mapper.selectPickStoreList(2));
	//		System.out.println();
	//		System.out.println(model);
	//		System.out.println();	
	//		return "trial_nagai";
	//	}
	//}

	//	//***<< Stores関係の動作確認　******************************************	
	//	//
	//	//** DI *	
	//	private final StoresMapper storesMapper;
	//
	//	//	//** 指定されたIDの店舗を表示
	//	//	@GetMapping
	//	//	public String store(Model model) {
	//	//		model.addAttribute("lunchex", storesMapper.getStoreById(2));
	//	//		System.out.println();
	//	//		System.out.println(model);
	//	//		System.out.println();		
	//	//		return "trial_nagai";
	//	//	}
	//	//}
	//
	//	//	** 新規登録
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
	//		//return "trial_nagai";
	//		//	}
	//		//}
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
	//		//		return "trial_nagai";
	//		//		}
	//		//	}
	//
	//		//	 ★削除
	//		storesMapper.deleteStore(9);
	//		System.out.println("=== 削除確認 ===");
	//		System.out.println(storesMapper.getStoreById(8));
	//		model.addAttribute("lunchex", storesMapper.getStoreById(8));
	//		System.out.println(storesMapper.getStoreById(9));
	////		model.addAttribute("lunchex", storesMapper.getStoreById(9));
	//		System.out.println();
	//		return "trial_nagai";
	//	}	
	//}

	//***<< Detail関係の動作確認　******************************************	
	//
	//** DI *	
//	private final DetailMapper detailMapper;

	//	//** レビュー全件を表示
	//	@GetMapping
	//	public String allDetail(Model model) {
	//		model.addAttribute("lunchex", detailMapper.selectAllDetail());
	//		System.out.println();
	//		System.out.println(model);
	//		System.out.println();		
	//		return "trial_nagai";
	//	}
	//}

	//	//** 指定されたIDのレビューを表示
	//	@GetMapping
	//	public String selectDetail(Model model) {
	//		model.addAttribute("lunchex", detailMapper.selectByIdDetail(2));
	//		System.out.println();
	//		System.out.println(model);
	//		System.out.println();		
	//		return "trial_nagai";
	//	}
	//}

	//	** 新規登録
//	@GetMapping
//	public String newDetail(Model model) {
//		Detail detail = new Detail();
//
//		detail.setStore_id(2);
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate date = LocalDate.parse("2024-10-28", formatter);			
//		detail.setDetail_postdt(date);
//		detail.setUser_mail("kiwada@gmail.com");
//		detail.setDetail_menu("あんぱん");
//		detail.setDetail_price(100);
//		detail.setDetail_rating(3);		
//		detail.setDetail_review("テスト、テスト");
//		detail.setDetail_usedt(date);
//		detail.setDetail_visits(3);
//
//		detailMapper.insertDetail(detail);
//		System.out.println("=== 登録確認 ===");
//		model.addAttribute("lunchex", detailMapper.selectByIdDetail(12));
//		System.out.println(detailMapper.selectByIdDetail(12));
//		System.out.println();
//		//		return "trial_nagai";
//		//	}
//		//}
//
//		//	// ★更新
//		Detail target = detailMapper.selectByIdDetail(12);
//		target.setStore_id(2);
//		//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		//		LocalDate date = LocalDate.parse("2024-10-28", formatter);			
//		target.setDetail_postdt(date);
//		target.setUser_mail("kiwada@gmail.com");
//		target.setDetail_menu("クリームぱん");
//		target.setDetail_price(150);
//		target.setDetail_rating(3);		
//		target.setDetail_review("お試し");
//		target.setDetail_usedt(date);
//		target.setDetail_visits(3);
//
//		detailMapper.updateDetail(target);
//		System.out.println("=== 更新確認 ===");
//		System.out.println(detailMapper.selectByIdDetail(12));
//		System.out.println();
//		//		return "trial_nagai";
//		//	}
//		//}
//		//
//		//	//	 ★削除
//		detailMapper.deleteDetail(12);
//		System.out.println("=== 削除確認 ===");
//		System.out.println(detailMapper.selectAllDetail());
//		model.addAttribute("lunchex", detailMapper.selectAllDetail());
//		//		System.out.println(detailMapper.selectByIdDetail(12));
//		//	model.addAttribute("lunchex", storesMapper.getStoreById(9));
//		System.out.println();
//		return "trial_nagai";
//	}	
//}
//
