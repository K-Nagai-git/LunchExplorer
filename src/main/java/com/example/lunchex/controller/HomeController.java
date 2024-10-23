// 更新　川口　1015　メモ：調子がいい
// 更新　糸山　1016　メモ：「home」の修正
//					他メソッド追加
package com.example.lunchex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lunchex.entity.Stores;
import com.example.lunchex.repository.LunchexListMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/lunchex")
@RequiredArgsConstructor

public class HomeController {

	/** DI */
	private final LunchexListMapper mapper;

	@GetMapping()
	public String showIndex(Model model) {
		
		List<Stores> storeList = mapper.selectStoreListAll();
		
		 model.addAttribute("stores", storeList);
		
		
		return "index";

	}

}

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//@RequiredArgsConstructor
//public class HomeController {
/**DI*/
//private final LunchexListMapper lunchexListMapper;

//    @GetMapping("/lunchexplorer")
//    public String home() {
//        return "index";
//    }
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