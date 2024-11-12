//作成　深田　1025　　//詳細登録用のフォーム

package com.example.lunchex.form;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DetailForm {

    // メニュー情報登録フォームのデータクラス

    	
    	/**詳細（投稿）情報*/
    	//店舗ID
    	private Integer storeId;
    	//投稿日
    	private LocalDate detailPostdt;
    	//ユーザーメールアドレス
    	private String ditailUserMail;
    	//メニュー名
        @NotEmpty(message = "メニュー名を入力してください")   
        private String detailMenu; // メニュー名
    	//金額
        @NotNull(message = "金額を入力してください")
        @Positive(message = "金額は正の値でなければなりません")
        private Integer detailPrice; // 金額
    	//評価
        @NotNull(message = "評価を選択してください")
        private Integer detailRating; // 評価（1から5）
    	//レビュー表示フラグ
        @NotNull(message = "レビュー公開の選択が必要です")
        //private Boolean detailReviewFlag; // レビューを公開するかしないか
        private Boolean detailReviewFlag = true;  // デフォルトでtrueを設定
    	//レビュー       
        private String detailReview; // コメント（任意）
    	//レビュー用画像
        private String detailImage; // 写真投稿（任意）
        //画像ファイル
        private MultipartFile file;
    	//メモ
        private String detailMemo; 
    	//利用日付
        private LocalDate detailUsedt;
    	//来店回数
        private Integer detailVisits;
        
//        //boolean型用のGetterとSetter
//        // Getterメソッド（boolean型なので、isで始める）
//        public boolean isStoreReviewFlag() {
//            return detailReviewFlag;
//        }
//        // Setterメソッド
//        public void setStoreReviewFlag(boolean detailReviewFlag) {
//            this.detailReviewFlag = detailReviewFlag;
//        }
  
}

