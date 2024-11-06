package com.example.lunchex.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.lunchex.form.YourForm;

@Controller
public class YourController {
	   @GetMapping("/yourPage")
	    public String showForm(Model model) {
	        YourForm form = new YourForm();
	        form.setStoreName(LocalDate.now().toString()); // 今日の日付を設定
	        model.addAttribute("yourForm", form);
	        return "yourPage";
	    }
}
