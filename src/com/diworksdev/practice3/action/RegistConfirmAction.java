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
	// private String userGender;
	private int userGender;
	private String userGender0;// 文字列表示用プロパティ
	private int userPostalCode;
	private String userPostalCode0;// 文字列表示用プロパティ
	private String userPrefecture;
	private String userAddress1;
	private String userAddress2;
	private String userAuthority0;// 文字列表示用プロパティ
	private int userAuthority;

	// Map<String, Object>=キーを値にマッピングするオブジェクト。
	// マップには、同一のキーを複数登録できない。各キーは1つの値にしかマッピングできません。
	// このインタフェースは、インタフェースというよりむしろ完全に抽象クラスであったDictionaryクラスに代わるものです
	// 全てのクラス 変数 変数名
	public Map<String, Object> session;

	// このクラスのみ 変数 変数名
//	private String errorMessage;

	// エラーチェック（検証用）
	//入力値が正しい形式や範囲に合致しているかどうかを検証すること=validate()
    // バリデーション用のメソッド
    @Override
	public void validate() {

		System.out.println(userFamilyName);
		System.out.println(userFamilyName.equals(""));
		System.out.println(userFamilyName.trim().isEmpty());

		//isEmptyメソッドを利用することで、文字列が空であるかどうかを判定できる || userFamilyName.isEmpty()
		//userFamilyNameと空文字が等しいかつ,userFamilyNameの文字列が空の時
		if (userFamilyName == null || userFamilyName.isEmpty()) {
			addFieldError("userFamilyName", "名前（姓）が未入力です。");

        } else if (!(userFamilyName.matches("^[\\p{IsHan}\\p{IsHiragana}]+$"))){
            addFieldError("userFamilyName", "名前（姓）は平仮名と漢字のみ使用できます。");
        }

		if (userLastName == null || userLastName.isEmpty()) {
			addFieldError("userLastName", "名前（名）が未入力です。");

		} else if (!(userLastName.matches("^[\\p{IsHan}\\p{IsHiragana}]+$"))){
            addFieldError("userLastName", "名前（名）は平仮名と漢字のみ使用できます。");
        }

		if (userFamilyNameKana == null || userFamilyNameKana.isEmpty()) {
			addFieldError("userFamilyNameKana", "カナ（姓）が未入力です。");

		} else if (!(userFamilyNameKana.matches("^[\\p{IsKatakana}ー]+$"))){
            addFieldError("userFamilyNameKana", "カナ（姓）はカタカナのみ使用できます。");
        }

		if (userLastNameKana == null || userLastNameKana.isEmpty()) {
			addFieldError("userLastNameKana", "カナ（名）が未入力です。");

		} else if (!(userLastNameKana.matches("^[\\p{IsKatakana}ー]+$"))){
            addFieldError("userLastNameKana", "カナ（名）はカタカナのみ使用できます。");
        }

		if (userMail == null || userMail.isEmpty()) {
			addFieldError("userMail", "メールアドレスが未入力です。");

		} else if (!(userMail.matches("^[a-zA-Z0-9-@.]+$"))){
            addFieldError("userMail", "メールアドレスは半角英数字、半角ハイフン、半角記号（ハイフンとアットマークとドット）のみ使用できます。");
        }

		if (userPassword == null || userPassword.isEmpty()) {
			addFieldError("userPassword", "パスワードが未入力です。");

		} else if (!(userPassword.matches("^[a-zA-Z0-9]+$"))){
            addFieldError("userPassword", "パスワードは半角英数字のみ使用できます。");
        }

		if (userPostalCode0 == null || userPostalCode0.isEmpty()) {
			addFieldError("userPostalCode0", "郵便番号が未入力です。");

		} else if (!(userPostalCode0.matches("^[0-9]+$"))){
            addFieldError("userPostalCode0", "郵便番号は半角数字のみ使用できます。");
        }

		if (userPrefecture == null || userPrefecture.isEmpty()) {
			addFieldError("userPrefecture", "住所（都道府県）が未入力です。");

        }

		if (userAddress1 == null || userAddress1.isEmpty()) {
			addFieldError("userAddress1", "住所（市区町村）が未入力です。");

		} else if (!(userAddress1.matches("^[\\p{IsHiragana}\\p{IsHan}\\p{IsKatakana}0-9\\s-]+$"))){
            addFieldError("userAddress1", "住所（市区町村）はひらがな、漢字、カタカナ、半角数字、ハイフン、スペースのみ使用できます。");
        }

		if (userAddress2 == null || userAddress2.isEmpty()) {
			addFieldError("userAddress2", "住所（番地）が未入力です。");

		} else if (!(userAddress2.matches("^[\\p{IsHiragana}\\p{IsHan}\\p{IsKatakana}0-9\\s-]+$"))){
            addFieldError("userAddress2", "住所（番地）はひらがな、漢字、カタカナ、半角数字、ハイフン、スペースのみ使用できます。");
        }

	}

	// 新規ユーザー登録はボタンを押したらサクセスが返される、registConfirm.jsp画面に遷移する
	// struts.xmlで指定しているから！
	public String execute() throws Exception {

//		String result = SUCCESS;

		System.out.println(userFamilyName);
		System.out.println(userGender);
		System.out.println(userAuthority);
		System.out.println(userLastName);
		System.out.println(userFamilyNameKana);
		System.out.println(userLastNameKana);
		System.out.println(userMail);
		System.out.println(userPassword);
		System.out.println(userGender);
		System.out.println(userPostalCode);
		System.out.println(userPrefecture);
		System.out.println(userAddress1);
		System.out.println(userAddress2);
		System.out.println(userAuthority);
		// System.out.println(userAuthority);
		// int型などのプリミティブ型で２つの値が等しいか比較する場合は”==”演算子で比較しますがString型などの参照型の場合はequalsメソッドで比較する
		// userFamilyNameと空文字・何も入ってない時の値が等しい場合、かつ、userLastNameと空文字・何も入ってない時の値が等しい場合、かつ、userFamilyNameKanaと空文字・何も入ってない時の値が等しい場合はelse文に行く！
		// ! aとbとcがtrueの場合処理は実行しない
		// && aとbとcが共にtrueの時に処理を実行する
		// 同じ意味 if (loginUserId.equals("") == false && loginPassword.equals("")
		// == false && userName.equals("") == false) {
		if (!(userFamilyName.equals("")) && !(userLastName.equals("")) && !(userFamilyNameKana.equals(""))
				&& !(userLastNameKana.equals("")) && !(userMail.equals("")) && !(userPassword.equals(""))
				&& !(userPrefecture.equals("")) && !(userAddress1.equals("")) && !(userAddress2.equals(""))) {

			// !(userPostalCode.equals("")) && これも数値、intだったから一旦外す！

			// //sessionのなかに記憶する保存する
			System.out.println(userFamilyName);
			session.put("userFamilyName", userFamilyName);
			session.put("userLastName", userLastName);
			session.put("userFamilyNameKana", userFamilyNameKana);
			session.put("userLastNameKana", userLastNameKana);
			session.put("userMail", userMail);
			session.put("userPassword", userPassword);
			// session.put("userGender", userGender); //原因？一旦外してみる
			// session.put("userPostalCode", userPostalCode);// 原因？
			session.put("userPrefecture", userPrefecture);
			session.put("userAddress1", userAddress1);
			session.put("userAddress2", userAddress2);
			// session.put("userAuthority", userAuthority); //原因？一旦外してみる

//		} else {

//			setErrorMessage("未入力の項目があります。");

//			result = ERROR;

//			result = SUCCESS;

		}

		// 小川講師からintバージョンで作った場合の処理方法教えてもらった！
		// 下記は元々自分で作ってたコード！何が表示される想定なのかコメントアウトしている！
		userGender0 = Integer.toString(userGender);// 0or1

		session.put("userGender", userGender0);// 0or1

		if (userGender0.equals("0")) {
			//
			// //男性代入
			userGender0 = "男性";
			//
			// //sessionに記憶
			// session.put("userGender", userGender);//0->男性
			//
			// //そうでない場合
		} else if (userGender0.equals("1")) {
			//
			// //女性代入
			userGender0 = "女性";
			//
			// //sessionに記憶
			// session.put("userGender", userGender);//1->女性

			// } else {

			// result = ERROR;

		}

		userPostalCode0 = Integer.toString(userPostalCode);// 0or1
		//
		session.put("userPostalCode", userPostalCode0);// 0or1

		if (!(userPostalCode0.equals(""))) {

			session.put("userPostalCode", userPostalCode);

//		} else {

//			result = ERROR;

		}

		// int型などのプリミティブ型で２つの値が等しいか比較する場合は”==”演算子で比較しますがString型などの参照型の場合はequalsメソッドで比較する
		// //もしuserAuthorityが0と等しい場合
		// stringで処理してみる！

		userAuthority0 = Integer.toString(userAuthority);// 0or1
		session.put("userAuthority", userAuthority0);// 0or1

		if (userAuthority0.equals("0")) {// 0or1
			//
			// //一般代入
			userAuthority0 = "一般";
			//
			// //sessionに記憶
			// session.put("userAuthority", userAuthority);//一般
			//
			// //そうでない場合
		} else if (userAuthority0.equals("1")) {// 0or1
			//
			// //管理者代入
			userAuthority0 = "管理者";
			//
			// //sessionに記憶
			// session.put("userAuthority", userAuthority);//管理者
			//
			// //int型などのプリミティブ型で２つの値が等しいか比較する場合は”==”演算子で比較しますがString型などの参照型の場合はequalsメソッドで比較する
			//
			// } else {

			// result = ERROR;
		}


		String result = SUCCESS;

		//
		// //上記追加したやつ
		//
		// //戻り値
		// //retに入った値を呼び出し元であるActionクラスに渡す
		return result;

	}

    // 修正ボタンが押されたときに入力画面に戻る
    public String backToInput() {
        return INPUT; // 入力画面に戻る
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
	public String getUserPostalCode0() {
		return userPostalCode0;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginPasswordフィールドに格納
	public void setUserPostalCode0(String userPostalCode0) {
		this.userPostalCode0 = userPostalCode0;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// Actionクラスから呼び出され、loginPasswordフィールドの値をActionに渡す
	public int getUserPostalCode() {
		return userPostalCode;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginPasswordフィールドに格納
	public void setUserPostalCode(int userPostalCode) {
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

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のsessionフィールドに格納
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}
/*
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
*/
}