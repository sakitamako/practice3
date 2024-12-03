<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
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

.submit-center {
	display: block;
	margin: 0 auto;
	background: #fff;
	font-size: 20px;
	padding: 5px 20px;
}

body .fielderror {
	color: #ff0000; /* ここで希望の色コードに変更 */
}
</style>
</head>
<body>
	<h1>アカウント登録画面</h1>
	<div id="main">
		<h3>アカウント登録</h3>
		<table>
			<s:form action="RegistConfirmAction" method="post">
				<tr>
					<td><label>名前（姓）</label></td>
					<td><s:textfield name="userFamilyName" maxlength="10"
							cssClass="input" /> <br> <s:fielderror
							fieldName="userFamilyName" cssClass="fielderror" /></td>
				</tr>
				<tr>
					<td><label>名前（名）</label></td>
					<td><s:textfield name="userLastName" maxlength="10"
							cssClass="input" /> <br> <s:fielderror
							fieldName="userLastName" cssClass="fielderror" /></td>
				</tr>
				<tr>
					<td><label>カナ（姓）</label></td>
					<td><s:textfield name="userFamilyNameKana" maxlength="10"
							cssClass="input" /> <br> <s:fielderror
							fieldName="userFamilyNameKana" cssClass="fielderror" /></td>
				</tr>
				<tr>
					<td><label>カナ（名）</label></td>
					<td><s:textfield name="userLastNameKana" maxlength="10"
							cssClass="input" /> <br> <s:fielderror
							fieldName="userLastNameKana" cssClass="fielderror" /></td>
				</tr>
				<tr>
					<td><label>メールアドレス</label></td>
					<td><s:textfield name="userMail" maxlength="100"
							cssClass="input" /> <br> <s:fielderror fieldName="userMail"
							cssClass="fielderror" /></td>
				</tr>
				<tr>
					<td><label>パスワード</label></td>
					<td><s:password name="userPassword" maxlength="10"
							cssClass="input" /> <br> <s:fielderror
							fieldName="userPassword" cssClass="fielderror" /></td>
				</tr>
				<tr>
					<td><label>性別</label></td>
					<td><s:radio name="userGender" list="genderMap" value="%{userGender}" /></td>
				</tr>
				<tr>
					<td><label>郵便番号</label></td>
					<td><s:textfield name="userPostalCode" maxlength="7"
							cssClass="input" /> <br> <s:fielderror
							fieldName="userPostalCode" cssClass="fielderror" /></td>
				</tr>
				<tr>
					<td><label>住所（都道府県）</label></td>
					<td><s:select name="userPrefecture"
							list="{'北海道','青森県','岩手県','宮城県','秋田県','山形県','福島県','茨城県','栃木県',
							'群馬県','埼玉県','千葉県','東京都','神奈川県','新潟県','富山県','石川県','福井県','山梨県',
							'長野県','岐阜県','静岡県','愛知県','三重県','滋賀県','京都府','大阪府','兵庫県','奈良県',
							'和歌山県','鳥取県','島根県','岡山県','広島県','山口県','徳島県','香川県','愛媛県','高知県',
							'福岡県','佐賀県','長崎県','熊本県','大分県','宮崎県','鹿児島県','沖縄県'}" />
						<br> <s:fielderror fieldName="userPrefecture"
							cssClass="fielderror" /></td>
				</tr>
				<tr>
					<td><label>住所（市区町村）</label></td>
					<td><s:textfield name="userAddress1" maxlength="10"
							cssClass="input" /> <br> <s:fielderror
							fieldName="userAddress1" cssClass="fielderror" /></td>
				</tr>
				<tr>
					<td><label>住所（番地）</label></td>
					<td><s:textfield name="userAddress2" maxlength="100"
							cssClass="input" /> <br> <s:fielderror
							fieldName="userAddress2" cssClass="fielderror" /></td>
				</tr>
				<tr>
					<td><label>アカウント権限</label></td>
					<td><s:radio name="userGender" list="genderMap" value="%{userGender}" /></td>
				</tr>
				<tr>
					<td colspan="2"><s:submit value="確認する"
							cssClass="submit-center" /></td>
				</tr>
			</s:form>
		</table>
	</div>
	<p>フッター</p>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>