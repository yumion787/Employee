<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>結果画面</title>
</head>
<body>
	<br>

	<%
		String msg = (String)request.getAttribute("msg");
	%>

	<div class="container">
		<div class="row">
			<h1>結果画面</h1>
			<p><%=msg%></p>
			<a href="ManagementServlet">一覧へ戻る</a>
			<br>
			<a href="./index.jsp">TOPへ</a>
		</div>
	</div>

</body>
</html>
