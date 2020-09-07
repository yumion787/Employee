<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>ようこそ、<c:out value="${login_id}" /></p>
	<a href="/"><button onclick="location.href='http://localhost:8080/Employee/ManagementServlet'">Management一覧</button></a>
	<a href="/Employee/LoginServlet">TOPへ</a>
</body>
</html>