/*package com.diworksdev.practice3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.diworksdev.practice3.dto.HomeDTO;
import com.diworksdev.practice3.util.DBConnector;

//ログイン認証機能
//DAOクラスでは、Actionから送られてきた情報を使ってDBへ問い合わせを行うファイル
//問い合わせて取得した値をDTOクラスに格納するファイル
public class HomeDAO {

		//②DBConnectorのインスタンス化
		//DBへの接続準備、DBと会話するためのコード、これでログインできる
		//Connectionは特定のデータベースとの接続
	private DBConnector dbConnector = new DBConnector();

		//③getConnectionの呼び出し（DBと接続する）
	private Connection connection = dbConnector.getConnection();

		//LoginDTOインスタンス化
		//DTOと会話するためのコード
	private HomeDTO HomeDTO = new HomeDTO();

/*
		//④sql文を書く：値は ? を入れておく（どんな値でも使いまわしできるようにするため）
		//SELECT データを抽出する
		//＊ テーブルに含まれる項目全て
		//FROM 〇〇 〇〇という名前のテーブルからデータを選択する
		//WHERE ＜条件＞抽出条件を指定
		//login_user_transactionに入っているデータid=? pass=?に入る条件を満たしたデータがsqlに代入される
		//user_name=?追加したら、、、？
		String sql = "SELECT * FROM login_user_transaction where family_name=? and last_name=? and family_name_kana=? and"
				+ " last_name_kana=? and mail=? and password=? and gender=? and postal_code=? and prefecture=? and"
				+ " address_1=? and address_2=? and authority=?";

		//try.catchはjavaの例外処理のための構文
//		try {

			//tryの中にはエラーが発生しそうな処理を書く
			//⑤PreparedStatement（DBまで運んでくれる箱のイメージ）に代入
			//定義したSQL文の1番目の?にActionから送られたname、
			//2番目の?にActionから送られたpasswordがそれぞれ入る
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			//⑥sql文の?に入れる値をsetする
			//セキュリティを考慮し、javaではPreparedStatementを利用

			//⑥sql文の?に入れる値をsetする
			preparedStatement.setString(1, userFamilyName);
			preparedStatement.setString(2, userLastName);
			preparedStatement.setString(3, userFamilyNameKana);
			preparedStatement.setString(4, userLastNameKana);
			preparedStatement.setString(5, userMail);
			preparedStatement.setString(6, userPassword);
			preparedStatement.setString(7, userGender);
			preparedStatement.setString(8, userPostalCode);
			preparedStatement.setString(9, userPrefecture);
			preparedStatement.setString(10, userAddress1);
			preparedStatement.setString(11, userAddress2);
			preparedStatement.setString(12, userAuthority);
			preparedStatement.setString(13, dateUtil.getDate());
			preparedStatement.execute();

			//⑦executeQuery()/executeUpdate()で実行
			//sql文の値をセットしたものがresultsetに入ってる
			ResultSet resultSet = preparedStatement.executeQuery();

			//下に1行ずらすこと
			//データが存在していれば戻り値を true で返す。存在しなければ falseで返す
			if (resultSet.next()) {

				HomeDTO.setUserFamilyName(resultSet.getString("family_name"));
				HomeDTO.setUserLastName(resultSet.getString("last_name"));
				HomeDTO.setUserFamilyNameKana(resultSet.getString("family_name_kana"));
				HomeDTO.setUserLastNameKana(resultSet.getString("last_name_kana"));
				HomeDTO.setUserMail(resultSet.getString("mail"));
				HomeDTO.setUserPassword(resultSet.getString("password"));
				HomeDTO.setUserGender(resultSet.getString("gender"));
				HomeDTO.setUserPostalCode(resultSet.getString("postal_code"));
				HomeDTO.setUserPrefecture(resultSet.getString("prefecture"));
				HomeDTO.setUserAddress1(resultSet.getString("address_1"));
				HomeDTO.setUserAddress2(resultSet.getString("address_2"));
				HomeDTO.setUserAuthority(resultSet.getString("authority"));

			}

		//処理中にSQL関連のエラーが発生した際に実行する処理
		//tryの中でエラーが発生した場合、catchが受け取り
		//例外がスローされる原因となったエラーまたは動作の説明を返す
		} catch (Exception e) {
			e.printStackTrace();

		}


		//dtoに入った値を呼び出し元であるアクションクラスに渡す
		return HomeDTO;
	}

}
*/


