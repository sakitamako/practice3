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

}
