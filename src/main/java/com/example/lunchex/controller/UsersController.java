package com.example.lunchex.controller;
//作成 木和田 1021
//更新 木和田 1021 メモ：ハイフンが抜けていて、エラーになっていたところを修正。
/** 作成日：2024/10/21							*/
/** 作成者：木和田  							*/
/** 更新日：2024/10/21  						*/
/** 更新者：木和田  							*/
/** メモ：ハイフンが抜けていて、エラーになっていたところを修正。	*/
/** 更新日：2024/10/25  						*/
/** 更新者：糸山  								*/
/** メモ：コメントアウト部分を残して全体を修正			*/


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.lunchex.entity.Users;
import com.example.lunchex.form.UsersForm;
import com.example.lunchex.helper.UsersHelper;
import com.example.lunchex.service.UsersService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
	/**DI*/
	private final UsersService usersService;
	
	@GetMapping
	public String showUsers(@ModelAttribute UsersForm form) {
		//login.htmlに遷移
		//return "/lunchexplorer";
		return "users";
	}
	
	/**新規登録を実行します*/
	@PostMapping("/usersave")
	public String create(@Validated UsersForm form,
			BindingResult bindingResult,
			RedirectAttributes attributes) {
		System.out.println("通過チェック");
		//登録されているIDかどうか確認
		Users users = usersService.getUserByMail(form.getUserMail());
		System.out.println("登録済み有無を確認");
		
		
		if(users != null) {
			System.out.println("すでに登録されているIDです");
			attributes.addFlashAttribute("errorMessage", "すでに登録されているIDです");
			//form.setIsNew(true);
			
		}else {
			//==バリデーションチェック==
			//==入力チェックNG==
			if(bindingResult.hasErrors()) {
				System.out.println("空白あり");
				//form.setIsNew(false);
				return "users";
			}else {
			System.out.println("新規登録");
			//エンティティへの変換
			users = UsersHelper.convertRecorder(form);
			System.out.println("エンティティへの変換通過");
			//登録実行
			usersService.addUser(users);
			//フラッシュメッセージ
			attributes.addFlashAttribute("message", "記録者情報を登録しました");
			System.out.println("画面表示します");
			
			System.out.println("新規登録画面表示");
			//return "/login";
			}
		}
		//PRGパターン
		return "redirect:/users";
			
	}
}
