<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.EmployeeBean" %>

<%
	ArrayList<EmployeeBean> empList = (ArrayList<EmployeeBean>)request.getAttribute("empList");
%>

<!DOCTYPE html>
<html>
<head>
<title>社員一覧</title>
</head>
<body>
	<br>
	<%
		String login_id = (String)session.getAttribute( "login_id" );
	%>
	<p>(session 確認用) ようこそ、<%= login_id %>さん</p>
	<br>
	<div align="right">
		<form action="/Employee/LogoutServlet" method="POST">
			<input type="submit" value="ログアウト" />
		</form>
	</div>
	<h1 align="center">社員一覧</h1>
	<div align="right">
		<a href="./register.jsp"><input type="button" name="register" value="新規登録" /></a>
	</div>
	<table border="1" align="center">
		<tr bgcolor="#bad3ff" align="center">
			<td><b>No</b></td>		<!-- 1 社員ID -->
			<td><b>会社</b></td>		<!-- 8 所属会社ID -->
			<td><b>事業部</b></td>	<!-- 10 事業部 -->
			<td><b>氏名</b></td>		<!-- 2 氏名 -->
			<td><b>氏名(ひらがな)</b></td>		<!-- 3 氏名(ひらがな) -->
			<td><b>誕生</b></td>		<!-- 4 生年月日 -->
			<td><b>担当管理営業</b></td>		<!-- 9 担当管理営業 -->
			<td><b>入社日</b></td>	<!-- 社員状況  -->
			<td><b>稼働状況</b></td>		<!-- 11 稼働状況 -->
			<td><b>詳細</b></td>
			<td><b>削除</b></td>
		</tr>
		<% for(EmployeeBean emp : empList) { %>
		<%-- <% pageContext.setAttribute("empList",empList); %> --%>
		<%-- <c:forEach var="emp" items="${empList}"> --%>
		<tr>
			<td>		<!-- 1 社員ID -->
				<%= emp.getEmployee_id() %>
				<%-- <c:out value="${emp.employee_id}" /> --%>
			</td>
			<td><%= emp.getCompany_info_id() %></td>		<!-- 8 所属会社ID -->
			<td><%= emp.getDepartment()%></td>				<!-- 10 事業部 -->
			<td><%= emp.getName()%></td>					<!-- 2 氏名 -->
			<td><%= emp.getName_hiragana()%></td>			<!-- 3 氏名(ひらがな) -->
			<td><%= emp.getBirthday()%></td>				<!-- 4 生年月日 -->
			<td><%= emp.getBusiness_manager()%></td>		<!-- 9 担当管理営業 -->
			<td><%= emp.getEnter_date()%></td>				<!-- 15 入社日 -->
			<td><%= emp.getCommissioning_status()%></td>	<!-- 11 稼働状況 -->
<!--  -->
			<td>
				<form action="/Employee/DetailServlet" method="POST">
					<!-- <input type="hidden" name="mode" value="detailData"> -->
					<input type="hidden" name="employee_id" value="<%= emp.getEmployee_id() %>">
					<input type="hidden" name="name" value="<%= emp.getName() %>">
					<input type="hidden" name="name_hiragana" value="<%= emp.getName_hiragana()%>">
					<input type="hidden" name="birthday" value="<%= emp.getBirthday()%>">
					<input type="hidden" name="sex" value="<%= emp.getSex()%>">
					<input type="hidden" name="mail_address" value="<%= emp.getMail_address()%>">
					<input type="hidden" name="telephone_number" value="<%= emp.getTelephone_number()%>">
					<input type="hidden" name="company_info_id" value="<%= emp.getCompany_info_id()%>">
					<input type="hidden" name="business_manager" value="<%= emp.getBusiness_manager()%>">
					<input type="hidden" name="department" value="<%= emp.getDepartment()%>">
					<input type="hidden" name="commissioning_status" value="<%= emp.getCommissioning_status()%>">
					<input type="hidden" name="created_id" value="<%= emp.getCreated_id()%>">
					<input type="hidden" name="modified_id" value="<%= emp.getModified_id()%>>">
					<input type="hidden" name="employee_info_id" value="<%= emp.getEmployee_info_id()%>">
					<input type="hidden" name="enter_date" value="<%= emp.getEnter_date()%>">
					<input type="hidden" name="retire_date" value="<%= emp.getRetire_date()%>">
					<input type="hidden" name="status" value="<%= emp.getStatus()%>">
					<!-- <input type="submit" name="detail" value="詳細"> -->
					<input type="submit" name="detailData" value="詳細">
					<%-- <a href="Detail?employee_id=<%= emp.getEmployee_id() %>" type="submit" >詳細</a> --%>
				</form>
			</td>
			<td>
				<form action="/Employee/DetailServlet" method="POST">
					<%-- <a href="DeleteServlet?&mode=deleteData&employee_id=<%= emp.getEmployee_id() %>" onclick="return confirm('削除しますか？')">削除</a> --%>
					<input type="submit" name="deleteData" value="削除"onclick="return confirm('削除しますか？')" >
				</form>
			</td>
		</tr>
		<%-- </c:forEach> --%>
		<% }	// endfor %>
	</table>

	<br>

	<a href="./index.jsp">TOPへ</a>

</body>
</html>
