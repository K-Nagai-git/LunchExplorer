package com.example.lunchex.helper;

import com.example.lunchex.entity.Detail;
import com.example.lunchex.form.DetailForm;

public class DetailHelper {
	/**Usersへの変換*/
	public static Detail convertRecorder(DetailForm form) {
		Detail detail = new Detail();
		
		//店舗ID
		detail.setStore_id(form.getStoreId());
		//投稿日
		detail.setDetail_postdt(form.getDetailPostdt());
		//ユーザーメールアドレス（レビュー投稿者）
		detail.setUser_mail(form.getDitailUserMail());
		//メニュー名
		detail.setDetail_menu(form.getDetailMenu());
		//金額
		detail.setDetail_price(form.getDetailPrice());
		//評価
		detail.setDetail_rating(form.getDetailRating());
		//レビュー表示フラグ
		detail.setDetail_review_flag(form.getDetailReviewFlag());
		//レビュー
		detail.setDetail_review(form.getDetailReview());
		//レビュー用画像
		detail.setDetail_image(form.getDetailImage());
		//メモ
		detail.setDetail_memo(form.getDetailMemo());
		//利用日付
		detail.setDetail_usedt(form.getDetailUsedt());
		//来店回数
		detail.setDetail_visits(form.getDetailVisits());
		
		return detail;
	}
	/**DetailFormへの変換*/
	public static DetailForm convertRecorderForm(Detail Detail) {
		
		DetailForm form = new DetailForm();
		
		//店舗ID
		form.setStoreId(Detail.getStore_id());
		//投稿日
		form.setDetailPostdt(Detail.getDetail_postdt());
		//ユーザーメールアドレス（レビュー投稿者）
		form.setDitailUserMail(Detail.getUser_mail());
		//メニュー名
		form.setDetailMenu(Detail.getDetail_image());
		//金額
		form.setDetailPrice(Detail.getDetail_price());
		//評価
		form.setDetailRating(Detail.getDetail_rating());
		//レビュー表示フラグ
		form.setDetailReviewFlag(Detail.getDetail_review_flag());
		//レビュー
		form.setDetailReview(Detail.getDetail_review());
		//レビュー用画像
		form.setDetailImage(Detail.getDetail_image());
		//メモ
		form.setDetailMemo(Detail.getDetail_memo());
		//利用日付
		form.setDetailUsedt(Detail.getDetail_usedt());
		//来店回数
		form.setDetailVisits(Detail.getDetail_visits());

		return form;
	}
}
