//作成者　深田　1021　
//メモ：
//現時点でヘルパーが未実装。
//全てコメントアウトしている。
//また「こうなるだろう」という予測の元、名称をつけているので注意
//本人の理解力が低いため足りてない部分があるかも
//更新　深田　1025　新規店舗登録のためのコードを記載と修正を行う。あと若干まだ理解不足かも
//更新　深田　1029　25日の続き。分からなくて泣きそう。大工事中。
//更新　深田　1029　29の続き。ゴール見えなくて今日も泣きそう。天気がいい。

package com.example.lunchex.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lunchex.entity.Stores;
import com.example.lunchex.entity.Users;
import com.example.lunchex.service.StoresService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoresController {
	
	/** DI */
	private  final StoresService storesService; //まだ理解してない　深田
	
	
	//登録画面最初のページに移動
	//説明→まず店舗がDBにあるかどうかの検索を行う。
	//いちよ、ログインしているユーザのデータと時間のデータを渡しているがHTMLで表示はしていない。
	@GetMapping()
	public String showStoresRegister(Model model,@AuthenticationPrincipal Users user){
		List<Users> userList = new ArrayList<>();
	    userList.add(user); // ログインしているユーザー情報をリストに追加
	    model.addAttribute("currentDate", LocalDate.now().toString());
	   
			return "storeSearch";
	}
	@GetMapping("/search")
	public String StoreSearch(
	    @RequestParam("storeName") String storeName,
	    @RequestParam("storeTel") String storeTel,
	    Model model,
	    @AuthenticationPrincipal Users user
	) {
	    // テスト用: HTMLから受け取ったデータをコンソールに表示
	    System.out.println("店舗名: " + storeName);
	    System.out.println("電話番号: " + storeTel);
	    
	    List<Stores> allStores = storesService.getAllStores();
	    
	    // 入力データと比較
	    boolean exists = allStores.stream().anyMatch(store -> 
	        storeName != null && storeTel != null && 
	        storeName.equals(store.getStore_name()) && 
	        storeTel.equals(store.getStore_tel())
	    );

	    // 店舗が存在する場合
	    if (exists) {
	        model.addAttribute("storeName", storeName);
	        model.addAttribute("storeTel", storeTel);
	        model.addAttribute("currentDate", LocalDate.now().toString());
	        return "storeSerchResult"; // 存在する場合の画面に遷移
	    } else {
	        // 店舗が存在しない場合
	        model.addAttribute("storeName", storeName);
	        model.addAttribute("storeTel", storeTel);
	        model.addAttribute("currentDate", LocalDate.now().toString());
	        return "newDetailRegister"; // 新規登録画面に遷移
	    }
	}

//	//「次へ」をクリックすると「/stores/search」のURLに飛ぶようにHTMLで設定
//	@GetMapping("/search")
//	public String StoreSearch(
//	
//	@RequestParam("storeName")String storeName,//HTMLで入力された店舗の名前が格納される
//	@RequestParam("storeTel") String storeTel,//HTMLで入力された電話番号が格納される
//	Model model ,
//	@AuthenticationPrincipal Users user       //Users型のuserにユーザ情報を格納
//	) {
//		
//		
//		//☆テスト用☆ HTMLから受け取ったデータをコンソールに表示
//        System.out.println("店舗名: " + storeName);
//        System.out.println("電話番号: " + storeTel);
//        
//        List<Stores> allStores = storesService.getAllStores();//ストアの全てのデータがここに入るはず・・・
//        
//        // 入力データと比較　　正直、意味不明
//        boolean exists = allStores.stream().anyMatch(store ->
//                store.getStore_name().equals(storeName) && store.getStore_tel().equals(storeTel));
//         
//        // 店舗が既に存在する場合の処理
//        // すでに登録されているので詳細登録に飛ばすHTMLを表示する。
//        //ちなみに「exists」にしている理由は特にない。
//        if (exists) {
//           
//            model.addAttribute("storeName", storeName);  //HTMLで入力された店舗名をモデルに格納
//            model.addAttribute("storeTel", storeTel);    //HTMLで入力された電話番号をモデルに格納
//            model.addAttribute("currentDate", LocalDate.now().toString()); // 日付も再設定
//            
//            
//            return "storeSerchResult"; // まだ実装途中。名前はわかりやすいようにしている。ここの画面が画面の「i」になる。
//            
//            
//        
//         // 店舗が存在しない場合の処理
//         // 店舗が登録されていないので、新規登録処理を続ける。詳細入力に進む。フィグマでいうと「K」に当たる
//        
//        } else {
//        	
//        	 model.addAttribute("storeName", storeName);  //HTMLで入力された店舗名をモデルに格納
//             model.addAttribute("storeTel", storeTel);    //HTMLで入力された電話番号をモデルに格納
//             model.addAttribute("currentDate", LocalDate.now().toString()); // 日付も再設定（面倒なのでこの処理）
//            
//            return "newDetailRegister"; // 詳細入力にHTMLに進む。
//        }
//        
//        
//        
//	}
}
	
	
	
	
	
	
	
// 深田　避難用	
//	 public String showStoresSearch(@Validated StoresForm form,
//				BindingResult bindingResult,
//				RedirectAttributes attributes) {
//			System.out.println("通過チェック");
//			//登録されているIDかどうか確認
//			Users users = storesService.getUserByMail(form.getAllStores());
//			System.out.println("登録済み有無を確認");

			 

//　避難用　深田
//    // 新規店舗登録画面の表示
//    @GetMapping("/stores/register")
//    public String showStoreRegister(Model model) {
//        model.addAttribute("storeForm", new StoreRegisterForm());
//        
//        // ユーザー名をセッションや認証から取得する場合
//        //ログインしているユーザーの情報を表示するように後々切り替え
//        String username = "サンプルユーザー"; // 実際にはセッションから取得
//        model.addAttribute("username", username);
//
//        // 投稿日（現在の日付）
//        model.addAttribute("currentDate", LocalDate.now().toString());
//
//        return "store_register";  // store_register.htmlに遷移
//    }
//
//    // 新規店舗登録処理
//    @PostMapping("/stores/register")
//    public String registerStore(@Valid @ModelAttribute("storeForm") StoreRegisterForm storeForm, 
//                                BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            // エラーがあればフォームに戻る
//            model.addAttribute("username", "サンプルユーザー"); // 再度ユーザー名を設定
//            model.addAttribute("currentDate", LocalDate.now().toString()); // 日付も再設定
//            return "store_register";
//        }
//
//        // サービスを使って店舗情報を登録
// //       storesService.addStore(storeForm);
//
//        // 次のページにリダイレクト
//        return "redirect:/stores/confirmation";  // 確認ページにリダイレクト
//    }
//    



//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.example.lunchex.entity.Stores;
//import com.example.lunchex.form.StoresForm.StoreRegisterForm;
//import com.example.lunchex.helper.StoresHelper;
//import com.example.lunchex.service.StoresService;
//
//import jakarta.validation.Valid;
//
//@Controller
//@RequestMapping("/stores")
//public class StoresController {
//
//    @Autowired
//    private StoresService storesService;
//
//    // 店舗一覧を表示
//    @GetMapping
//    public String listStores(Model model) {
//        List<Stores> storesList = storesService.getAllStores(); // 全店舗を取得
//        model.addAttribute("storesList", storesList); // モデルに店舗リストを追加
//        return "stores/list"; // 店舗一覧のビューに遷移
//    }
//
//    // 店舗登録フォームの表示
//    @GetMapping("/register")
//    public String showRegisterForm(Model model) {
//        model.addAttribute("storeForm", new StoreRegisterForm()); // フォームオブジェクトをモデルに追加
//        return "stores/register"; // 店舗登録フォームのビューに遷移
//    }
//
//    // 新しい店舗を登録
//    @PostMapping("/register")
//    public String registerStore(@Valid @ModelAttribute("storeForm") StoreRegisterForm storeForm,
//                                 BindingResult result) {
//        if (result.hasErrors()) {
//            return "stores/register"; // バリデーションエラーがあれば、フォームを再表示
//        }
//        Stores store = StoresHelper.convertToStores(storeForm); // フォームデータをエンティティに変換
//        storesService.addStore(store); // 新しい店舗を追加
//        return "redirect:/stores"; // 店舗一覧にリダイレクト
//    }
//
//    // 店舗詳細の表示
//    @GetMapping("/{store_id}")
//    public String showStoreDetails(@PathVariable("store_id") int storeId, Model model) {
//        Stores store = storesService.getStoreById(storeId); // IDで店舗を取得
//        model.addAttribute("store", store); // モデルに店舗情報を追加
//        return "stores/details"; // 店舗詳細のビューに遷移
//    }
//
//    // 店舗編集フォームの表示
//    @GetMapping("/edit/{store_id}")
//    public String showEditForm(@PathVariable("store_id") int storeId, Model model) {
//        Stores store = storesService.getStoreById(storeId); // IDで店舗を取得
//        StoreRegisterForm storeForm = StoresHelper.convertToStoreRegisterForm(store); // エンティティからフォームに変換
//        model.addAttribute("storeForm", storeForm); // モデルにフォームを追加
//        return "stores/edit"; // 店舗編集フォームのビューに遷移
//    }
//
//    // 店舗情報を更新
//    @PostMapping("/edit")
//    public String updateStore(@Valid @ModelAttribute("storeForm") StoreRegisterForm storeForm,
//                               BindingResult result) {
//        if (result.hasErrors()) {
//            return "stores/edit"; // バリデーションエラーがあれば、フォームを再表示
//        }
//        Stores store = StoresHelper.convertToStores(storeForm); // フォームデータをエンティティに変換
//        storesService.updateStore(store); // 店舗情報を更新
//        return "redirect:/stores"; // 店舗一覧にリダイレクト
//    }
//
//    // 店舗を削除
//    @PostMapping("/delete/{store_id}")
//    public String deleteStore(@PathVariable("store_id") int storeId) {
//        storesService.deleteStore(storeId); // IDで店舗を削除
//        return "redirect:/stores"; // 店舗一覧にリダイレクト
//    }
//}
