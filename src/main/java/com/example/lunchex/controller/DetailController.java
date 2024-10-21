//作成者　深田　1021　
//メモ：
//現時点でヘルパーが未実装。
//全てコメントアウトしている。
//また「こうなるだろう」という予測の元、名称をつけているので注意
//本人の理解力が低いため足りてない部分があるかも

package com.example.lunchex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lunchex.entity.Detail;
import com.example.lunchex.form.StoresForm.ReviewForm;
import com.example.lunchex.helper.StoresHelper;
import com.example.lunchex.service.DetailService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/details")
public class DetailController {
    
    private final DetailService detailService;
    
    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    //  全ての詳細情報を表示する
    @GetMapping
    public String listDetails(Model model) {
        List<Detail> detailsList = detailService.getAllDetails();
        model.addAttribute("detailsList", detailsList);
        return "details/list"; // 詳細一覧のページを表示する
    }

    // 新規詳細情報登録フォームを表示する
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("reviewForm", new ReviewForm());
        return "details/register"; // 登録フォームのページを表示する
    }

    // 新しい詳細情報を登録する
    @PostMapping("/register")
    public String registerDetail(@Valid @ModelAttribute("reviewForm") ReviewForm reviewForm, 
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "details/register"; // エラーがあれば再度フォームを表示
        }
        Detail detail = StoresHelper.convertToDetail(reviewForm); // フォームをエンティティに変換
        detailService.addDetail(detail); // サービスを使って新しい詳細情報を保存
        return "redirect:/details"; // 登録後、一覧ページにリダイレクト
    }

    // 特定の詳細情報を表示する
    @GetMapping("/{detail_id}")
    public String showDetail(@PathVariable("detail_id") int detailId, Model model) {
        Detail detail = detailService.getDetailById(detailId);
        model.addAttribute("detail", detail); // 詳細情報をモデルに追加
        return "details/details"; // 詳細ページを表示する
    }

    //  詳細情報の編集フォームを表示する
    @GetMapping("/edit/{detail_id}")
    public String showEditForm(@PathVariable("detail_id") int detailId, Model model) {
        Detail detail = detailService.getDetailById(detailId);
        ReviewForm reviewForm = StoresHelper.convertToReviewForm(detail);
        model.addAttribute("reviewForm", reviewForm);
        return "details/edit"; // 編集フォームを表示
    }

    //  詳細情報を更新する
    @PostMapping("/edit")
    public String updateDetail(@Valid @ModelAttribute("reviewForm") ReviewForm reviewForm, 
                               BindingResult result) {
        if (result.hasErrors()) {
            return "details/edit"; // エラーがあれば再度編集フォームを表示
        }
        Detail detail = StoresHelper.convertToDetail(reviewForm);
        detailService.updateDetail(detail); // データベース内の情報を更新
        return "redirect:/details"; // 更新後、一覧ページにリダイレクト
    }

    //  詳細情報を削除する
    @PostMapping("/delete/{detail_id}")
    public String deleteDetail(@PathVariable("detail_id") int detailId) {
        detailService.deleteDetail(detailId); // 指定されたレビューを削除
        return "redirect:/details"; // 削除後、一覧ページにリダイレクト
    }
}
