//作成　深田　1025　　//詳細登録用のフォーム

package com.example.lunchex.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DetailForm {

    // メニュー情報登録フォームのデータクラス
    public static class MenuRegisterForm {
        @NotEmpty(message = "メニュー名を入力してください")
        private String menuName; // メニュー名

        @NotNull(message = "金額を入力してください")
        @Positive(message = "金額は正の値でなければなりません")
        private Integer price; // 金額

        @NotNull(message = "評価を選択してください")
        private Integer rating; // 評価（1から5）

        private String comment; // コメント（任意）

        private String photo; // 写真投稿（任意）

        @NotNull(message = "レビュー公開の選択が必要です")
        private Boolean isPublic; // レビューを公開するかしないか
    }
}

