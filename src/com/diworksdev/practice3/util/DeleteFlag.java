package com.diworksdev.practice3.util;

import java.util.Map;

public class DeleteFlag  {

	private static int delete_flag;
	private static String delete_flag0;

//	// Map<String, Object>=キーを値にマッピングするオブジェクト。
//	// マップには、同一のキーを複数登録できない。各キーは1つの値にしかマッピングできません。
//	// このインタフェースは、インタフェースというよりむしろ完全に抽象クラスであったDictionaryクラスに代わるものです
//	// 全てのクラス 変数 変数名
	public static Map<String, Object> session;

	// 全てのクラス 変数 変数名
	public static String getDelete_flag() {

		// resultに上記処理結果を代入
		// String result = SUCCESS;

		delete_flag0 = Integer.toString(delete_flag);// 0or1
		session.put("delete_flag", delete_flag0);// 0or1

		String result = null;

		if (delete_flag0.equals("0")) {

			delete_flag0 = "有効";

		} else if (delete_flag0.equals("1")) {

			delete_flag0 = "無効";

		}

		// 戻り値
		// retに入った値を呼び出し元であるActionクラスに渡す
		return result;

	}
/*
	// フィールド変数に対応したgetterとsetterを定義
	// userCreateconfirm.jspの値として受け取った、userAuthorityフィールドの値をregistComplete.jspに渡している
	public int getDelete_flag() {
		return delete_flag;

	}
*/

	// 外部のSETをここに代入して元々の値を外部から持ってきた値に変えて格納する
	// フィールド変数に対応したgetterとsetterを定義
	// 受け取ったテーブルの値を自身のdeleteFlgフィールドに格納
	public void setDelete_flag(int delete_flag) {
		this.delete_flag = delete_flag;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreateconfirm.jspの値として受け取った、userAuthorityフィールドの値をregistComplete.jspに渡している
	public String getDelete_flag0() {
		return delete_flag0;

	}

	// 外部のSETをここに代入して元々の値を外部から持ってきた値に変えて格納する
	// フィールド変数に対応したgetterとsetterを定義
	// 受け取ったテーブルの値を自身のdeleteFlgフィールドに格納
	public void setDelete_flag0(String delete_flag0) {
		this.delete_flag0 = delete_flag0;
	}

}
