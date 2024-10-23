-- ユーザー登録
-- 1件目のデータ登録
INSERT INTO users (user_mail, user_nickname, user_password)
VALUES ('kei.sub0523@gmail.com', 'kei', '8110');

-- 2件目のデータ登録
INSERT INTO users (user_mail, user_nickname, user_password)
VALUES ('keitaro.window@gmail.com', 'keisann', '811021');

-- 3件目のデータ登録
INSERT INTO users (user_mail, user_nickname, user_password)
VALUES ('kiwada@gmail.com', 'kiwada', '12356');

-- 店舗登録
-- 1件目のデータ登録
INSERT INTO stores (store_name, store_tel, store_address, store_url, user_mail)
VALUES ('Indian ,Nepali ,Famly Restaurant Bhatti', '0667558329', '大阪府大阪市中央区島之内2-13-31 島之内キャステール', 'https://www.seria-group.com', 'kei.sub0523@gmail.com');

-- 2件目のデータ登録
INSERT INTO stores (store_name, store_tel, store_address, store_url, user_mail)
VALUES ('ぶりあん 松屋町店', '0665248924', '大阪府大阪市中央区高津2-1-1', 'https://www.saria-group.com', 'kiwada@gmail.com');

-- 3件目のデータ登録
INSERT INTO stores (store_name, store_tel, store_address, store_url, user_mail)
VALUES ('鴻翔', '0632582142', '大阪府大阪市中央区島之内1-21-32 田舎ビル1F', 'https://www.siria-group.com', 'keitaro.window@gmail.com');

-- 詳細画面
-- 1件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits)
VALUES (1, '2024-10-01', 'kei.sub0523@gmail.com', '日替わりナンカレー', 500, 4, TRUE, 'ナンおかわり無料','IMG_3339.jpeg', '好みの辛さ', '2024-10-01', 1);

-- 2件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits)
VALUES (3, '2024-10-02', 'kiwada@gmail.com', '日替わりステーキ S', 400, 3, TRUE, '無難', 'IMG_3354.jpeg', 'ぶりあんスパイスがおススメです。', '2024-10-02', 2);

-- 3件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits)
VALUES (2, '2024-10-03', 'keitaro.window@gmail.com', '四川風麻婆豆腐', 400, 3, TRUE, 'コスパいい', 'IMG_5944.jpeg', '早い', '2024-10-02', 2);

-- 4件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits)
VALUES (2, '2024-10-05', 'kiwada@gmail.com', 'ラーメン', 400, 4, TRUE, 'まじうま', NULL, '野菜も多い', '2024-10-05', 2);
