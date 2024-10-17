//作成　木和田　1017
package com.example.lunchex.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class StoresForm {

    // 店舗検索フォーム
    @Data
    public static class StoreSearchForm {
        @NotEmpty(message = "店舗名を入力してください")
        private String storeNameQuery; // 検索する店舗名
    }

    // アカウント登録フォーム
    @Data
    public static class AccountRegisterForm {
        @NotEmpty(message = "ユーザーIDを入力してください")
        private String userId; // ユーザーID（メールアドレスなど）

        @NotEmpty(message = "パスワードを入力してください")
        private String password; // パスワード
    }

    // レビュー投稿フォーム
    @Data
    public static class ReviewForm {
        @NotEmpty(message = "メニュー名を入力してください")
        private String reviewDishName; // レビューするメニュー名

        @Positive(message = "金額は正の数である必要があります")
        private int reviewDishPrice; // メニューの金額

        @Min(value = 1, message = "評価は1以上でなければなりません")
        @Max(value = 5, message = "評価は5以下でなければなりません")
        private int reviewDishRating; // メニューの評価

        private String comment; // 任意のコメント（特定の詳細についての意見）
        private String image; // 任意の画像URL（レビューに関連する画像）
        private boolean publicReview = false; // レビューを公開するかどうか（デフォルトで非公開）
    }

    // 新規店舗登録フォーム
    @Data
    public static class StoreRegisterForm {
        @NotEmpty(message = "店舗名を入力してください")
        private String storeName; // 登録する店舗名
        
        @NotEmpty(message = "電話番号を入力してください")
        private String storeTel; // 店舗の電話番号

        private String storeAddress; // 任意の店舗住所
        private String storeUrl; // 任意の店舗URL
    }
}
