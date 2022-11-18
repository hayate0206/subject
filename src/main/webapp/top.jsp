<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>TOP</title>
</head>
<body>
	<header>TOP</header>
	<form action="user" method="Get">
		<input type="hidden" name="action" value="register" />
		<input type="submit" value="新規登録" />
	</form>
	<form action="user" method="Get">
		<input type="hidden" name="action" value="login" />
		<input type="submit" value="ログイン" />
	</form>

</body>
</html>