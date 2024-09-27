package com.diworksdev.practice3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.practice3.util.DBConnector;
import com.diworksdev.practice3.util.DateUtil;

//DAOクラスでは、Actionから送られてきた情報を使ってDBへ問い合わせを行うファイル
//問い合わせて取得した値をDTOクラスに格納するファイル

public class RegistCompleteDAO {

	//DBConnectorのインスタンス化
	//DBへの接続準備、DBと会話するためのコード、これでログインできる
	//Connectionは特定のデータベースとの接続
	private DBConnector dbConnector = new DBConnector();

	//getConnectionの呼び出し（DBと接続する）
	private Connection connection = dbConnector.getConnection();

	//このクラスのみ 変数 変数名 インスタンス化（コピーして代入）
	private DateUtil dateUtil = new DateUtil();

	//このクラスのみ 変数 変数名
	//sql文を書く：値は ? を入れておく（どんな値でも使いまわしできるようにするため
	/*データベースのテーブル上にデータを登録する際に使用されるステートメントの構文=INSERT INTO
 	*1 つ以上の行のセットをテーブルとして返す＝VALUES=中身のこと
 	*作成したテーブルに情報を格納する*/
//	private String sql = "INSERT INTO login_user_transaction("
//			+ "family_name, last_name, family_name_kana, last_name_kana, mail, password, "
//			+ "gender, postal_code, prefecture, address_1, address_2, authority, registered_time) "
//			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	//①小川講師から教えてもらったこと、下記みたいに１個ずつ試してみる！上記の完成形はコメントアウト！
	private String sql = "INSERT INTO login_user_transaction(family_name, last_name, family_name_kana, last_name_kana, mail, password, gender, postal_code) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

	//DBから購入履歴を取得するためのメソッド
	//クラス、メソッドの定義
	//DTO型を最後に呼び出し元に渡すので、DTO型を戻り値にしたメソッドを作る
	//Actionクラスの値を引数として受け取る,throws=例外を意図的に起こすことが出来る処理のこと。
	//②小川講師から教えてもらったとこ！追加してもらった、一個ずつ確認するため、確認したくない項目は⇨””にする
	public void regist(String userFamilyName, String userLastName, String userFamilyNameKana,
			String userLastNameKana, String userMail, String userPassword, String userGender, String userPostalCode) throws SQLException {
		regist(userFamilyName, userLastName, userFamilyNameKana, userLastNameKana, userMail, userPassword, userGender, userPostalCode, "", "", "", "");
	}

	//これ元々記述してたやつ、上は小川講師に追加してもらったやつ！
	public void regist(String userFamilyName, String userLastName, String userFamilyNameKana,
			String userLastNameKana, String userMail, String userPassword,
			String userGender, String userPostalCode, String userPrefecture,
			String userAddress1, String userAddress2, String userAuthority) throws SQLException {

		//③小川講師から教えてもらったこと、上記の確認したい項目を入力！
		System.out.println(userFamilyName);
		System.out.println(userLastName);
		System.out.println(userFamilyNameKana);
		System.out.println(userLastNameKana);
		System.out.println(userMail);
		System.out.println(userPassword);
		System.out.println(userGender);
		System.out.println(userPostalCode);
		System.out.println(userAuthority);

		//try.catchはjavaの例外処理のための構文
		try {

			//tryの中にはエラーが発生しそうな処理を書く
			//PreparedStatement（DBまで運んでくれる箱のイメージ）に代入
			//定義したSQL文の1番目の?にActionから送られたname、
			//2番目の?にActionから送られたpasswordがそれぞれ入る
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			//④小川講師から教えてもらったこと、確認したい項目だけに絞る、それ以外コメントアウト！
			//④までやったら実行確認してphpMyAdminに値が入っているか確認する！必ずコミットプッシュする
			//インサートしている値とデータベースのカラムの型が違う可能性あり！
			//sql文の?に入れる値をsetする
			preparedStatement.setString(1, userFamilyName);
			preparedStatement.setString(2, userLastName);
			preparedStatement.setString(3, userFamilyNameKana);
			preparedStatement.setString(4, userLastNameKana);
			preparedStatement.setString(5, userMail);
			preparedStatement.setString(6, userPassword);
			preparedStatement.setString(7, userGender);
			preparedStatement.setString(8, userPostalCode);
//			preparedStatement.setString(9, userPrefecture);
//			preparedStatement.setString(10, userAddress1);
//			preparedStatement.setString(11, userAddress2);
//			preparedStatement.setString(12, userAuthority);
//			preparedStatement.setString(13, dateUtil.getDate());
			preparedStatement.execute();

		//処理中にSQL関連のエラーが発生した際に実行する処理
		//tryの中でエラーが発生した場合、catchが受け取り
		//例外がスローされる原因となったエラーまたは動作の説明を返す
		} catch (Exception e) {
			e.printStackTrace();

		//DB接続を終了する際、必ず書くメソッド
		//最後に実行されるものを指定するための構文
		//例外が発生しcatchされてもされなくても、共通してやってほしい処理や、やらなければいけない処理を書くところ。
		} finally {

			//⑨con.close()で接続を切る
			//データベースとの接続をクローズ
			//これをしないとデータベースを接続したまま作業が実行されてしまってメモリに負荷がかかる
			connection.close();

		}

	}

}
