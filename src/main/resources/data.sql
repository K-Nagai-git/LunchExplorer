--ユーザー登録
-- 1件目のデータ登録
INSERT INTO  users ( user_mail,user_nickname,user_password)
VALUES
('kei.sub0523@gmail.com','kei','8110');
-- 2件目のデータ登録
INSERT INTO  users (user_mail,user_nickname,user_password)
VALUES
('keitaro.window@gmail.com','keisann','811021');
-- 3件目のデータ登録
INSERT INTO  users (user_mail,user_nickname,user_password)
VALUES
('kiwada@gmail.com','kiwada','12356');

--店舗登録
-- 1件目のデータ登録 
INSERT INTO stores (store_name,store_tel,store_address,store_url,user_mail)
VALUES
('oniku','0667558329','兵庫県1','https://www.seria-group.com','kei.sub0523@gmail.com');
-- 2件目のデータ登録
INSERT INTO stores (store_name,store_tel,store_address,store_url,user_mail)
VALUES
('肉じゃが','0665248924','兵庫県2','https://www.saria-group.com','kiwada@gmail.com');
-- 3件目のデータ登録 
INSERT INTO stores (store_name,store_tel,store_address,store_url,user_mail)
VALUES
('肉','0632582142','兵庫3','https://www.siria-group.com','keitaro.window@gmail.com');


--  詳細画面
-- 1件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits
) 
VALUES 
(1, '2024-10-01', 'kei.sub0523@gmail.com', 'カレーライス', 500, 4, TRUE, 'お肉が柔らかい', NULL, '好みの辛さ', '2024-10-01', 1);
-- 2件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits
) 
VALUES 
(3, '2024-10-02', 'kiwada@gmail.com', '親子丼', 400, 3, TRUE, '無難', NULL, '早い', '2024-10-02', 2);
-- 3件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits
) 
VALUES 
(2, '2024-10-03', 'keitaro.window@gmail.com', 'ラーメン', 400, 3, TRUE, 'コスパいい', NULL, '早い', '2024-10-02', 2);


