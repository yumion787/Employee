<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
	<h1 align="center">社員管理システム</h1>
	<%
		String msg_error = (String)request.getAttribute("msg_error");
		if(msg_error == null) {
			msg_error = "";
		}
		String msg_login = (String)request.getAttribute("msg_login");
		if(msg_login == null) {
			msg_login = "";
		}
	%>
	<div align="center">
		<span style="color:#FF0000"><%= msg_error %></span>
		<%-- <span style="color:#0000FF"><%= msg_login %></span> --%>
	</div>
	<form action="/Employee/LoginServlet" method="POST">
		<table border="1" align="center" bgcolor="#FFCC00" style="border-collapse: collapse ">
			<tr>
				<th align="center">ログインID</th>
				<td><input type="text" name="login_id"></td>
			</tr>
			<tr>
				<th align="center">パスワード</th>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<div align="center"><input type="submit" value="ログイン" /></div>
	</form>
</body>
</html>