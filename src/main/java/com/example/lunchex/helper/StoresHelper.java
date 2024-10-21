//作成　木和田　1021
//更新　深田　1021
//メモ：
//深田が「entity」の「Userクラス」を当初、「Users」と名前をつけ。クラスを作成していたため、
//「User」に変更し、それにともないコードを修正




package com.example.lunchex.helper;

import java.util.Optional;

import com.example.lunchex.entity.Detail;
import com.example.lunchex.entity.Stores;
import com.example.lunchex.entity.User;
import com.example.lunchex.form.StoresForm.AccountRegisterForm;
import com.example.lunchex.form.StoresForm.ReviewForm;
import com.example.lunchex.form.StoresForm.StoreRegisterForm;

public class StoresHelper {

    // --- StoreRegisterForm から Stores エンティティへの変換 ---
    public static Stores convertToStores(StoreRegisterForm storeRegisterForm) {
        return Optional.ofNullable(storeRegisterForm).map(form -> {
            Stores stores = new Stores();
            stores.setStore_name(form.getStoreName());
            stores.setStore_tel(form.getStoreTel());
            stores.setStore_address(form.getStoreAddress());
            stores.setStore_url(form.getStoreUrl());
            return stores;
        }).orElse(null);
    }

    // --- ReviewForm から Detail エンティティへの変換 ---
    public static Detail convertToDetail(ReviewForm reviewForm) {
        return Optional.ofNullable(reviewForm).map(form -> {
            Detail detail = new Detail();
            detail.setDetail_menu(form.getReviewDishName());
            detail.setDetail_price(form.getReviewDishPrice());
            detail.setDetail_rating(form.getReviewDishRating());
            detail.setDetail_review(form.getComment());
            detail.setDetail_image(form.getImage());
            detail.setDetail_review_flag(form.isPublicReview());
            return detail;
        }).orElse(null);
    }

    // --- AccountRegisterForm から Users エンティティへの変換 ---
    public static User convertToUsers(AccountRegisterForm accountRegisterForm) {
        return Optional.ofNullable(accountRegisterForm).map(form -> {
            User users = new User();
            users.setUser_mail(form.getUserId());
            users.setUser_password(form.getPassword());
            return users;
        }).orElse(null);
    }

    // --- Stores エンティティから StoreRegisterForm への変換 ---
    public static StoreRegisterForm convertToStoreRegisterForm(Stores stores) {
        return Optional.ofNullable(stores).map(store -> {
            StoreRegisterForm storeRegisterForm = new StoreRegisterForm();
            storeRegisterForm.setStoreName(store.getStore_name());
            storeRegisterForm.setStoreTel(store.getStore_tel());
            storeRegisterForm.setStoreAddress(store.getStore_address());
            storeRegisterForm.setStoreUrl(store.getStore_url());
            return storeRegisterForm;
        }).orElse(null);
    }

    // --- Detail エンティティから ReviewForm への変換 ---
    public static ReviewForm convertToReviewForm(Detail detail) {
        return Optional.ofNullable(detail).map(det -> {
            ReviewForm reviewForm = new ReviewForm();
            reviewForm.setReviewDishName(det.getDetail_menu());
            reviewForm.setReviewDishPrice(det.getDetail_price());
            reviewForm.setReviewDishRating(det.getDetail_rating());
            reviewForm.setComment(det.getDetail_review());
            reviewForm.setImage(det.getDetail_image());
            reviewForm.setPublicReview(det.getDetail_review_flag());
            return reviewForm;
        }).orElse(null);
    }

    // --- Users エンティティから AccountRegisterForm への変換 ---
    public static AccountRegisterForm convertToAccountRegisterForm(User users) {
        return Optional.ofNullable(users).map(user -> {
            AccountRegisterForm accountRegisterForm = new AccountRegisterForm();
            accountRegisterForm.setUserId(user.getUser_mail());
            accountRegisterForm.setPassword(user.getUser_password());
            return accountRegisterForm;
        }).orElse(null);
    }
}