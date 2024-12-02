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
<title>RegistConfirm画面</title>

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
	margin-left: 20px;
}

#main h4 {
	width: 100%;
	text-align: center;
	padding-top: 200px;
	padding-bottom: 200px;
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

.center-buttons {
	text-align: center;
}

.center-buttons form {
	display: inline;
}

/* ボタン共通スタイル */
input[type="submit"] {
	background-color: #fff; /* ボタンの背景色 */
	padding: 5px 20px; /* 内側の余白 */
	text-align: center;
	font-size: 20px; /* 文字サイズ */
}

</style>
</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<h1>アカウント登録確認画面</h1>
	<div id="main">
		<div id="top">
			<p>ナビゲーションバー</p>
			<h3>アカウント登録確認画面</h3>
		</div>
		<div>
			<table>

					<tr id="box">
						<td><label>名前（姓）</label></td>
						<td><s:property value="userFamilyName" escape="false" /></td>
					</tr>
					<tr id="box">
						<td><label>名前（名）</label></td>
						<td><s:property value="userLastName" escape="false" /></td>
					</tr>
					<tr id="box">
						<td><label>カナ（姓）</label></td>
						<td><s:property value="userFamilyNameKana" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<td><label>カナ（名）</label></td>
						<td><s:property value="userLastNameKana" escape="false" /></td>
					</tr>
					<tr id="box">
						<td><label>メールアドレス</label></td>
						<td><s:property value="userMail" escape="false" /></td>
					</tr>
					<tr id="box">
						<td><label>パスワード</label></td>
						<td><s:if test="maskedPassword != null">
								<s:property value="maskedPassword" />
							</s:if>
						</td>
					</tr>
					<tr id="box">
					    <td><label>性別</label></td>
						<td><s:property value="userGender0" escape="false" />
                        <p>現在の性別: <s:property value="userGender" /></p></td>
					</tr>
					<tr id="box">
						<td><label>郵便番号</label></td>
						<td><s:property value="userPostalCode" escape="false" /></td>
					</tr>
					<tr id="box">
						<td><label>住所（都道府県）</label></td>
						<td><s:property value="userPrefecture" escape="false" /></td>
					</tr>
					<tr id="box">
						<td><label>住所（市区町村）</label></td>
						<td><s:property value="userAddress1" escape="false" /></td>
					</tr>
					<tr id="box">
						<td><label>住所（番地）</label></td>
						<td><s:property value="userAddress2" escape="false" /></td>
					</tr>
					<tr id="box">
						<td><label>アカウント権限</label></td>
						<td><s:property value="userAuthority0" escape="false" />
						<p>現在の性別: <s:property value="userAuthority" /></p></td>
					</tr>
					<tr class="center-buttons">
						<td colspan="2">
							<s:form action="RegistAction" method="post">
                                <s:hidden name="userFamilyName" value="%{userFamilyName}" />
                                <s:hidden name="userLastName" value="%{userLastName}" />
                                <s:hidden name="userFamilyNameKana" value="%{userFamilyNameKana}" />
                                <s:hidden name="userLastNameKana" value="%{userLastNameKana}" />
                                <s:hidden name="userMail" value="%{userMail}" />
                                <s:hidden name="userPassword" value="%{userPassword}" />
                                <s:hidden name="userGender" value="%{userGender}" />
                                <s:hidden name="userPostalCode" value="%{userPostalCode}" />
                                <s:hidden name="userPrefecture" value="%{userPrefecture}" />
                                <s:hidden name="userAddress1" value="%{userAddress1}" />
                                <s:hidden name="userAddress2" value="%{userAddress2}" />
                                <s:hidden name="userAuthority" value="%{userAuthority}" />
                                <input type="submit" value="前に戻る">
                            </s:form>
                            <s:form action="RegistCompleteAction" method="post">
                                <input type="submit" value="登録する">
                            </s:form>
						</td>
					</tr>

			</table>
		</div>
		<p>フッター</p>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>