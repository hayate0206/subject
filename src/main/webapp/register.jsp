<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTER</title>
</head>
<body>
<form action="user" method="Post">
	<header>登録画面</header>
	<table>
		<tr>
			<td>名前(ニックネーム)<br>
			<input type="text" name="nickName">
		</tr>
		<tr>
			<td>電話番号<br>
			<input type="text" name="phone">
		</tr>
		<tr>
			<td>生年月日<br>
			<input type="text" name="birth_date">
		</tr>
	</table>
	<table>
		<form action="user" method="Post">
			<tr>
				<td>ログインパスワード<br>
				<input type="text" name="password">
				<input type="submit" name="userAction" value="登録">
			</tr>
		</form>
	</table>
</form>
</body>
</html>