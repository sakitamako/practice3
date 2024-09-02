<!-- このファイルが通常のHTMLファイルではなく、JSPであることを示している -->
<!-- strutsタグ（下の補足参照）を使用する際に記述します。ここでは”s”としてタグを使用 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- ログイン認証機能 -->
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
        <title>D.I.BLOG</title>
        <link rel="stylesheet" type="text/css" href="./css/style.css">
    </head>

    <body>
        <img src="diblog_logo.jpg">
        <header>
            <ul>
                <li>トップ</li>
                <li>プロフィール</li>
                <li>D.I.BLOGについて</li>
                <li>
                    <a href='<s:url action="RegistAction" />'>アカウント登録</a>
                </li>
                <li>問い合わせ</li>
                <li>その他</li>
            </ul>
        </header>
        <main>
            <div class="main">
                <div class="left">
                    <h1>プログラミングに役立つ書籍</h1>
                    <p>2017年1月15日</p>
                    <img src="bookstore.jpg">
                    <div class="moji">
                        D.I.BlogはD.I.Worksが提供する演習課題です。<br>
                        <br>
                        記事中身
                        <br>
                    </div>
                    <div class="glaybox">
                        <div class="box8">
                            <img src="pic1.jpg">
                            <p>ドメイン取得方法</p>
                        </div>
                        <div class="box8">
                            <img src="pic2.jpg">
                            <p>快適な職場環境</p>
                        </div>
                        <div class="box8">
                            <img src="pic3.jpg">
                            <p>Linuxの基礎</p>
                        </div>
                        <div class="box8">
                            <img src="pic4.jpg">
                            <p>マーケティング入門</p>
                        </div>
                        <div class="box8">
                            <img src="pic5.jpg">
                            <p>アクティブラーニング</p>
                        </div>
                        <div class="box8">
                            <img src="pic6.jpg">
                            <p>CSSの効率的な勉強方法</p>
                        </div>
                        <div class="box8">
                            <img src="pic7.jpg">
                            <p>リーダブルコードとは</p>
                        </div>
                        <div class="box8">
                            <img src="pic8.jpg">
                            <p>HTML5の可能性</p>
                        </div>
                    </div>
                </div>
                <div class="right">
                    <h4>人気の記事</h4>
                    <ul>
                        <li>PHPおすすめ本</li>
                        <li>PHP MyAdminの使い方</li>
                        <li>いま人気のエディタTops</li>
                        <li>HTMLの基礎</li>
                    </ul>
                    <h4>オススメリンク</h4>
                    <ul>
                        <li>ﾃﾞｨｰｱｲﾜｰｸｽ株式会社</li>
                        <li>XAMPPのダウンロード</li>
                        <li>Eclipseのダウンロード</li>
                        <li>Braketsのダウンロード</li>
                    </ul>
                    <h4>カテゴリ</h4>
                    <ul>
                        <li>HTML</li>
                        <li>PHP</li>
                        <li>MySQL</li>
                        <li>JavaScript</li>
                    </ul>
                </div>
            </div>
        </main>
        <footer>Copyright D.I.works | D.I.blog is the one which provides A to Z about programming</footer>
    </body>
</html>