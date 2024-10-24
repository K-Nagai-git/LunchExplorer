package com.example.lunchex.controller;
/** 作成日：2024/10/24		*/
/** 作成者：糸山  			*/
/** 更新日：  				*/
/** 更新者：  				*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lunchex.form.LoginForm;



@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping
	public String showLogin(@ModelAttribute LoginForm form) {
		//login.htmlに遷移
		return "/lunchexplorer";
		
	}
	
}
