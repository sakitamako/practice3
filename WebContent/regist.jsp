<!-- このファイルが通常のHTMLファイルではなく、JSPであることを示している -->
<!-- strutsタグ（下の補足参照）を使用する際に記述します。ここでは”s”としてタグを使用 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

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

        </style>
    </head>
    <body>
        <div id="header">
            <div id="pr"></div>
        </div>
        <div id="main">
            <div id="top">
                <p>UserCreate</p>
            </div>
            <div>
                <s:if test="errorMessage != ''">
                    <s:property value="errorMessage" escape="false" />
                </s:if>
                <table>
                    <s:form action="RegistConfirmAction">
                        <tr>
                            <td>
                                <label>ログインID：</label>
                            </td>
                            <td>
                                <input type="text" name="userFamilyName" value="" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>ログインPASS：</label>
                            </td>
                            <td>
                                <input type="text" name="userLastName" value="" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>ユーザー名：</label>
                            </td>
                            <td>
                                <input type="text" name="userFamilyNameKana" value="" />
                            </td>
                        </tr>
                        <s:submit value="登録" />
                    </s:form>
                </table>
                <div>
                    <span>前画面に戻る場合は</span>
                    <a href='<s:url action="HomeAction" />'>こちら</a>
                </div>
            </div>
        </div>
        <div id="footer">
            <div id="pr"></div>
        </div>
    </body>
</html>