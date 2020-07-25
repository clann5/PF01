<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 보기</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<td>글 번호</td>
				<td>제목</td>
				<td>작성자</td>
			</tr>
		</thead>	
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="3">글이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach items="${list}" var="dto" >
					<tr>
						<td>${dto.no}</td>
						<td>${dto.title}</td>
						<td>${dto.user_id}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>

</body>
</html>