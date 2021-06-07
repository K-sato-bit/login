<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<style>
	body {
		font-family: Meiryo;
		text-align: center;
		width: 70%;
		border: 5px solid silver;
		margin: 30px 400px 30px 200px;
		padding:15px;
	}

	.error {
		color: red;
		font-weight: bold;
	}

	.id {
		text-align: center;
	}

	.password {
		margin-left: 220px;
		margin-right: 290px;
	}
</style>
</head>

<body>
	
	<h2>LOGIN</h2>

	
	<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
	%>

	<div class = "error">
		<%=(String) request.getAttribute("message") %>
	</div>
	
	<% } %>
	
	
	<form action = "../jp.co.aforce.login/login" method = "post">
	
		<div class = "id">ID：<input type = "text" size = "20" name = "user_id"></div>
		
		<br>
		
		<div class = "password">PASSWORD：<input type = "password" size = "20" name = "password"></div>
		
		<p>
		
		<input type = "submit" value = "LOGIN">
	
	</form>
	
</body>
</html>