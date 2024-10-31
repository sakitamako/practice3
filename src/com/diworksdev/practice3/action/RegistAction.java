package com.diworksdev.practice3.action;

import com.opensymphony.xwork2.ActionSupport;

//ユーザー登録機能

//Actionクラスでは、画面から送られてきたリクエストを取得する
//内部処理に応じてDAOやDTOクラスを呼び出し、最終的に次のJSPへ値を返すファイル
//struts2が持つActionSupportというクラスを継承
//（Actionクラスは基本的にこのクラスを継承）
//LoginAciton（子クラス） extends（継承） ActionSupport（親クラス）
public class RegistAction extends ActionSupport {

	private String userFamilyName;
	private String userLastName;
	private String userFamilyNameKana;
	private String userLastNameKana;
	private String userMail;
	private String userPassword;
//	private String maskedPassword;
	// private String userGender;
	private int userGender;
	private String userGender0;// 文字列表示用プロパティ
	private String userPostalCode;
	//private String userPostalCode;// 文字列表示用プロパティ
	private String userPrefecture;
	private String userAddress1;
	private String userAddress2;
	private String userAuthority0;// 文字列表示用プロパティ
	private int userAuthority;

	//新規ユーザー登録はボタンを押したらサクセスが返される、userCreate.jsp画面に遷移する
	//struts.xmlで指定しているから！
	public String execute() {

		return SUCCESS;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// Actionクラスから呼び出され、loginUserIdフィールドの値をActionに渡す
	public String getUserFamilyName() {
		return userFamilyName;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginUserIdフィールドに格納
	public void setUserFamilyName(String userFamilyName) {
		this.userFamilyName = userFamilyName;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// Actionクラスから呼び出され、loginPasswordフィールドの値をActionに渡す
	public String getUserLastName() {
		return userLastName;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginPasswordフィールドに格納
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// Actionクラスから呼び出され、userNameフィールドの値をActionに渡す
	public String getUserFamilyNameKana() {
		return userFamilyNameKana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserNameフィールドに格納
	public void setUserFamilyNameKana(String userFamilyNameKana) {
		this.userFamilyNameKana = userFamilyNameKana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// Actionクラスから呼び出され、loginUserIdフィールドの値をActionに渡す
	public String getUserLastNameKana() {
		return userLastNameKana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginUserIdフィールドに格納
	public void setUserLastNameKana(String userLastNameKana) {
		this.userLastNameKana = userLastNameKana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// Actionクラスから呼び出され、loginPasswordフィールドの値をActionに渡す
	public String getUserMail() {
		return userMail;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginPasswordフィールドに格納
	public void setUserMail(String userMail) {
		this.userMail = userMail;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// Actionクラスから呼び出され、userNameフィールドの値をActionに渡す
	public String getUserPassword() {
		return userPassword;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserNameフィールドに格納
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// Actionクラスから呼び出され、loginUserIdフィールドの値をActionに渡す
	public int getUserGender() {
		return userGender;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginUserIdフィールドに格納
	public void setUserGender(int userGender) {
		this.userGender = userGender;

	}

	// userGender0、intバージョンのフィールド変数のgetset追加
	public String getUserGender0() {
		return userGender0;

	}

	public void setUserGender0(String userGender0) {
		this.userGender0 = userGender0;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// Actionクラスから呼び出され、loginPasswordフィールドの値をActionに渡す
	public String getUserPostalCode() {
		return userPostalCode;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginPasswordフィールドに格納
	public void setUserPostalCode(String userPostalCode) {
		System.out.println("start: setUserPostalCode()");
		System.out.println(userPostalCode);
		this.userPostalCode = userPostalCode;
		System.out.println("end: setUserPostalCode()");

	}

	// フィールド変数に対応したgetterとsetterを定義
	// Actionクラスから呼び出され、userNameフィールドの値をActionに渡す
	public String getUserPrefecture() {
		return userPrefecture;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserNameフィールドに格納
	public void setUserPrefecture(String userPrefecture) {
		this.userPrefecture = userPrefecture;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// Actionクラスから呼び出され、loginUserIdフィールドの値をActionに渡す
	public String getUserAddress1() {
		return userAddress1;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginUserIdフィールドに格納
	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// Actionクラスから呼び出され、loginPasswordフィールドの値をActionに渡す
	public String getUserAddress2() {
		return userAddress2;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginPasswordフィールドに格納
	public void setUserAddress2(String userAddress2) {
		this.userAddress2 = userAddress2;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// Actionクラスから呼び出され、userNameフィールドの値をActionに渡す
	public String getUserAuthority0() {
		return userAuthority0;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserNameフィールドに格納
	public void setUserAuthority(int userAuthority) {
		this.userAuthority = userAuthority;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// Actionクラスから呼び出され、userNameフィールドの値をActionに渡す
	public int getUserAuthority() {
		return userAuthority;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserNameフィールドに格納
	public void setUserAuthority0(String userAuthority0) {
		this.userAuthority0 = userAuthority0;

	}


}
