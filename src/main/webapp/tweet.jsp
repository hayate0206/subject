<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TWEET</title>
</head>
<body>
<header><h1><%= request.getAttribute("message") %></h1></header>
<form action="TweetServlet" method="Post">
	<table>
		<tr>
			<td><input type="text" name="tweet"></td>
		</tr>
		<tr>
			<td><input type="submit" name="userAction" value="ツイート"></td>
		</tr>

	</table>
</form>
<form action="TweetServlet" method="Post">
	<table>
		<tr>
			<td><input type="submit" name="userAction" value="ログアウト"></td>
		</tr>
	</table>
</form>

</body>
</html>