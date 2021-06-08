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

	<form action = "../jp.co.aforce.logout/logout" method = "post">
		<div class = "logout"><input type = "submit" value = "LOGOUT"></div>
	</form>
	
</body>
</html>