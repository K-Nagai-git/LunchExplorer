package com.example.lunchex.controller;
/** 作成日：2024/10/24		*/
/** 作成者：糸山  			*/
/** 更新日：  				*/
/** 更新者：  				*/

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String showLogin(@ModelAttribute LoginForm form) {
		//login.htmlに遷移
		//return "/lunchexplorer";
		return "login";
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
