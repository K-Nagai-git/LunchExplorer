--テーブルが存在したら削除する
DROP TABLE IF EXISTS detail;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS stores CASCADE;


--テーブル作成
-- ユーザーテーブル
CREATE TABLE users (
    user_mail       VARCHAR PRIMARY KEY,
    user_nickname   VARCHAR NOT NULL,
    user_password   VARCHAR NOT NULL
);

-- 店舗テーブル
CREATE TABLE stores (
    store_id        serial PRIMARY KEY,
    store_name      VARCHAR NOT NULL,
    store_tel       VARCHAR NOT NULL,
    store_address   VARCHAR,
    store_url       VARCHAR,
    user_mail       VARCHAR NOT NULL,
    CONSTRAINT fk_user_mail FOREIGN KEY (user_mail) REFERENCES users(user_mail)
);

-- 詳細テーブル
CREATE TABLE detail (
    detail_id           serial PRIMARY KEY,
    store_id            INTEGER NOT NULL,
    detail_postdt       DATE NOT NULL,
    user_mail           VARCHAR NOT NULL,
    detail_menu         VARCHAR NOT NULL,
    detail_price        INTEGER NOT NULL,
    detail_rating       VARCHAR NOT NULL,
    detail_review_flag  BOOLEAN DEFAULT 'true',
    detail_review       VARCHAR,
    detail_image        VARCHAR,
    detail_memo         VARCHAR,
    detail_usedt        DATE NOT NULL,
    detail_visits       INTEGER NOT NULL,
    -- 外部キー制約の追加
    CONSTRAINT fk_store_id FOREIGN KEY (store_id) REFERENCES stores(store_id),
    CONSTRAINT fk_detail_user_mail FOREIGN KEY (user_mail) REFERENCES users(user_mail)
);