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


--  詳細画面

-- 1件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits
) 
VALUES 
(1, '2024-10-01', 'abc@def.ne.jp', 'カレーライス', 500, 4, TRUE, 'お肉が柔らかい', NULL, '好みの辛さ', '2024-10-01', 1);
-- 2件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits
) 
VALUES 
(3, '2024-10-02', 'xyz@aaa.ne.jp', '親子丼', 400, 3, TRUE, '無難', NULL, '早い', '2024-10-02', 2);
-- 3件目のデータ登録
INSERT INTO detail (store_id, detail_postdt, user_mail, detail_menu, detail_price, detail_rating, detail_review_flag, detail_review, detail_image, detail_memo, detail_usedt, detail_visits
) 
VALUES 
(2, '2024-10-03', 'ijk@bbb.ne.jp', 'ラーメン', 400, 3, TRUE, '無難', NULL, '早い', '2024-10-02', 2);


--店舗登録

-- 1件目のデータ登録 
INSERT INTO stores (store_id,store_name,store_tel,store_address,store_url,user_mail)
VALUES
('oniku','0667558329','兵庫県1','https://www.seria-group.com','kiwad@gmail.com');
-- 2件目のデータ登録
INSERT INTO stores (store_id,store_name,store_tel,store_address,store_url,user_mail)
VALUES
('肉じゃが','0665248924','兵庫県2','https://www.saria-group.com','kiwakiwa@gmail.com');
-- 3件目のデータ登録 
INSERT INTO stores (store_id,store_name,store_tel,store_address,store_url,user_mail)
VALUES
('jyagaimo','肉','0632582142','兵庫3','https://www.siria-group.com','oowada@gmail.com');




