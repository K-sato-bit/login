<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login accept</title>
<style>
	body {
		font-family: Meiryo;
	}

	.logout {
		text-align: right;
	}
</style>
</head>

<body>

	ようこそ、<%=(String)session.getAttribute("user_id") %>さん！

	<p>

	ログインに成功しました。

	<div class = "logout">
		<a href="login.jsp">ログイン画面に戻る</a>
	</div>
	
</body>
</html>