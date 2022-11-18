<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>
<form action="user" method="Post">
	<header>ログイン画面</header>
	<table>
		<tr>
			<td>名前(ニックネーム)<br>
			<input type="text" name="nickName">
		</tr>
		<tr>
			<td>ログインパスワード<br>
			<input type="text" name="password">
			<input type="submit" name="userAction" value="ログイン">
		</tr>
	</table>
</form>
</body>
</html>