<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	.tb_subInfo td:first-of-type {
		width: 200px;
		background: red;
	}
	.tb_subInfo td:nth-of-type(2) {
		width: 75px;
		background: gray;
	}
	.tb_subInfo td:nth-of-type(3) {
		width: 75px;
		background: maroon;
	}
</style>
</head>
<body>
dd

<c:if test="${empty boardDto}">
	<div>내용이 없습니다.</div>
</c:if>
<c:if test="${not empty boardDto}">
	<table>
		<tr>
			<th colspan="3">${boardDto.title}</th>
		</tr>
		<tr class="tb_subInfo">
			<td> <!-- 여백 --> </td>
			<td>${boardDto.user_id}</td>
			<td>${boardDto.write_date}</td>
		</tr>
		<tr>
			<td colspan="3"><textarea cols="50" rows="5" disabled="disabled" >${boardDto.content}</textarea></td>
		</tr>
	</table>
</c:if>
</body>
</html>