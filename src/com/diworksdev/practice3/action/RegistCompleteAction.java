package com.diworksdev.practice3.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice3.dao.RegistCompleteDAO;
import com.diworksdev.practice3.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

//ユーザー登録機能

//Actionクラスでは、画面から送られてきたリクエストを取得する
//内部処理に応じてDAOやDTOクラスを呼び出し、最終的に次のJSPへ値を返すファイル

//struts2が持つActionSupportというクラスを継承
//（Actionクラスは基本的にこのクラスを継承）
//LoginAciton（子クラス） extends（継承） ActionSupport（親クラス）
//すでにあるクラスとにたクラスを作る場合、元のクラスに必要な機能だけを追加する形で、新しいクラスを作ることを継承
//実際の処理を持たない、ちょっと変わったクラス=implements
//interfaceを使って型宣言を行うことができますが、メソッドの定義がないとプログラムは実行できないので、そこで使うのがimplements
/*Actionクラスにて、implements SessionAware を宣言（ActionSupport.SessionAware=インターフェース）
実装メソッドである setSession(Map session)にて、ActionのフィールドへHttpSessionのオブジェクトを格納する処理を実装する。this.session = session; でほぼ十分。
上記の手順で実装したフィールドを用意する
これにより、このActionクラスのsessionフィールドへ、Struts2が自動的にHttpSessionの内容をMapの型で格納します。*/

//public class RegistCompleteAction extends ActionSupport implements SessionAware {

public class RegistCompleteAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;

	// フィールド変数
	// JSPから受け取る値
	// ※必ずJSPでの定義と同じ名前にする
	private String userFamilyName;
	private String userLastName;
	private String userFamilyNameKana;
	private String userLastNameKana;
	private String userMail;
	private String userPassword;
	private String userGender;
	private String userPostalCode;
	private String userPrefecture;
	private String userAddress1;
	private String userAddress2;
	private String userAuthority;
	private String delete_flag;
	// private String delete_flag0;// 文字列表示用プロパティ
	private String errorMessage;

	// Map<String, Object>=キーを値にマッピングするオブジェクト。
	// マップには、同一のキーを複数登録できない。各キーは1つの値にしかマッピングできません。
	// このインタフェースは、インタフェースというよりむしろ完全に抽象クラスであったDictionaryクラスに代わるものです
	// 全てのクラス 変数 変数名
	public Map<String, Object> session;

	// ②DTOとDAOのインスタンス化（コピーして値を代入）
	private RegistCompleteDAO registCompleteDAO = new RegistCompleteDAO();

	// 全てのクラス 変数 変数名(struts) throws=例外を意図的に起こすことが出来る処理のこと。
	@Override
	public String execute() throws SQLException {
		String result = ERROR; // 初期値をERRORに設定

		try {
			String hashedPassword = hashPassword(session.get("userPassword").toString());
			// DBConnectorを使って接続試行
			DBConnector dbConnector = new DBConnector();
			Connection con = dbConnector.getConnection();

			if (con == null) {
				// 接続失敗の場合はエラーを返す
				// addActionError("エラーが発生したためアカウント登録できません。");
				errorMessage = "エラーが発生したためアカウント登録できません。";

				result = ERROR;

			} else {

				// error画面表示させてもサーバー上で１の表示にならない

				// String result = SUCCESS;

				// System.out.println(session.get("userFamilyName"));
				// System.out.println(session.get("userLastName"));
				// System.out.println(session.get("userFamilyNameKana"));
				// System.out.println(session.get("userLastNameKana"));
				// System.out.println(session.get("userMail"));
				// System.out.println(session.get("userPassword"));
				// System.out.println(session.get("userGender"));
				// System.out.println(session.get("userPostalCode"));
				// System.out.println(session.get("userPrefecture"));
				// System.out.println(session.get("userAddress1"));
				// System.out.println(session.get("userAddress2"));
				// System.out.println(session.get("userAuthority"));
				// System.out.println(session.get("delete_flag"));
				// String userFamilyName =
				// session.get("userFamilyName").toString();
				// String userLastName = session.get("userLastName").toString();
				// String userFamilyNameKana =
				// session.get("userFamilyNameKana").toString();
				// String userLastNameKana =
				// session.get("userLastNameKana").toString();
				// String userMail = session.get("userMail").toString();
				// String userPassword = session.get("userPassword").toString();
				// String userGender = session.get("userGender").toString();
				// String userPostalCode =
				// session.get("userPostalCode").toString();
				// String userPrefecture =
				// session.get("userPrefecture").toString();
				// String userAddress1 = session.get("userAddress1").toString();
				// String userAddress2 = session.get("userAddress2").toString();
				// String userAuthority =
				// session.get("userAuthority").toString();
				// String delete_flag = session.get("delete_flag").toString();
/*
				System.out.println(session.get("userFamilyName"));
				System.out.println(session.get("userLastName"));
				System.out.println(session.get("userFamilyNameKana"));
				System.out.println(session.get("userLastNameKana"));
				System.out.println(session.get("userMail"));
				System.out.println(session.get("userPassword"));
				System.out.println(session.get("userGender"));
				System.out.println(session.get("userPostalCode"));
				System.out.println(session.get("userPrefecture"));
				System.out.println(session.get("userAddress1"));
				System.out.println(session.get("userAddress2"));
				System.out.println(session.get("userAuthority"));
				System.out.println(session.get("delete_flag"));
				System.out.println(session.get("userFamilyName").toString());
				System.out.println(session.get("userLastName").toString());
				System.out.println(session.get("userFamilyNameKana").toString());
				System.out.println(session.get("userLastNameKana").toString());
				System.out.println(session.get("userMail").toString());
				System.out.println(session.get("userPassword").toString());
				System.out.println(session.get("userGender").toString());
				System.out.println(session.get("userPostalCode").toString());
				System.out.println(session.get("userPrefecture").toString());
				System.out.println(session.get("userAddress1").toString());
				System.out.println(session.get("userAddress2").toString());
				System.out.println(session.get("userAuthority").toString());
				System.out.println(session.get("delete_flag").toString());
				// 小川講師に追記してもらったとこ！１項目ずつデータが渡っているかチェックする！
				 *
				 */
				registCompleteDAO.regist(session.get("userFamilyName").toString(),
						session.get("userLastName").toString(), session.get("userFamilyNameKana").toString(),
						session.get("userLastNameKana").toString(), session.get("userMail").toString(), hashedPassword,
						session.get("userGender").toString(), session.get("userPostalCode").toString(),
						session.get("userPrefecture").toString(), session.get("userAddress1").toString(),
						session.get("userAddress2").toString(), session.get("userAuthority").toString(),
						session.get("delete_flag").toString());
				// session.get("delete_flag").toString()
				// session.get("userPostalCode").toString(),
				// SUCCESS返す
				// これコメントアウトして実行するとregistError.jsp画面に遷移する
				// result = SUCCESS;
				// registCompleteDAO.regist(session.get("userFamilyName").toString(),
				// session.get("userLastName").toString(),
				// session.get("userFamilyNameKana").toString(),
				// session.get("userLastNameKana").toString(),
				// session.get("userMail").toString(),
				// session.get("userPassword").toString(),
				// session.get("userGender").toString(),
				// session.get("userPostalCode").toString(),
				// session.get("userPrefecture").toString(),
				// session.get("userAddress1").toString(),
				// session.get("userAddress2").toString(),
				// session.get("userAuthority").toString());
				// } else if (delete_flag0.equals("1")) {
				// result = ERROR;
				// }
				//
				// String result = SUCCESS;

				// } catch (SQLException e) {
				// // エラーメッセージをセッションに格納してエラー画面に遷移
				// addActionError("アカウント登録中にエラーが発生しました。もう一度お試しください。");
				// e.printStackTrace();
				//
				// String result = ERROR;

				// } catch (SQLException e) {

				// addActionError("アカウント登録中にエラーが発生しました。もう一度お試しください。");

				// e.printStackTrace();

				// }

				result = SUCCESS;

			}

		} catch (SQLException e) {

			addActionError("アカウント登録中にエラーが発生しました。もう一度お試しください。");
			e.printStackTrace(); // エラー内容をログに出力

			// この下記不要だった
			// result = ERROR;

		} catch (NoSuchAlgorithmException e) {
			addActionError("セキュリティエラーが発生しました。");
			e.printStackTrace();

		}

		return result;

	}

	/**
	 * パスワードをSHA-256でハッシュ化するメソッド
	 *
	 * @param password
	 *            平文のパスワード
	 * @return ハッシュ化された文字列
	 * @throws NoSuchAlgorithmException
	 */
	private String hashPassword(String userPassword) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hashedBytes = md.digest(userPassword.getBytes());
		// ハッシュ値を16進数文字列に変換
		StringBuilder sb = new StringBuilder();
		for (byte b : hashedBytes) {
			sb.append(String.format("%02x", b));

		}

		return sb.toString();

	}

	//// String result = SUCCESS;
	//
	// // 戻り値
	// // retに入った値を呼び出し元であるActionクラスに渡す

	// フィールド変数に対応したgetterとsetterを定義
	// userCreateconfirm.jspの値として受け取った、userFamilyNameフィールドの値をregistComplete.jspに渡している
	public String getUserFamilyName() {
		return userFamilyName;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserFamilyNameフィールドに格納
	public void setUserFamilyName(String userFamilyName) {
		this.userFamilyName = userFamilyName;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreateconfirm.jspの値として受け取った、userLastNameフィールドの値をregistComplete.jspに渡している
	public String getUserLastName() {
		return userLastName;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserLastNameフィールドに格納
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreateconfirm.jspの値として受け取った、userFamilyNameKanaフィールドの値をregistComplete.jspに渡している
	public String getUserFamilyNameKana() {
		return userFamilyNameKana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserFamilyNameKanaフィールドに格納
	public void setUserFamilyNameKana(String userFamilyNameKana) {
		this.userFamilyNameKana = userFamilyNameKana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreateconfirm.jspの値として受け取った、userLastNameKanaフィールドの値をregistComplete.jspに渡している
	public String getUserLastNameKana() {
		return userLastNameKana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserLastNameKanaフィールドに格納
	public void setUserLastNameKana(String userLastNameKana) {
		this.userLastNameKana = userLastNameKana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreateconfirm.jspの値として受け取った、userMailフィールドの値をregistComplete.jspに渡している
	public String getUserMail() {
		return userMail;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserMailフィールドに格納
	public void setUserMail(String userMail) {
		this.userMail = userMail;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreateconfirm.jspの値として受け取った、userPasswordフィールドの値をregistComplete.jspに渡している
	public String getUserPassword() {
		return userPassword;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserPasswordフィールドに格納
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreateconfirm.jspの値として受け取った、userGenderフィールドの値をregistComplete.jspに渡している
	public String getUserGender() {
		return userGender;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserGenderフィールドに格納
	public void setUserGender(String userGender) {
		this.userGender = userGender;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreateconfirm.jspの値として受け取った、userPostalCodeフィールドの値をregistComplete.jspに渡している
	public String getUserPostalCode() {
		return userPostalCode;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserPostalCodeフィールドに格納
	public void setUserPostalCode(String userPostalCode) {
		this.userPostalCode = userPostalCode;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreateconfirm.jspの値として受け取った、userPrefectureフィールドの値をregistComplete.jspに渡している
	public String getUserPrefecture() {
		return userPrefecture;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserPrefectureフィールドに格納
	public void setUserPrefecture(String userPrefecture) {
		this.userPrefecture = userPrefecture;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreateconfirm.jspの値として受け取った、userAddress1フィールドの値をregistComplete.jspに渡している
	public String getUserAddress1() {
		return userAddress1;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserAddress1フィールドに格納
	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreateconfirm.jspの値として受け取った、userAddress2フィールドの値をregistComplete.jspに渡している
	public String getUserAddress2() {
		return userAddress2;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserAddress2フィールドに格納
	public void setUserAddress2(String userAddress2) {
		this.userAddress2 = userAddress2;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreateconfirm.jspの値として受け取った、userAuthorityフィールドの値をregistComplete.jspに渡している
	public String getUserAuthority() {
		return userAuthority;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserAuthorityフィールドに格納
	public void setUserAuthority(String userAuthority) {
		this.userAuthority = userAuthority;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreateconfirm.jspの値として受け取った、userAuthorityフィールドの値をregistComplete.jspに渡している
	public String getDelete_flag() {
		return delete_flag;

	}

	// 外部のSETをここに代入して元々の値を外部から持ってきた値に変えて格納する
	// フィールド変数に対応したgetterとsetterを定義
	// 受け取ったテーブルの値を自身のdeleteFlgフィールドに格納
	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreateconfirm.jspの値として受け取った、userAuthorityフィールドの値をregistComplete.jspに渡している
	public String getErrorMessage() {
		return errorMessage;

	}

	// 外部のSETをここEに代入して元々の値を外部から持ってきた値に変えて格納する
	// フィールド変数に対応したgetterとsetterを定義
	// 受け取ったテーブルの値を自身のdeleteFlgフィールドに格納
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のsessionフィールドに代入して格納
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public RegistCompleteDAO getRegistCompleteDAO() {
		return registCompleteDAO;
	}

	public void setRegistCompleteDAO(RegistCompleteDAO registCompleteDAO) {
		this.registCompleteDAO = registCompleteDAO;
	}

}
