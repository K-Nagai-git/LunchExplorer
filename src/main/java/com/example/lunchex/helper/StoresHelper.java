//作成　木和田　1021
//更新　深田　1021
//メモ：
//深田が「entity」の「Userクラス」を当初、「Users」と名前をつけ。クラスを作成していたため、
//「User」に変更し、それにともないコードを修正
//更新　深田　1021　
//メモ：上記の修正をもとに戻す。クラス名を「Users」に変更
//更新　糸山　1106
//メモ　StoresHelperのクラスに合わせてStoresのエンティティ変換コードだけに変更


package com.example.lunchex.helper;

import com.example.lunchex.entity.Stores;
import com.example.lunchex.form.StoresForm;

//import java.util.Optional;
//
//import com.example.lunchex.entity.Detail;
//import com.example.lunchex.entity.Stores;
//import com.example.lunchex.entity.Users;
//import com.example.lunchex.form.StoresForm.AccountRegisterForm;
//import com.example.lunchex.form.StoresForm.ReviewForm;
//import com.example.lunchex.form.StoresForm.StoreRegisterForm;
//
public class StoresHelper {
	public static Stores convertStores(StoresForm form) {
	Stores stores = new Stores();
	
		//店舗ID
		stores.setStore_id(form.getStoreId());
		//店舗名
		stores.setStore_name(form.getStoreName());
		//店舗電話番号
		stores.setStore_tel(form.getStoreTel());
		//店舗住所
		stores.setStore_address(form.getStoreAddress());
		//店舗URL
		stores.setStore_url(form.getStoreUrl());
		//登録者ID
		stores.setUser_mail(form.getStoreUserMail());
	
		return stores;

	}
	public static Stores convertNewStores(StoresForm form) {
	Stores stores = new Stores();
	
		//店舗名
		stores.setStore_name(form.getStoreName());
		//店舗電話番号
		stores.setStore_tel(form.getStoreTel());
		//店舗住所
		stores.setStore_address(form.getStoreAddress());
		//店舗URL
		stores.setStore_url(form.getStoreUrl());
		//登録者ID
		stores.setUser_mail(form.getStoreUserMail());
	
		return stores;

	}
	public static StoresForm convertStoresForm(Stores stores) {
		StoresForm form = new StoresForm();

		//店舗ID
		form.setStoreId(stores.getStore_id());
		//店舗名
		form.setStoreName(stores.getStore_name());
		//店舗電話番号
		form.setStoreTel(stores.getStore_tel());
		//店舗住所
		form.setStoreAddress(stores.getStore_address());
		//店舗URL
		form.setStoreUrl(stores.getStore_url());
		//登録者ID
		form.setStoreUserMail(stores.getUser_mail());
		
		return form;
	}

}
		