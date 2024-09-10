package com.diworksdev.practice3.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice3.dao.RegistCompleteDAO;
import com.diworksdev.practice3.dto.RegistDTO;
import com.opensymphony.xwork2.ActionSupport;

//ユーザー登録機能

//Actionクラスでは、画面から送られてきたリクエストを取得する
//内部処理に応じてDAOやDTOクラスを呼び出し、最終的に次のJSPへ値を返すファイル
//struts2が持つActionSupportというクラスを継承
//（Actionクラスは基本的にこのクラスを継承）
//LoginAciton（子クラス） extends（継承） ActionSupport（親クラス）
public class RegistCompleteAction extends ActionSupport implements SessionAware {

	//Map<String, Object>=キーを値にマッピングするオブジェクト。
	//マップには、同一のキーを複数登録できない。各キーは1つの値にしかマッピングできません。
    //このインタフェースは、インタフェースというよりむしろ完全に抽象クラスであったDictionaryクラスに代わるものです
	//全てのクラス 変数 変数名
	public Map<String, Object> session;

	//②DTOとDAOのインスタンス化（コピーして値を代入）
	private RegistCompleteDAO RegistCompleteDAO = new RegistCompleteDAO();

	//Listインタフェースのサイズ変更可能な配列の実装です。
	//リストのオプションの操作をすべて実装し、nullを含むすべての要素を許容します。
	//このクラスは、Listインタフェースを実装するほか、リストを格納するために内部的に使われる配列のサイズを操作するメソッドを提供します
	//ArrayList とは、 Listインタフェース を実装した コレクションクラス である。
	//ArrayList は、 Array という名にあるように配列のような感覚で扱うことができる。
	//配列 には格納できる 要素数が決まっている が、 ArrayList は 要素数は決まっていない 。
	//ArrayList は、 プリミティブ型（int, booleanなど） を入れられない。
	private RegistDTO RegistDTO = new RegistDTO();

	//フィールド変数
	//JSPから受け取る値
	//※必ずJSPでの定義と同じ名前にする
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


	//全てのクラス 変数 変数名(struts) throws=例外を意図的に起こすことが出来る処理のこと。
	public String execute() throws SQLException {

		RegistDTO = RegistCompleteDAO.getRegist(userFamilyName, userLastName, userFamilyNameKana,
				userLastNameKana, userMail, userPassword, userGender, userPostalCode, userPrefecture,
				userAddress1, userAddress2, userAuthority);

		//JSPから送られてきた情報を引数として、
		//LoginDAOクラスのgetLoginUserInfoメソッドを呼び出す
		//その後、DAOで取得した結果をLoginDTOに代入する
//		 RegistCompleteDAO.getRegist(userFamilyName, userLastName, userFamilyNameKana,
//				userLastNameKana, userMail, userPassword, userGender, userPostalCode, userPrefecture,
//				userAddress1, userAddress2, userAuthority);

		//Map を使った場合には、put()で要素を記憶できる
		session.put("regist", RegistDTO);

		//aとbが共にtrueの時に処理を実行するそうでない場合はエラー
//		if (this.userFamilyName.equals(RegistDTO.getUserFamilyName()) && this.userLastName.equals(RegistDTO.getUserLastName()) &&
//				this.userFamilyNameKana.equals(RegistDTO.getUserFamilyNameKana()) && this.userLastNameKana.equals(RegistDTO.getUserLastNameKana()) &&
//				this.userMail.equals(RegistDTO.getUserMail()) && this.userPassword.equals(RegistDTO.getUserPassword()) &&
//				this.userGender.equals(RegistDTO.getUserGender()) && this.userPostalCode.equals(RegistDTO.getUserPostalCode()) &&
//				this.userPrefecture.equals(RegistDTO.getUserPrefecture()) && this.userAddress1.equals(RegistDTO.getUserAddress1()) &&
//				this.userAddress2.equals(RegistDTO.getUserAddress2()) && this.userAuthority.equals(RegistDTO.getUserAuthority())) {

			//変数・文字列 result=SUCCESS
			//userCreateComplete.jspに遷移する
			String result = SUCCESS;

			return result;


		}

		//DAOを経由して入力された内容をDBに登録します。
		//DAOのcreateUserに記憶しているid,pass,nameを取得してテキストで表す文字列を返す
//		RegistCompleteDAO.getRegist(session.get("userFamilyName").toString(), session.get("userLastName").toString(), session.get("userFamilyNameKana").toString(),
//				session.get("userLastNameKana").toString(), session.get("userMail").toString(), session.get("userPassword").toString(),
//				session.get("userGender").toString(), session.get("userPostalCode").toString(), session.get("userPrefecture").toString(),
//				session.get("userAddress1").toString(), session.get("userAddress2").toString(), session.get("userAuthority").toString());



	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、loginUserIdフィールドの値をActionに渡す
	public String getUserFamilyName() {
		return userFamilyName;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginUserIdフィールドに格納
	public void setUserFamilyName(String userFamilyName) {
		this.userFamilyName = userFamilyName;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、loginPasswordフィールドの値をActionに渡す
	public String getUserLastName() {
		return userLastName;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginPasswordフィールドに格納
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、userNameフィールドの値をActionに渡す
	public String getUserFamilyNameKana() {
		return userFamilyNameKana;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserNameフィールドに格納
	public void setUserFamilyNameKana(String userFamilyNameKana) {
		this.userFamilyNameKana = userFamilyNameKana;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、loginUserIdフィールドの値をActionに渡す
	public String getUserLastNameKana() {
		return userLastNameKana;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginUserIdフィールドに格納
	public void setUserLastNameKana(String userLastNameKana) {
		this.userLastNameKana = userLastNameKana;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、loginPasswordフィールドの値をActionに渡す
	public String getUserMail() {
		return userMail;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginPasswordフィールドに格納
	public void setUserMail(String userMail) {
		this.userMail = userMail;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、userNameフィールドの値をActionに渡す
	public String getUserPassword() {
		return userPassword;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserNameフィールドに格納
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、loginUserIdフィールドの値をActionに渡す
	public String getUserGender() {
		return userGender;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginUserIdフィールドに格納
	public void setUserGender(String userGender) {
		this.userGender = userGender;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、loginPasswordフィールドの値をActionに渡す
	public String getUserPostalCode() {
		return userPostalCode;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginPasswordフィールドに格納
	public void setUserPostalCode(String userPostalCode) {
		this.userPostalCode = userPostalCode;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、userNameフィールドの値をActionに渡す
	public String getUserPrefecture() {
		return userPrefecture;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserNameフィールドに格納
	public void setUserPrefecture(String userPrefecture) {
		this.userPrefecture = userPrefecture;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、loginUserIdフィールドの値をActionに渡す
	public String getUserAddress1() {
		return userAddress1;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginUserIdフィールドに格納
	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、loginPasswordフィールドの値をActionに渡す
	public String getUserAddress2() {
		return userAddress2;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のloginPasswordフィールドに格納
	public void setUserAddress2(String userAddress2) {
		this.userAddress2 = userAddress2;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//Actionクラスから呼び出され、userNameフィールドの値をActionに渡す
	public String getUserAuthority() {
		return userAuthority;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserNameフィールドに格納
	public void setUserAuthority(String userAuthority) {
		this.userAuthority = userAuthority;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//全てのクラスのsetの値を自身のsessionフィールドに代入して格納
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
