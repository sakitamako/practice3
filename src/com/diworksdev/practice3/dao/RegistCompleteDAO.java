package com.diworksdev.practice3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.sql.ResultSet;

//import com.diworksdev.practice3.dto.HomeDTO;
import com.diworksdev.practice3.util.DBConnector;
import com.diworksdev.practice3.util.DateUtil;

//DAOクラスでは、Actionから送られてきた情報を使ってDBへ問い合わせを行うファイル
//問い合わせて取得した値をDTOクラスに格納するファイル

public class RegistCompleteDAO {

	//②DBConnectorのインスタンス化
	//DBへの接続準備、DBと会話するためのコード、これでログインできる
	//Connectionは特定のデータベースとの接続
	private DBConnector dbConnector = new DBConnector();

	//③getConnectionの呼び出し（DBと接続する）
	private Connection connection = dbConnector.getConnection();

	//このクラスのみ 変数 変数名 インスタンス化（コピーして代入）
	private DateUtil dateUtil = new DateUtil();

	//このクラスのみ 変数 変数名
	//④sql文を書く：値は ? を入れておく（どんな値でも使いまわしできるようにするため
	/*データベースのテーブル上にデータを登録する際に使用されるステートメントの構文=INSERT INTO
 	*1 つ以上の行のセットをテーブルとして返す＝VALUES=中身のこと
 	*作成したテーブルに情報を格納する*/
	private String sql = "INSERT INTO login_user_transaction("
			+ "family_name, last_name, family_name_kana, last_name_kana, mail, password, "
			+ "gender, postal_code, prefecture, address_1, address_2, authority, registered_time) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	//DBから購入履歴を取得するためのメソッド
	//①クラス、メソッドの定義
	//DTO型を最後に呼び出し元に渡すので、DTO型を戻り値にしたメソッドを作る
	//Actionクラスの値を引数として受け取る,throws=例外を意図的に起こすことが出来る処理のこと。
	public void regist(String userFamilyName, String userLastName, String userFamilyNameKana,
			String userLastNameKana, String userMail, String userPassword,
			String userGender, String userPostalCode, String userPrefecture,
			String userAddress1, String userAddress2, String userAuthority) throws SQLException {

	//DBから購入履歴を取得するためのメソッド
	//①クラス、メソッドの定義
	//DTO型を最後に呼び出し元に渡すので、DTO型を戻り値にしたメソッドを作る
	//Actionクラスの値を引数として受け取る,throws=例外を意図的に起こすことが出来る処理のこと。
//	public ArrayList<HomeDTO> getRegist(String userFamilyName, String userLastName, String userFamilyNameKana,
//			String userLastNameKana, String userMail, String userPassword,
//			String userGender, String userPostalCode, String userPrefecture,
//			String userAddress1, String userAddress2, String userAuthority) throws SQLException {

		//DTOと会話するためのコード
//		ArrayList<HomeDTO> homeDTO = new ArrayList<HomeDTO>();


//		String sql = "INSERT INTO login_user_transaction VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		//try.catchはjavaの例外処理のための構文
		try {

			//tryの中にはエラーが発生しそうな処理を書く
			//⑤PreparedStatement（DBまで運んでくれる箱のイメージ）に代入
			//定義したSQL文の1番目の?にActionから送られたname、
			//2番目の?にActionから送られたpasswordがそれぞれ入る
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

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
//			ResultSet resultSet = preparedStatement.executeQuery();

			//下に1行ずらすこと
			//データが存在していれば戻り値を true で返す。存在しなければ falseで返す
//			while (resultSet.next()) {

				//DTOインスタンス化
				//DTOと会話するためのコード
//				HomeDTO HomeDTO = new HomeDTO();

				//もしresultsetに入っている値が存在していればDTOに格納する
//				HomeDTO.setUserFamilyName(resultSet.getString("family_name"));
//				HomeDTO.setUserLastName(resultSet.getString("last_name"));
//				HomeDTO.setUserFamilyNameKana(resultSet.getString("family_name_kana"));
//				HomeDTO.setUserLastNameKana(resultSet.getString("last_name_kana"));
//				HomeDTO.setUserMail(resultSet.getString("mail"));
//				HomeDTO.setUserPassword(resultSet.getString("password"));
//				HomeDTO.setUserGender(resultSet.getString("gender"));
//				HomeDTO.setUserPostalCode(resultSet.getString("postal_code"));
//				HomeDTO.setUserPrefecture(resultSet.getString("prefecture"));
//				HomeDTO.setUserAddress1(resultSet.getString("address_1"));
//				HomeDTO.setUserAddress2(resultSet.getString("address_2"));
//				HomeDTO.setUserAuthority(resultSet.getString("authority"));

				//dtoに記憶する
//				homeDTO.add(HomeDTO);

//			}


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

//		return homeDTO;

	}

}
