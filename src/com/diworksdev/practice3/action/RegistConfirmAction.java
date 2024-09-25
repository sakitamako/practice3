package com.diworksdev.practice3.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

//ユーザー登録機能

//Actionクラスでは、画面から送られてきたリクエストを取得する
//内部処理に応じてDAOやDTOクラスを呼び出し、最終的に次のJSPへ値を返すファイル

//struts2が持つActionSupportというクラスを継承
//（Actionクラスは基本的にこのクラスを継承）
//UserCreateConfirmAction（子クラス） extends（継承） ActionSupport（親クラス）
//すでにあるクラスとにたクラスを作る場合、元のクラスに必要な機能だけを追加する形で、新しいクラスを作ることを継承
//実際の処理を持たない、ちょっと変わったクラス=implements
//interfaceを使って型宣言を行うことができますが、メソッドの定義がないとプログラムは実行できないので、そこで使うのがimplements
/*Actionクラスにて、implements SessionAware を宣言（ActionSupport.SessionAware=インターフェース）
実装メソッドである setSession(Map session)にて、ActionのフィールドへHttpSessionのオブジェクトを格納する処理を実装する。this.session = session; でほぼ十分。
上記の手順で実装したフィールドを用意する
これにより、このActionクラスのsessionフィールドへ、Struts2が自動的にHttpSessionの内容をMapの型で格納します。*/
public class RegistConfirmAction extends ActionSupport implements SessionAware {

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

	// Map<String, Object>=キーを値にマッピングするオブジェクト。
	// マップには、同一のキーを複数登録できない。各キーは1つの値にしかマッピングできません。
	// このインタフェースは、インタフェースというよりむしろ完全に抽象クラスであったDictionaryクラスに代わるものです
	// 全てのクラス 変数 変数名
	public Map<String, Object> session;

	// このクラスのみ 変数 変数名
	private String errorMessage;

	// 新規ユーザー登録はボタンを押したらサクセスが返される、registConfirm.jsp画面に遷移する
	// struts.xmlで指定しているから！
	public String execute() {

		String result = SUCCESS;

		System.out.println(userFamilyName);
		System.out.println(userGender);
		System.out.println(userAuthority);
		System.out.println(userLastName);
		System.out.println(userFamilyNameKana);
		System.out.println(userLastNameKana);
		System.out.println(userMail);
		System.out.println(userPassword);
		// System.out.println(userGender);
		// System.out.println(userAuthority);
		// int型などのプリミティブ型で２つの値が等しいか比較する場合は”==”演算子で比較しますがString型などの参照型の場合はequalsメソッドで比較する
		// userFamilyNameと空文字・何も入ってない時の値が等しい場合、かつ、userLastNameと空文字・何も入ってない時の値が等しい場合、かつ、userFamilyNameKanaと空文字・何も入ってない時の値が等しい場合はelse文に行く！
		// ! aとbとcがtrueの場合処理は実行しない
		// && aとbとcが共にtrueの時に処理を実行する
		// 同じ意味 if (loginUserId.equals("") == false && loginPassword.equals("")
		// == false && userName.equals("") == false) {
		if (!(userFamilyName.equals("")) && !(userLastName.equals("")) && !(userFamilyNameKana.equals(""))
				&& !(userLastNameKana.equals("")) && !(userMail.equals("")) && !(userPassword.equals(""))
				&& !(userPostalCode.equals("")) && !(userPrefecture.equals("")) && !(userAddress1.equals(""))
				&& !(userAddress2.equals(""))) {
			//
			// //sessionのなかに記憶する保存する
			System.out.println(userFamilyName);
			session.put("userFamilyName", userFamilyName);
			session.put("userLastName", userLastName);
			session.put("userFamilyNameKana", userFamilyNameKana);
			session.put("userLastNameKana", userLastNameKana);
			session.put("userMail", userMail);
			session.put("userPassword", userPassword);
//			session.put("userGender", userGender); //原因？一旦外してみる
			session.put("userPostalCode", userPostalCode);// 原因？
			session.put("userPrefecture", userPrefecture);
			session.put("userAddress1", userAddress1);
			session.put("userAddress2", userAddress2);
//			session.put("userAuthority", userAuthority); //原因？一旦外してみる

		} else {

			setErrorMessage("未入力の項目があります。");

			result = ERROR;

		}

		if (userGender.equals("0")) {
			//
			// //男性代入
			userGender = "男性";
			//
			// //sessionに記憶
			session.put("userGender", userGender);
			//
			// //そうでない場合
		} else if (userGender.equals("1")) {
			//
			// //女性代入
			userGender = "女性";
			//
			// //sessionに記憶
			session.put("userGender", userGender);

		} else {

			result = ERROR;

		}

		// int型などのプリミティブ型で２つの値が等しいか比較する場合は”==”演算子で比較しますがString型などの参照型の場合はequalsメソッドで比較する
		// //もしuserAuthorityが0と等しい場合
		if (userAuthority.equals("0")) {
			//
			// //一般代入
			userAuthority = "一般";
			//
			// //sessionに記憶
			session.put("userAuthority", userAuthority);
			//
			// //そうでない場合
		} else if (userAuthority.equals("1")) {
			//
			// //管理者代入
			userAuthority = "管理者";
			//
			// //sessionに記憶
			session.put("userAuthority", userAuthority);
			//
			// //int型などのプリミティブ型で２つの値が等しいか比較する場合は”==”演算子で比較しますがString型などの参照型の場合はequalsメソッドで比較する
			//
		} else {

			result = ERROR;
		}
		//
		// //上記追加したやつ
		//
		// //戻り値
		// //retに入った値を呼び出し元であるActionクラスに渡す
		return result;

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
	public String getUserGender() {
		return userGender;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginUserIdフィールドに格納
	public void setUserGender(String userGender) {
		this.userGender = userGender;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// Actionクラスから呼び出され、loginPasswordフィールドの値をActionに渡す
	public String getUserPostalCode() {
		return userPostalCode;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginPasswordフィールドに格納
	public void setUserPostalCode(String userPostalCode) {
		this.userPostalCode = userPostalCode;

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
	public String getUserAuthority() {
		return userAuthority;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserNameフィールドに格納
	public void setUserAuthority(String userAuthority) {
		this.userAuthority = userAuthority;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のsessionフィールドに格納
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// Actionクラスから呼び出され、errorMessageフィールドの値をActionに渡す
	public String getErrorMessage() {
		return errorMessage;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のerrorMessageフィールドに格納
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;

	}

}