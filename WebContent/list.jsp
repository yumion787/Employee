<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.EmployeeBean" %>

<%
	ArrayList<EmployeeBean> empList = (ArrayList<EmployeeBean>)request.getAttribute("empList");
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/list.css" type="text/css">
<title>社員一覧</title>
</head>
<body>
	<%
		String login_id = (String)session.getAttribute( "login_id" );
	%>
	<%	// 処理msg
		String msg = (String)request.getAttribute("msg");
		if(msg == null) {
			msg = "";
		}
	%>
	<p><%=msg%></p>

	<div align="right">
		<form action="/Employee/LogoutServlet" method="POST">
			<input type="submit" value="ログアウト" />
		</form>
	</div>
	<h1 align="center">社員一覧</h1>
	<div class="register-btn" align="right">
		<a href="./register.jsp"><input type="button" name="register" value="新規登録" /></a>
	</div>
	<table border="1" align="center">
		<tr bgcolor="#bad3ff" align="center">
			<td><b>No</b></td>		<!-- 1 社員ID -->
			<td><b>会社</b></td>		<!-- 8 所属会社ID -->
			<td><b>事業部</b></td>	<!-- 10 事業部 -->
			<td><b>氏名</b></td>		<!-- 2 氏名 -->
			<td><b>氏名(ひらがな)</b></td>		<!-- 3 氏名(ひらがな) -->
			<td><b>年齢</b></td>		<!-- 4 生年月日 -->
			<td><b>担当管理営業</b></td>		<!-- 9 担当管理営業 -->
			<td><b>入社日</b></td>	<!-- 社員状況  -->
			<td><b>稼働状況</b></td>		<!-- 11 稼働状況 -->
			<td><b>詳細</b></td>
			<td><b>削除</b></td>
		</tr>
		<c:forEach var="emp" items="${empList}" varStatus="status" >
		<tr>
			<td><c:out value="${emp.employee_id}" /></td>				<!-- 1 社員ID -->
			<td>
				<!-- 1:ABC 2:DEF 3:GHI -->
				<c:choose>
					<c:when test="${emp.company_info_id  == 1 }">ABC</c:when>
					<c:when test="${emp.company_info_id  == 2 }">DEF</c:when>
					<c:when test="${emp.company_info_id  == 3 }">GHI</c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
			</td>			<!-- 8 所属会社ID -->
			<td>
				<!-- 0:開発 1:NW 2:検証 3:オフィス 4:管理 -->
				<c:choose>
					<c:when test="${emp.department  == 0 }">開発</c:when>
					<c:when test="${emp.department  == 1 }">NW</c:when>
					<c:when test="${emp.department  == 2 }">検証</c:when>
					<c:when test="${emp.department  == 3 }">オフィス</c:when>
					<c:when test="${emp.department  == 4 }">管理</c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
			</td>				<!-- 10 事業部 -->
			<td><c:out value="${emp.name}" /></td>						<!-- 2 氏名 -->
			<td><c:out value="${emp.name_hiragana}" /></td>				<!-- 3 氏名(ひらがな) -->
			<td><c:out value="${emp.birthday}" /></td>					<!-- 4 生年月日 -->
			<td><c:out value="${emp.business_manager}" /></td>			<!-- 9 担当管理営業 -->
			<td>
				<c:out value="${emp.enter_date}" />
				<%-- <fmt:formatDate value="${emp.enter_date}" pattern="yyyy/MM/dd" /> --%>
			</td>				<!-- 15 入社日 -->
			<td>
				<c:choose>
					<c:when test="${emp.commissioning_status  == 0 }">未稼働</c:when>
					<c:when test="${emp.commissioning_status  == 1 }">稼働</c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
			</td>		<!-- 11 稼働状況 -->
			<!-- 更新 -->
			<td>
				<form action="/Employee/DetailServlet" method="POST">
					<input type="hidden" name="employee_id" value="${emp.employee_id}">
					<input type="hidden" name="name" value="${emp.name}">
					<input type="hidden" name="name_hiragana" value="${emp.name_hiragana}">
					<input type="hidden" name="birthday" value="${emp.birthday}">
					<input type="hidden" name="sex" value="${emp.sex}">
					<input type="hidden" name="mail_address" value="${emp.mail_address}">
					<input type="hidden" name="telephone_number" value="${emp.telephone_number}">
					<input type="hidden" name="company_info_id" value="${emp.company_info_id}">
					<input type="hidden" name="business_manager" value="${emp.business_manager}">
					<input type="hidden" name="department" value="${emp.department}">
					<input type="hidden" name="commissioning_status" value="${emp.commissioning_status}">
					<input type="hidden" name="created_id" value="${emp.created_id}">
					<input type="hidden" name="modified_id" value="${emp.modified_id}">
					<input type="hidden" name="employee_info_id" value="${emp.employee_info_id}">
					<input type="hidden" name="enter_date" value="${emp.enter_date}">
					<input type="hidden" name="retire_date" value="${emp.retire_date}">
					<input type="hidden" name="status" value="${emp.status}">
					<input type="submit" name="detailData" value="詳細">
				</form>
			</td>
			<!-- 削除 -->
			<td>
				<!-- DeleteServlet GET -->
				<a href="/Employee/DeleteServlet?employee_id=${emp.employee_id}" onclick="return confirm('[${emp.employee_id}][${emp.company_info_id}][${emp.name}]を削除しますか？')">削除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
