//　作成　キワダさん　1025　
// 更新　糸山　1101
//　　　　　全変更

package com.example.lunchex.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StoresForm {
	/**店舗情報*/
	//店舗ID
	private Integer storeId;
	//店舗名
	@NotEmpty(message = "店舗名を入力してください")
	private String storeName;
    //店舗電話番号
	@NotNull(message = "店舗の電話番号を入力してください")
	private String storeTel;
    //店舗住所
	private String storeAddress;
    //店舗ホームぺーURL
	private String storeUrl;
    //投稿者ID（メールアドレス）
	@NotEmpty(message = "あなたのメールアドレスを入力してください")
	private String storeUserMail;
}
	/**木和田さん作成コード*/
//    // 新規店舗登録フォームのデータクラス
//    public static class StoreRegisterForm {
//        @NotEmpty(message = "店舗名を入力してください")
//        private String storeName; // 店舗名
//
//        @NotEmpty(message = "電話番号を入力してください")
//        private String storeTel; // 店舗の電話番号
//
//		public String getStoreName() {
//			// TODO 自動生成されたメソッド・スタブ
//			return null;
//		}
//
//		public String getStoreTel() {
//			// TODO 自動生成されたメソッド・スタブ
//			return null;
//		}
//        // 他のオプションフィールドをここに追加可能
//    }
//
//}

