//　作成　キワダさん　1025　

package com.example.lunchex.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class StoresForm {

    // 新規店舗登録フォームのデータクラス
    public static class StoreRegisterForm {
        @NotEmpty(message = "店舗名を入力してください")
        private String storeName; // 店舗名

        @NotEmpty(message = "電話番号を入力してください")
        private String storeTel; // 店舗の電話番号

		public String getStoreName() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}

		public String getStoreTel() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}
        // 他のオプションフィールドをここに追加可能
    }
}

