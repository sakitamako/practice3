package com.diworksdev.practice3.action;

import java.sql.SQLException;
import java.util.Map;
//import java.util.ArrayList;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice3.dao.RegistCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;
//import com.diworksdev.practice3.dto.HomeDTO;

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
public class RegistCompleteAction extends ActionSupport implements SessionAware {

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
	// private String delete_flag;

	// Map<String, Object>=キーを値にマッピングするオブジェクト。
	// マップには、同一のキーを複数登録できない。各キーは1つの値にしかマッピングできません。
	// このインタフェースは、インタフェースというよりむしろ完全に抽象クラスであったDictionaryクラスに代わるものです
	// 全てのクラス 変数 変数名
	public Map<String, Object> session;

	// ②DTOとDAOのインスタンス化（コピーして値を代入）
	private RegistCompleteDAO registCompleteDAO = new RegistCompleteDAO();

	// 全てのクラス 変数 変数名(struts) throws=例外を意図的に起こすことが出来る処理のこと。
	public String execute() throws SQLException {

		// DAOを経由して入力された内容をDBに登録します。
		// DAOのregistに記憶している情報を取得してテキストで表す文字列を返す
		System.out.println(userFamilyName);
		System.out.println(registCompleteDAO);
		System.out.println(session);
		System.out.println(toString());
		registCompleteDAO.regist(session.get("userFamilyName").toString(), session.get("userLastName").toString(),
				session.get("userFamilyNameKana").toString(), session.get("userLastNameKana").toString(),
				session.get("userMail").toString(), session.get("userPassword").toString(),
				session.get("userGender").toString(), session.get("userPostalCode").toString(),
				session.get("userPrefecture").toString(), session.get("userAddress1").toString(),
				session.get("userAddress2").toString(), session.get("userAuthority").toString());

		String result = SUCCESS;

		// 戻り値
		// retに入った値を呼び出し元であるActionクラスに渡す
		return result;

	}

	// Listインタフェースのサイズ変更可能な配列の実装です。
	// リストのオプションの操作をすべて実装し、nullを含むすべての要素を許容します。
	// このクラスは、Listインタフェースを実装するほか、リストを格納するために内部的に使われる配列のサイズを操作するメソッドを提供します
	// ArrayList とは、 Listインタフェース を実装した コレクションクラス である。
	// ArrayList は、 Array という名にあるように配列のような感覚で扱うことができる。
	// 配列 には格納できる 要素数が決まっている が、 ArrayList は 要素数は決まっていない 。
	// ArrayList は、 プリミティブ型（int, booleanなど） を入れられない。
	// private ArrayList<HomeDTO> homeList = new ArrayList<HomeDTO>();

	// Listインタフェースのサイズ変更可能な配列の実装です。
	// リストのオプションの操作をすべて実装し、nullを含むすべての要素を許容します。
	// このクラスは、Listインタフェースを実装するほか、リストを格納するために内部的に使われる配列のサイズを操作するメソッドを提供します
	// ArrayList とは、 Listインタフェース を実装した コレクションクラス である。
	// ArrayList は、 Array という名にあるように配列のような感覚で扱うことができる。
	// 配列 には格納できる 要素数が決まっている が、 ArrayList は 要素数は決まっていない 。
	// ArrayList は、 プリミティブ型（int, booleanなど） を入れられない。
	// private HomeDTO HomeDTO = new HomeDTO();

	// private String result;

	// 履歴の削除がされているか否か、チェックをしています。
	// もしdeleteFlgとnullが等しい場合はDBから取得した履歴情報を、「myPageList」に格納しています
	// if (delete_flag == null) {

	// sessionに記憶しているIDとlogin_user_idを取得してテキストで表す文字列を返す
	// item_transaction_idとuser_master_idはDBに問い合わせて受け取ったデータ
	// String family_name = session.get("userFamilyName").toString();
	// String last_name = session.get("luserLastName").toString();
	// String family_name_kana = session.get("userFamilyNameKana").toString();
	// String last_name_kana = session.get("userLastNameKana").toString();
	// String mail = session.get("userMail").toString();
	// String password = session.get("userPassword").toString();
	// String gender = session.get("userGender").toString();
	// String postal_code = session.get("userPostalCode").toString();
	// String prefecture = session.get("userPrefecture").toString();
	// String address_1 = session.get("userAddress1").toString();
	// String address_2 = session.get("userAddress2").toString();
	// String authority = session.get("userAuthority").toString();

	// sessionに記憶しているIDとlogin_user_idを取得してテキストで表す文字列を返す
	// item_transaction_idとuser_master_idはDBに問い合わせて受け取ったデータ
	// String login_user_transaction = session.get("userFamilyName").toString(),
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

	// homeList = RegistCompleteDAO.getRegist(family_name, last_name,
	// family_name_kana,
	// last_name_kana, mail, password, gender, postal_code, prefecture,
	// address_1, address_2, authority);

	// result = SUCCESS;

	// 戻り値
	// retに入った値を呼び出し元であるActionクラスに渡す
	// return result;

	// }

	// RegistCompleteDAO.Regist(userFamilyName, userLastName,
	// userFamilyNameKana,
	// userLastNameKana, userMail, userPassword, userGender, userPostalCode,
	// userPrefecture,
	// userAddress1, userAddress2, userAuthority);

	// System.out.println(userFamilyNameKana);
	// System.out.println(userGender);
	// System.out.println(userAuthority);

	// JSPから送られてきた情報を引数として、
	// LoginDAOクラスのgetLoginUserInfoメソッドを呼び出す
	// その後、DAOで取得した結果をLoginDTOに代入する
	// RegistCompleteDAO.getRegist(userFamilyName, userLastName,
	// userFamilyNameKana,
	// userLastNameKana, userMail, userPassword, userGender, userPostalCode,
	// userPrefecture,
	// userAddress1, userAddress2, userAuthority);

	// Map を使った場合には、put()で要素を記憶できる
	// session.put("regist", HomeDTO);

	// DAOを経由して入力された内容をDBに登録します。
	// DAOのcreateUserに記憶しているid,pass,nameを取得してテキストで表す文字列を返す
	// RegistCompleteDAO.getRegist(session.get("userFamilyName").toString(),
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

	// aとbが共にtrueの時に処理を実行するそうでない場合はエラー
	// if (this.userFamilyName.equals(HomeDTO.getUserFamilyName()) &&
	// this.userLastName.equals(HomeDTO.getUserLastName()) &&
	// this.userFamilyNameKana.equals(HomeDTO.getUserFamilyNameKana()) &&
	// this.userLastNameKana.equals(HomeDTO.getUserLastNameKana()) &&
	// this.userMail.equals(HomeDTO.getUserMail()) &&
	// this.userPassword.equals(HomeDTO.getUserPassword()) &&
	// this.userGender.equals(HomeDTO.getUserGender()) &&
	// this.userPostalCode.equals(HomeDTO.getUserPostalCode()) &&
	// this.userPrefecture.equals(HomeDTO.getUserPrefecture()) &&
	// this.userAddress1.equals(HomeDTO.getUserAddress1()) &&
	// this.userAddress2.equals(HomeDTO.getUserAddress2()) &&
	// this.userAuthority.equals(HomeDTO.getUserAuthority())) {

	// 変数・文字列 result=SUCCESS
	// userCreateComplete.jspに遷移する
	// String result = SUCCESS;

	// 戻り値
	// resultに入った値の処理結果をstrutsが取得してregistComplete.jspに遷移する
	// return result;

	// }

	//フィールド変数に対応したgetterとsetterを定義
	//userCreateconfirm.jspの値として受け取った、userFamilyNameフィールドの値をregistComplete.jspに渡している
	public String getUserFamilyName() {
		return userFamilyName;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserFamilyNameフィールドに格納
	public void setUserFamilyName(String userFamilyName) {
		this.userFamilyName = userFamilyName;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//userCreateconfirm.jspの値として受け取った、userLastNameフィールドの値をregistComplete.jspに渡している
	public String getUserLastName() {
		return userLastName;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserLastNameフィールドに格納
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//userCreateconfirm.jspの値として受け取った、userFamilyNameKanaフィールドの値をregistComplete.jspに渡している
	public String getUserFamilyNameKana() {
		return userFamilyNameKana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserFamilyNameKanaフィールドに格納
	public void setUserFamilyNameKana(String userFamilyNameKana) {
		this.userFamilyNameKana = userFamilyNameKana;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//userCreateconfirm.jspの値として受け取った、userLastNameKanaフィールドの値をregistComplete.jspに渡している
	public String getUserLastNameKana() {
		return userLastNameKana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserLastNameKanaフィールドに格納
	public void setUserLastNameKana(String userLastNameKana) {
		this.userLastNameKana = userLastNameKana;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//userCreateconfirm.jspの値として受け取った、userMailフィールドの値をregistComplete.jspに渡している
	public String getUserMail() {
		return userMail;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserMailフィールドに格納
	public void setUserMail(String userMail) {
		this.userMail = userMail;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//userCreateconfirm.jspの値として受け取った、userPasswordフィールドの値をregistComplete.jspに渡している
	public String getUserPassword() {
		return userPassword;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserPasswordフィールドに格納
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//userCreateconfirm.jspの値として受け取った、userGenderフィールドの値をregistComplete.jspに渡している
	public String getUserGender() {
		return userGender;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserGenderフィールドに格納
	public void setUserGender(String userGender) {
		this.userGender = userGender;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//userCreateconfirm.jspの値として受け取った、userPostalCodeフィールドの値をregistComplete.jspに渡している
	public String getUserPostalCode() {
		return userPostalCode;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserPostalCodeフィールドに格納
	public void setUserPostalCode(String userPostalCode) {
		this.userPostalCode = userPostalCode;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//userCreateconfirm.jspの値として受け取った、userPrefectureフィールドの値をregistComplete.jspに渡している
	public String getUserPrefecture() {
		return userPrefecture;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserPrefectureフィールドに格納
	public void setUserPrefecture(String userPrefecture) {
		this.userPrefecture = userPrefecture;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//userCreateconfirm.jspの値として受け取った、userAddress1フィールドの値をregistComplete.jspに渡している
	public String getUserAddress1() {
		return userAddress1;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserAddress1フィールドに格納
	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//userCreateconfirm.jspの値として受け取った、userAddress2フィールドの値をregistComplete.jspに渡している
	public String getUserAddress2() {
		return userAddress2;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserAddress2フィールドに格納
	public void setUserAddress2(String userAddress2) {
		this.userAddress2 = userAddress2;

	}

	//フィールド変数に対応したgetterとsetterを定義
	//userCreateconfirm.jspの値として受け取った、userAuthorityフィールドの値をregistComplete.jspに渡している
	public String getUserAuthority() {
		return userAuthority;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のuserAuthorityフィールドに格納
	public void setUserAuthority(String userAuthority) {
		this.userAuthority = userAuthority;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のsessionフィールドに代入して格納
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
