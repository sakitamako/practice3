package com.diworksdev.practice3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	//MySQL接続に必要な情報を設定
	//JDBC ドライバー名
	private static String driverName = "com.mysql.jdbc.Driver";
	//データベース接続 URL
	private static String url = "jdbc:mysql://localhost/regist3?autoReconnect=true&useSSL=false";
	//データベース接続ユーザ名
	private static String user = "root";
	//データベース接続パスワード
	private static String password = "root";
	// 初期メッセージを設定
	private String errorMessage = "データベース接続で不明なエラーが発生しました"; // 初期メッセージを設定


	//全てのクラス 変数 変数名
	public Connection getConnection() {

		//接続オブジェクトの定義
		Connection con = null;

		//try.catchはjavaの例外処理のための構文
		try {

			//tryの中にはエラーが発生しそうな処理を書く
			Class.forName(driverName);

			//ドライバーがロードされ使えるような状態にしている、覚える。
			//接続情報から自分のパソコンにインストールされているMySQLへ接続する準備が整う
			con = DriverManager.getConnection(url, user, password);
			errorMessage = null;  // 接続成功した場合、エラーメッセージをクリア

		//tryの中でエラーが発生した場合、catchが受け取り
		//例外がスローされる原因となったエラーまたは動作の説明を返します
		} catch (ClassNotFoundException e) {
            // ドライバが見つからない場合のエラーメッセージ
			errorMessage = "JDBCドライバが見つかりません。";
            e.printStackTrace();

        } catch (SQLException e) {
            // 接続エラー時のオリジナルエラーメッセージ
        	errorMessage = "データベースに接続できませんでした。";
            e.printStackTrace();

        }

		// 接続成功時は Connection オブジェクト、失敗時は null を返す
        return con;
    }

	// エラーメッセージを取得するメソッド
    public String getErrorMessage() {
        return errorMessage;
    }
}


