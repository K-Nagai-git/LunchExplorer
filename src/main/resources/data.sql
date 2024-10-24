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

-- 4件目のデータ登録
INSERT INTO users (user_mail, user_nickname, user_password)
VALUES ('okada@gmail.com', 'okada', '1235621');

-- 5件目のデータ登録
INSERT INTO users (user_mail, user_nickname, user_password)
VALUES ('sawada@gmail.com', 'sawada', '4649');

-- 6件目のデータ登録
INSERT INTO users (user_mail, user_nickname, user_password)
VALUES ('maeda@gmail.com', 'maeda', '464921');

-- 7件目のデータ登録
INSERT INTO users (user_mail, user_nickname, user_password)
VALUES ('wada@gmail.com', 'wada', '4646');

-- 8件目のデータ登録
INSERT INTO users (user_mail, user_nickname, user_password)
VALUES ('kisida@gmail.com', 'kisida', '464621');

-- 9件目のデータ登録
INSERT INTO users (user_mail, user_nickname, user_password)
VALUES ('kuwata@gmail.com', 'kuwata', '114514');

-- 10件目のデータ登録
INSERT INTO users (user_mail, user_nickname, user_password)
VALUES ('honda@gmail.com', 'honda', '234649');

-- 11件目のデータ登録
INSERT INTO users (user_mail, user_nickname, user_password)
VALUES ('gonda@gmail.com', 'gonda', '5656');

-- 店舗登録
-- 1件目のデータ登録
INSERT INTO stores (store_name, store_tel, store_address, store_url, user_mail)
VALUES ('Indian ,Nepali ,Famly Restaurant Bhatti', '05055934536', '大阪府大阪市中央区島之内2-13-31 島之内キャステール', 'https://tabelog.com/osaka/A2701/A270201/27091191/', 'kei.sub0523@gmail.com');

-- 2件目のデータ登録
INSERT INTO stores (store_name, store_tel, store_address, store_url, user_mail)
VALUES ('ぶりあん 松屋町店', '0662130666', '大阪府大阪市中央区高津2-1-1', 'https://www.qraud.com/', 'keitaro.window@gmail.com');

-- 3件目のデータ登録
INSERT INTO stores (store_name, store_tel, store_address, store_url, user_mail)
VALUES ('鴻翔', '09044918958', '大阪府大阪市中央区島之内1-21-32 田舎ビル1F', 'https://tabelog.com/osaka/A2701/A270201/27056378/', 'kiwada@gmail.com');

-- 4件目のデータ登録
INSERT INTO stores (store_name, store_tel, store_address, store_url, user_mail)
VALUES ('どうとんぼり神座 千日前店', '0662131238', '大阪府大阪市中央区道頓堀1-6-32', 'https://tabelog.com/osaka/A2701/A270202/27001561/', 'okada@gmail.com');

-- 5件目のデータ登録
INSERT INTO stores (store_name, store_tel, store_address, store_url, user_mail)
VALUES ('すき家 長堀橋駅南店', '0120498007', '大阪府大阪市中央区島之内1丁目21-19', 'https://tabelog.com/osaka/A2701/A270201/27011674/', 'sawada@gmail.com');

-- 6件目のデータ登録
INSERT INTO stores (store_name, store_tel, store_address, store_url, user_mail)
VALUES ('家系ラーメン 頂喜家 長堀橋店', '0661216447', '大阪府大阪市中央区島之内1丁目19-15', 'https://tabelog.com/osaka/A2701/A270201/27118992/', 'kuwata@gmail.com');

-- 7件目のデータ登録
INSERT INTO stores (store_name, store_tel, store_address, store_url, user_mail)
VALUES ('鶏と牛のお店 火澄屋 （かすみや）', '0662433328', '大阪府大阪市中央区道頓堀1丁目7-25', 'https://tabelog.com/osaka/A2701/A270201/27108863/', 'honda@gmail.com');

-- 8件目のデータ登録
INSERT INTO stores (store_name, store_tel, store_address, store_url, user_mail)
VALUES ('よってや', '0662416115', '大阪府大阪市中央区島之内1-21-32', 'https://tabelog.com/osaka/A2701/A270201/27022234/', 'gonda@gmail.com');

-- 詳細画面
-- 1件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits)
VALUES (1, '2024-10-01', 'kei.sub0523@gmail.com', '日替わりナンカレー', 850, 5, TRUE, 'ナン２枚で満腹になりました。','IMG_3339.jpeg', 'ナンおかわり無料', '2024-10-01', 1);

-- 2件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits)
VALUES (2, '2024-10-02', 'keitaro.window@gmail.com', '日替わりステーキ M', 1000, 5, TRUE, 'ぶりあんスパイスがおススメです。', 'IMG_3354.jpeg', 'Mサイズで満腹', '2024-10-02', 1);

-- 3件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits)
VALUES (3, '2024-10-03', 'kiwada@gmail.com', '四川風麻婆豆腐定食B', 1250, 5, TRUE, '辛さの中に旨みがある。', 'IMG_5944.jpeg', '早い', '2024-10-02', 1);

-- 4件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits)
VALUES (4, '2024-10-04', 'okada@gmail.com', '野菜いっぱいラーメン', 1040, 4, TRUE, 'まじうま', NULL, '野菜も多い', '2024-10-02', 1);

-- 5件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits)
VALUES (5, '2024-10-04', 'sawada@gmail.com', 'ねぎ玉牛丼 並盛', 620, 4, TRUE, '致死量レベルのネギ', NULL, 'コスパ最高', '2024-10-04', 1);

-- 6件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits)
VALUES (4, '2024-10-05', 'maeda@gmail.com', 'おいしいラーメン', 790, 4, TRUE, '優しい味', NULL, '太りにくい', '2024-10-05', 1);

-- 7件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits)
VALUES (2, '2024-10-05', 'wada@gmail.com', '日替わりステーキ S', 800, 3, TRUE, 'がちうま', NULL, 'Sサイズは少し物足りない', '2024-10-05', 1);

-- 8件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits)
VALUES (5, '2024-10-06', 'kisida@gmail.com', '高菜明太マヨ牛丼 メガ', 1120, 3, TRUE, '高菜と明太マヨの相性最強', NULL, 'メガは午後眠たくなる', '2024-10-05', 1);

-- 9件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits)
VALUES (6, '2024-10-07', 'kuwata@gmail.com', 'デラックスラーメン', 1050, 4, TRUE, '味ガッツリ系', NULL, 'ごはん無料', '2024-10-05', 1);

-- 10件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits)
VALUES (7, '2024-10-08', 'honda@gmail.com', '火澄屋定食', 800, 5, TRUE, 'からあげでかい', NULL, 'ごはん大盛り無料', '2024-10-06', 1);

-- 11件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits)
VALUES (8, '2024-10-08', 'gonda@gmail.com', 'とりマヨ定食', 700, 5, TRUE, 'まじ安い', NULL, '量も多い', '2024-10-08', 1);
