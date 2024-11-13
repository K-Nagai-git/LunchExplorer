package com.example.lunchex.controller;
/** 作成日：2024/10/24		*/
/** 作成者：糸山  			*/
/** 更新日：  				*/
/** 更新者：  				*/

//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lunchex.entity.Stores;
import com.example.lunchex.form.LoginForm;
import com.example.lunchex.repository.LunchexListMapper;

import lombok.RequiredArgsConstructor;



@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
	
	@GetMapping
	public String showLogin(@ModelAttribute LoginForm form,Model model) {
		//login.htmlに遷移
		//LoginFormをモデルに追加
		model.addAttribute("loginForm", new LoginForm());

		return "login";
	}
	
	@PostMapping("/authentication")
	public String authenticate(@ModelAttribute LoginForm loginForm, Model model) {
	    // loginForm を使った認証処理を実装
	    System.out.println("Username: " + loginForm.getUsername()); // デバッグ用
	    System.out.println("Password: " + loginForm.getPassword()); // デバッグ用

	    // 認証に成功した場合の処理
	    // ...

	    // 認証に失敗した場合は、エラーメッセージをモデルに追加して再表示
	    model.addAttribute("error", "usernameまたはpasswordが違います");
	    return "login"; // エラー表示のために再び login.html を表示
	}
	
	/** DI */
	private final LunchexListMapper mapper;

	//テストコード　動作確認完了後削除
	@GetMapping("loginafter")
	public String afterShowIndex(Model model) {
		System.out.println("通過チェック");
		List<Stores> storeList = mapper.selectStoreListPickDt();
	
		 model.addAttribute("stores", storeList);
		
		return "index";
	}
}
