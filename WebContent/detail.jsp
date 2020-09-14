<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.*"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="model.EmployeeBean"%>

<html>
<head>
<title>社員詳細</title>
</head>
<body>
	<%
		String login_id = (String)session.getAttribute( "login_id" );
	%>
	<%
		EmployeeBean emp =(EmployeeBean)request.getAttribute( "emp" );
	%>

	<h1 align="center">社員詳細</h1>

	<form action="/Employee/DetailServlet" method="POST">
		<input type="hidden" name="employee_id"  value="${emp.employee_id}">
		<input type="hidden" name="employee_info_id"  value="${emp.employee_info_id}">

		<table border="1" align="center">
			<tr>
				<td bgcolor="#bad3ff">氏名</td>
				<td>
					<input type="text" name="name" maxlength='20' value="${emp.name}" required>
				</td>
			</tr>
			<tr>
				<td bgcolor="#bad3ff">氏名(ひらがな)</td>
				<td>
					<input type="text" name="name_hiragana" maxlength='20' value="${emp.name_hiragana}" required>
				</td>
			</tr>
			<tr>
				<td bgcolor="#bad3ff">生年月日</td>
				<td>
					<input type="text" name="birthday" maxlength='20' value="${emp.birthday}">
				</td>
			</tr>
			<tr>
				<td bgcolor="#bad3ff">性別</td>
				<td>
					<input type="radio" name="sex" value="0" checked="checked" required>男
					<input type="radio" name="sex" value="1">女
				</td>
			</tr>
			<tr>
				<td bgcolor="#bad3ff">メールアドレス</td>
				<td>
					<input type="text" name="mail_address" maxlength='50' value="${emp.mail_address}">
				</td>
			</tr>
			<tr>
				<td bgcolor="#bad3ff">電話番号</td>
				<td><input type="text" name="telephone_number" maxlength='13' value="${emp.telephone_number}" ></td>
			</tr>
			<tr>
				<td bgcolor="#bad3ff">所属会社</td>
				<td>
					<select name="company_info_id" required>
						<option value="${emp.company_info_id}" selected >${emp.company_info_id}</option>
						<option value="1">ABC</option>
						<option value="2">XYZ</option>
						<option value="3">123</option>
					</select>
				</td>
			</tr>
			<tr>
				<td bgcolor="#bad3ff">担当管理営業</td>
				<td><input type="text" name="business_manager" maxlength='20' value="${emp.business_manager}" required></td>
			</tr>
			<tr>
				<td bgcolor="#bad3ff">事業部</td>
				<td>
					<select name="department" required>
						<option value="${emp.department}" selected >${emp.department}</option>
						<option value="0">0:開発</option>
						<option value="1">1:NW</option>
						<option value="2">2:検証</option>
						<option value="3">3:オフィス</option>
						<option value="4">4:管理</option>
					</select>
				</td>
			</tr>
			<tr>
				<td bgcolor="#bad3ff">稼働状況</td>
				<td>
					<input type="radio" name="commissioning_status" value="1" checked="checked" required >稼働
					<input type="radio" name="commissioning_status" value="0">未稼働
				</td>
			</tr>
			<tr>
				<td bgcolor="#bad3ff">入社日</td>
				<td>
					<input type="date" name="enter_date" maxlength='10' value="${emp.enter_date}" >
				</td>
			</tr>
			<tr>
				<td bgcolor="#bad3ff">退職日</td>
				<td><input type="date" name="retire_date" maxlength='10' value="${emp.retire_date}"></td>
			</tr>
			<tr>
				<td bgcolor="#bad3ff">ステータス</td>
				<td>
					<select name="status" value="${emp.status}" >
						<option value="0">0:在籍</option>
						<option value="1">1:退職</option>
						<option value="2">2:入社待</option>
						<option value="3">3:入社取り消し</option>
					</select>
				</td>
			</tr>
		</table>
		<br>
		<div align="center">
			<input type="submit" name="updateData" value="更新" onclick="return confirm('更新確認')">
			&nbsp;&nbsp;
			<input type="button" onclick="location.href='/Employee/ManagementServlet'" value="戻る">
		</div>
	</form>
</body>
</html>
