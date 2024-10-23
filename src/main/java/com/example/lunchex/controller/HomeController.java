/** 作成日：10/15			*/
/** 作成者：川口     		*/
/** 更新日：10/16				*/
/** 更新者：糸山　「home」の修正	　　 		*/
/** 更新日：10/23				*/
/** 更新者：川口　トップページの表示確認用home.htmlからindex.htmlへ	　　 		*/
/************************/

package com.example.lunchex.controller;

//@Controller
//@RequestMapping("/lunchexplorer")
//@RequiredArgsConstructor
//
//public class HomeController {
//
//	/** DI */
//	private final LunchexListMapper mapper;
//
//	@GetMapping()
//	public String showIndex(Model model) {
//		
//		List<Stores> storeList = mapper.selectStoreListAll();
//		
//		 model.addAttribute("stores", storeList);
//		
//		return "index";
//	}
//}
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