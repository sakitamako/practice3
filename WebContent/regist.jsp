<!-- このファイルが通常のHTMLファイルではなく、JSPであることを示している -->
<!-- strutsタグ（下の補足参照）を使用する際に記述します。ここでは”s”としてタグを使用 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- ユーザー登録機能 -->
<!DOCTYPE html>
<html>
<head>
<!-- 実務で必要になる、検索エンジンに引っかかりやすくなる、どういうコード入力すればより便利になるか -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>Regist画面</title>

<style type="text/css">

/*  TAG LAYOUT  */
body {
	margin: 0;
	padding: 200px;
	line-height: 1.6;
	letter-spacing: 1px;
	font-family: Verdana, Helvetica, sans-serif;
	font-size: 20px;
	color: #333;
	background: #fff;
}

body input {
	border: 1px solid #333;
}

table {
	text-align: center;
	margin: 0 auto;
}

/*  ID LAYOUT  */
#top {
	width: 100%;
	margin-left: 0px;
}

#header {
	width: 100%;
}

#main {
	width: 100%;
	text-align: center;
	border-right: 1px solid #333;
	border-left: 1px solid #333;
}

#main h3 {
	width: 100%;
	text-align: left;
	margin-left: 50px;
}

#main p {
	width: 100%;
	font-size: 20px;
	text-align: center;
	border-top: 1px solid #333;
	border-bottom: 1px solid #333;
	padding-top: 10px;
	padding-bottom: 10px;
}

#main a {
	width: 1000px;
	border: 1px solid #333;
	color: #333;
	padding: 10px;
}

body .fielderror {
    color: #ff0000; /* ここで希望の色コードに変更 */
}

</style>
</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<h1>アカウント登録画面</h1>
	<div id="main">
		<div id="top">
			<p>ナビゲーションバー</p>
			<h3>アカウント登録画面</h3>
		</div>
		<div>
			<table>
				<s:form action="RegistConfirmAction" method="post" >
					<tr>
						<td><label>名前（姓）</label></td>
						<td><input type="text" maxlength="10" name="userFamilyName" value="<s:property value='userFamilyName'/>" />
						<br><s:fielderror fieldName="userFamilyName" style="color: red; font-weight: bold;" /></td>
					</tr>
					<tr>
						<td><label>名前（名）</label></td>
						<td><input type="text" name="userLastName" maxlength="10" value="<s:property value='userLastName'/>" />
						<br><s:fielderror fieldName="userLastName" style="color: red; font-weight: bold;" /></td>
					</tr>
					<tr>
						<td><label>カナ（姓）</label></td>
						<td><input type="text" name="userFamilyNameKana" maxlength="10" value="<s:property value='userFamilyNameKana'/>" />
						<br><s:fielderror fieldName="userFamilyNameKana" style="color: red; font-weight: bold;" /></td>
					</tr>
					<tr>
                        <td><label>カナ（名）</label></td>
                        <td><input type="text" name="userLastNameKana" maxlength="10" value="<s:property value='userLastNameKana'/>" />
                        <br><s:fielderror fieldName="userLastNameKana" style="color: red; font-weight: bold;" /></td>
                    </tr>
					<tr>
                        <td><label>メールアドレス</label></td>
                        <td><input type="text" name="userMail" maxlength="100" value="<s:property value='userMail'/>" />
                        <br><s:fielderror fieldName="userMail" style="color: red; font-weight: bold;" /></td>
                    </tr>
                    <tr>
                        <td><label>パスワード</label></td>
                        <td><input type="text" name="userPassword" maxlength="10" value="<s:property value='userPassword'/>" />
                        <br><s:fielderror fieldName="userPassword" style="color: red; font-weight: bold;" /></td>
                    </tr>
                    <tr>
                        <td><label>性別</label></td>
                        <td><input type="radio" name="userGender" value="0" <s:if test="%{userGender == 0 || userGender == null}">checked="checked"</s:if>>男性
                            <input type="radio" name="userGender" value="1" <s:if test="%{userGender == 1}">checked="checked"</s:if>>女性
                        </td>
                    </tr>
                    <tr>
                        <td><label>郵便番号</label></td>
                        <td><input type="text" name="userPostalCode" maxlength="7" value="<s:property value='userPostalCode'/>" />
                        <br><s:fielderror fieldName="userPostalCode" style="color: red; font-weight: bold;" /></td>
                    </tr>
                    <tr>
                        <td><label>住所（都道府県）</label></td>
                        <td><select name="userPrefecture">
                                <option value="<s:property value='userPrefecture'/>" selected><s:property value='userPrefecture'/></option>
                                <option value="北海道">北海道</option>
                                <option value="青森県">青森県</option>
                                <option value="岩手県">岩手県</option>
                                <option value="宮城県">宮城県</option>
                                <option value="秋田県">秋田県</option>
                                <option value="山形県">山形県</option>
                                <option value="福島県">福島県</option>
                                <option value="茨城県">茨城県</option>
                                <option value="栃木県">栃木県</option>
                                <option value="群馬県">群馬県</option>
                                <option value="埼玉県">埼玉県</option>
                                <option value="千葉県">千葉県</option>
                                <option value="東京都">東京都</option>
                                <option value="神奈川県">神奈川県</option>
                                <option value="新潟県">新潟県</option>
                                <option value="富山県">富山県</option>
                                <option value="石川県">石川県</option>
                                <option value="福井県">福井県</option>
                                <option value="山梨県">山梨県</option>
                                <option value="長野県">長野県</option>
                                <option value="岐阜県">岐阜県</option>
                                <option value="静岡県">静岡県</option>
                                <option value="愛知県">愛知県</option>
                                <option value="三重県">三重県</option>
                                <option value="滋賀県">滋賀県</option>
                                <option value="京都府">京都府</option>
                                <option value="大阪府">大阪府</option>
                                <option value="兵庫県">兵庫県</option>
                                <option value="奈良県">奈良県</option>
                                <option value="和歌山県">和歌山県</option>
                                <option value="鳥取県">鳥取県</option>
                                <option value="島根県">島根県</option>
                                <option value="岡山県">岡山県</option>
                                <option value="広島県">広島県</option>
                                <option value="山口県">山口県</option>
                                <option value="徳島県">徳島県</option>
                                <option value="香川県">香川県</option>
                                <option value="愛媛県">愛媛県</option>
                                <option value="高知県">高知県</option>
                                <option value="福岡県">福岡県</option>
                                <option value="佐賀県">佐賀県</option>
                                <option value="長崎県">長崎県</option>
                                <option value="熊本県">熊本県</option>
                                <option value="大分県">大分県</option>
                                <option value="宮崎県">宮崎県</option>
                                <option value="鹿児島県">鹿児島県</option>
                                <option value="沖縄県">沖縄県</option>
                        </select>
                        <br><s:fielderror fieldName="userPrefecture" style="color: red; font-weight: bold;" /></td>
                    </tr>
                    <tr>
                        <td><label>住所（市区町村）</label></td>
                        <td><input type="text" name="userAddress1" maxlength="10" value="<s:property value='userAddress1'/>" />
                        <br><s:fielderror fieldName="userAddress1" style="color: red; font-weight: bold;" /></td>
                    </tr>
                    <tr>
                        <td><label>住所（番地）</label></td>
                        <td><input type="text" name="userAddress2" maxlength="100" value="<s:property value='userAddress2'/>" />
                        <br><s:fielderror fieldName="userAddress2" style="color: red; font-weight: bold;" /></td>
                    </tr>
                    <tr>
                        <td><label>アカウント権限</label></td>
                        <td><input type="radio" name="userAuthority" value="0" <s:if test="%{userAuthority == 0 || userAuthority == null}">checked="checked"</s:if>>一般
                            <input type="radio" name="userAuthority" value="1" <s:if test="%{userAuthority == 1}">checked="checked"</s:if>>管理者
                        </td>
                    </tr>
                    <tr>
                        <td><s:submit value="登録" /></td>
                    </tr>
				</s:form>
				<s:if test="hasActionErrors()">
                    <div style="color:red;">
                        <s:actionerror />
                    </div>
                </s:if>
			</table>
			<div>
				<span>前画面に戻る場合は</span> <a href='<s:url action="HomeAction" />'>こちら</a>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>