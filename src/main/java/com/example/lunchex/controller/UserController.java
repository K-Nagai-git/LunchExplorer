//作成 木和田 1021
//更新 木和田 1021 メモ：ハイフンが抜けていて、エラーになっていたところを修正。
package com.example.lunchex.controller;


//	import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.lunchex.entity.Users;
//import com.example.lunchex.form.StoresForm.AccountRegisterForm;
//import com.example.lunchex.service.UserService;
//
//import jakarta.validation.Valid;
//
//	
//
//	@Controller
//	public class UserController {
//
//	    @Autowired
//	    private UserService userService;
//
//	    // ユーザー登録フォームを表示
//	    @GetMapping("/user/register")
//	    public String showRegisterForm(Model model) {
//	        model.addAttribute("accountRegisterForm", new AccountRegisterForm());
//	        return "user_registration"; // ユーザー登録用テンプレート
//	    }
//
//	    // ユーザー登録処理
//	    @PostMapping("/user/register")
//	    public String registerUser(@Valid @ModelAttribute("accountRegisterForm") AccountRegisterForm accountRegisterForm,
//	                               BindingResult result, Model model) {
//	        if (result.hasErrors()) {
//	            return "user_registration"; // バリデーションエラーがあれば再表示
//	        }
//
//	        // 既存のユーザーがいるか確認
//	        Users existingUser = userService.getUserByMail(accountRegisterForm.getUserId());
//	        if (existingUser != null) {
//	            model.addAttribute("errorMessage", "このメールアドレスは既に使用されています");
//	            return "user_registration";
//	        }
//
//	        // 新しいユーザーを登録
//	        Users newUser = new Users();
//	        newUser.setUser_mail(accountRegisterForm.getUserId());
//	        newUser.setUser_password(accountRegisterForm.getPassword());
//	        userService.addUser(newUser);
//
//	        return "redirect:/user/login"; // 登録後はログインページへリダイレクト
//	    }
//
//	    // ログインフォーム表示
//	    @GetMapping("/user/login")
//	    public String showLoginForm() {
//	        return "user_login"; // ログイン用テンプレート
//	    }
//
//	    // ログイン処理
//	    @PostMapping("/user/login")
//	    public String loginUser(@RequestParam("userId") String userId, 
//	                            @RequestParam("password") String password, Model model) {
//	        Users user = userService.getUserByMail(userId);
//
//	        // ユーザーが存在するか、パスワードが一致するかチェック
//	        if (user == null || !user.getUser_password().equals(password)) {
//	            model.addAttribute("errorMessage", "ユーザーIDまたはパスワードが正しくありません");
//	            return "user_login"; // エラー時は再表示
//	        }
//
//	        // ログイン成功時の処理（セッション管理などはここで実装可能）
//	        return "redirect:/stores"; // ログイン成功後は店舗一覧ページへ
//	    }
//
//	    // ユーザー情報取得（詳細情報）
//	    @GetMapping("/user/detail")
//	    public String userDetail(@RequestParam("userId") String userId, Model model) {
//	        Users user = userService.getUserByMail(userId);
//	        if (user == null) {
//	            model.addAttribute("errorMessage", "ユーザーが見つかりません");
//	            return "error"; // ユーザーが見つからなかった場合はエラーページを表示
//	        }
//	        model.addAttribute("user", user);
//	        return "user_detail"; // ユーザー詳細情報表示用のテンプレート
//	    }
//
//	    // ユーザー削除処理
//	    @PostMapping("/user/delete")
//	    public String deleteUser(@RequestParam("userId") String userId) {
//	        userService.deleteUser(userId);
//	        return "redirect:/stores"; // 削除後は店舗一覧ページへリダイレクト
//	    }
//	}

