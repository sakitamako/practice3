package com.diworksdev.practice3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.practice2.util.DBConnector;
import com.diworksdev.practice2.util.DateUtil;
//ユーザー登録機能

//DAOクラスでは、Actionから送られてきた情報を使ってDBへ問い合わせを行うファイル
//問い合わせて取得した値をDTOクラスに格納するファイル

public class RegistCompleteDAO {

	// このクラスのみ 変数 変数名
	// ④sql文を書く：値は ? を入れておく（どんな値でも使いまわしできるようにするため
	/*
	 * データベースのテーブル上にデータを登録する際に使用されるステートメントの構文=INSERT INTO 1
	 * つ以上の行のセットをテーブルとして返す＝VALUES=中身のこと 作成したテーブルに情報を格納する
	 */
	/*String sql = "SELECT family_name, last_name, family_name_kana, last_name_kana, mail, password, gender, "
			+ "postal_code, prefecture, address_1, address_2, authority FROM login_user_transaction "
			+ "DEFAULT NULL cregistered_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP "
			+ "update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,";*/

	// 全てのクラス 変数 変数名の中の引数を throws=例外を意図的に起こすことが出来る処理のこと。
	public static void regist(String userFamily_name, String userLast_name, String userFamily_name_kana, String userLast_name_kana,
			String userMail, String userPassword, String userPrefecture, String userAddress_1,
			String userAddress_2) throws SQLException {

		//String gender, String postal_code,
		//String authority

		DateUtil dateUtil = new DateUtil();

		String sql = "INSERT INTO login_user_transaction (family_name, last_name, family_name_kana, last_name_kana,"
				+ " mail, password, gender, postal_code, prefecture, address_1, address_2, authority, update_time) "
				+ "VALUES(?, ? , ?, ?, ?, ?, ?, ?, ?, ?)";

		// ②DBConnectorのインスタンス化
		// DBへの接続準備、DBと会話するためのコード、これでログインできる
		// Connectionは特定のデータベースとの接続
		DBConnector dbConnector = new DBConnector();

		// ③getConnectionの呼び出し（DBと接続する）
		Connection connection = dbConnector.getConnection();


		//このクラスのみ 変数 変数名 インスタンス化（コピーして代入）
		//DateUtil dateUtil = new DateUtil();

		// try.catchはjavaの例外処理のための構文
		try {

			// tryの中にはエラーが発生しそうな処理を書く
			// ⑤PreparedStatement（DBまで運んでくれる箱のイメージ）に代入
			// 定義したSQL文の1番目の?にActionから送られたname、
			// 2番目の?にActionから送られたpasswordがそれぞれ入る
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// ⑥sql文の?に入れる値をsetする
			// preparedStatement.setString(1, Id);
			preparedStatement.setString(1, userFamily_name);
			preparedStatement.setString(2, userLast_name);
			preparedStatement.setString(3, userFamily_name_kana);
			preparedStatement.setString(4, userLast_name_kana);
			preparedStatement.setString(5, userMail);
			preparedStatement.setString(6, userPassword);
			//preparedStatement.setString(7, gender);
			//preparedStatement.setString(8, postal_code);
			preparedStatement.setString(9, userPrefecture);
			preparedStatement.setString(10, userAddress_1);
			preparedStatement.setString(11, userAddress_2);
			//preparedStatement.setString(12, authority);
			preparedStatement.setString(13, dateUtil.getDateTime());
			preparedStatement.execute();

			// 処理中にSQL関連のエラーが発生した際に実行する処理
			// tryの中でエラーが発生した場合、catchが受け取り
			// 例外がスローされる原因となったエラーまたは動作の説明を返す
		} catch (Exception e) {
			e.printStackTrace();

			// DB接続を終了する際、必ず書くメソッド
			// 最後に実行されるものを指定するための構文
			// 例外が発生しcatchされてもされなくても、共通してやってほしい処理や、やらなければいけない処理を書くところ。
		} finally {

			// ⑨con.close()で接続を切る
			// データベースとの接続をクローズ
			// これをしないとデータベースを接続したまま作業が実行されてしまってメモリに負荷がかかる
			connection.close();

		}

	}

}
