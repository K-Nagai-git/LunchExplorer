--テーブルが存在したら削除する
DROP TABLE IF EXISTS users;

--テーブル作成
--ユーザーテーブル
CREATE TABLE users(
	user_mail_id VARCHAR PRIMARY KEY,
	user_nickname VARCHAR NOT NULL,
	user_password VARCHAR NOT NULL
);
--店舗テーブル

--詳細テーブル