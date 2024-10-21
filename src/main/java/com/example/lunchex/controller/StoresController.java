//作成者　深田　1021　
//メモ：
//現時点でヘルパーが未実装。
//全てコメントアウトしている。
//また「こうなるだろう」という予測の元、名称をつけているので注意
//本人の理解力が低いため足りてない部分があるかも

package com.example.lunchex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lunchex.entity.Stores;
import com.example.lunchex.form.StoresForm.StoreRegisterForm;
import com.example.lunchex.helper.StoresHelper;
import com.example.lunchex.service.StoresService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/stores")
public class StoresController {

    @Autowired
    private StoresService storesService;

    // 店舗一覧を表示
    @GetMapping
    public String listStores(Model model) {
        List<Stores> storesList = storesService.getAllStores(); // 全店舗を取得
        model.addAttribute("storesList", storesList); // モデルに店舗リストを追加
        return "stores/list"; // 店舗一覧のビューに遷移
    }

    // 店舗登録フォームの表示
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("storeForm", new StoreRegisterForm()); // フォームオブジェクトをモデルに追加
        return "stores/register"; // 店舗登録フォームのビューに遷移
    }

    // 新しい店舗を登録
    @PostMapping("/register")
    public String registerStore(@Valid @ModelAttribute("storeForm") StoreRegisterForm storeForm,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "stores/register"; // バリデーションエラーがあれば、フォームを再表示
        }
        Stores store = StoresHelper.convertToStores(storeForm); // フォームデータをエンティティに変換
        storesService.addStore(store); // 新しい店舗を追加
        return "redirect:/stores"; // 店舗一覧にリダイレクト
    }

    // 店舗詳細の表示
    @GetMapping("/{store_id}")
    public String showStoreDetails(@PathVariable("store_id") int storeId, Model model) {
        Stores store = storesService.getStoreById(storeId); // IDで店舗を取得
        model.addAttribute("store", store); // モデルに店舗情報を追加
        return "stores/details"; // 店舗詳細のビューに遷移
    }

    // 店舗編集フォームの表示
    @GetMapping("/edit/{store_id}")
    public String showEditForm(@PathVariable("store_id") int storeId, Model model) {
        Stores store = storesService.getStoreById(storeId); // IDで店舗を取得
        StoreRegisterForm storeForm = StoresHelper.convertToStoreRegisterForm(store); // エンティティからフォームに変換
        model.addAttribute("storeForm", storeForm); // モデルにフォームを追加
        return "stores/edit"; // 店舗編集フォームのビューに遷移
    }

    // 店舗情報を更新
    @PostMapping("/edit")
    public String updateStore(@Valid @ModelAttribute("storeForm") StoreRegisterForm storeForm,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "stores/edit"; // バリデーションエラーがあれば、フォームを再表示
        }
        Stores store = StoresHelper.convertToStores(storeForm); // フォームデータをエンティティに変換
        storesService.updateStore(store); // 店舗情報を更新
        return "redirect:/stores"; // 店舗一覧にリダイレクト
    }

    // 店舗を削除
    @PostMapping("/delete/{store_id}")
    public String deleteStore(@PathVariable("store_id") int storeId) {
        storesService.deleteStore(storeId); // IDで店舗を削除
        return "redirect:/stores"; // 店舗一覧にリダイレクト
    }
}
