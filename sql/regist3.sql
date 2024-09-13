/*クライアントがSQLステートメントをサーバーに送信するために使用する文字セット*/
set names utf8;
/*MySQLで外部キー制約を適用しているテーブルにはDROP TABLEができない
 * 一時的に外部キー制約を無効にすることができる*/
set foreign_key_checks = 0;
/*DROP TABLE IF EXISTS でテーブルが存在すれば削除する*/
drop database if exists regist3;

create database regist3;
use regist3;

create table login_user_transaction(
id int(100) unique,
family_name varchar(100),
last_name varchar(100),
family_name_kana varchar(100),
last_name_kana varchar(100),
mail varchar(255),
password varchar(255),
gender int(1),
postal_code int(7),
prefecture varchar(100),
address_1 varchar(100),
address_2 varchar(255),
authority int(1),
delete_flag int(1),
registered_time datetime,
update_time datetime);

INSERT INTO login_user_transaction(
id, family_name, last_name, family_name_kana,
last_name_kana, mail, password, gender, postal_code,
prefecture, address_1, address_2, authority)
VALUES(1, "鈴木", "紗季", "スズキ", "サキ", "a@gmail.com",
"0910", 1, 0001111, "東京都", "新宿区", "1-1-1", 1);