--テーブルが存在したら削除する
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS store;
DROP TABLE IF EXISTS detail;


--テーブル作成
--ユーザーテーブル
CREATE TABLE users(
	user_mail_id 	VARCHAR PRIMARY KEY,
	user_nickname 	VARCHAR NOT NULL,
	user_password 	VARCHAR NOT NULL
);
--店舗テーブル
CREATE TABLE store(
	store_id 		serial PRIMARY KEY,
	store_name 		VARCHAR NOT NULL,
	store_tel 		VARCHAR NOT NULL,
	store_address 	VARCHAR,
	store_url 		VARCHAR,
	Registration_id INTEGER NOT NULL
);

--詳細テーブル
CREATE TABLE detail(
	detail_id 			serial,
	store_id 			INTEGER NOT NULL,
	detail_postdt 		DATE NOT NULL,
	user_id 			INTEGER NOT NULL,
	detail_menu 		VARCHAR NOT NULL,
	detail_price 		INTEGER NOT NULL,
	detail_rating 		VARCHAR NOT NULL,
	detail_review_flag 	BOOLEAN DEFAULT 'true',
	detail_review 		VARCHAR,
	detail_image 		VARCHAR,
	detail_memo 		VARCHAR,
	detail_usedt 		DATE NOT NULL,
	detail_visits 		INTEGER NOT NULL
);