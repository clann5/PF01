<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 보기</title>

<style type="text/css">

	.tb_subInfo td{
		text-align: center;
		box-sizing: border-box;
	}
	.tb_subInfo td:first-of-type {
		width: 100px;
		background: gray;
		color: white;
	}
	.tb_subInfo td:nth-of-type(2) {
		width: 100px;
		background: skyblue;
	}
	.tb_subInfo td:nth-of-type(3) {
		width: 100px;
		background: gray;
	}
	.tb_subInfo td:last-of-type {
		width: 100px;
		background: gray;
		color: white;
	}
	.boardContent {
		width: 400px;
	}
</style>
</head>
<body>
<div style="text-align: center; width: 400px;">대충 헤더라는 부분</div>

	<form method="post" enctype="multipart/form-data">
		<c:if test="${empty boardDto}">
			<div>내용이 없습니다.</div>
		</c:if>
		<c:if test="${not empty boardDto}">
			<table>
				<tr>
					<th colspan="4">
						<input type="text" name="title" value="${boardDto.title}" />
					</th>
				</tr>
				<tr class="tb_subInfo">
					<td>
						작성자
					</td>
					<td><input type="text" name="user_id" value="${boardDto.user_id}" readonly /></td>
					<td>${boardDto.write_date}</td>
					<td><input type="file" name="filename" value="${boardDto.filename}"/></td>
				</tr>
				<tr>
					<td><div></div></td>
					<td>업로드 된 파일</td>
					<td> : </td>
					<td>
						<c:if test="${empty boardDto.filename}">첨부파일이 없습니다</c:if>
						<c:if test="${not empty boardDto.filename}"><a href="download.do?filename=${boardDto.filename}">${boardDto.filename}</a></c:if>						
					</td>
				</tr>
				<tr>
					<td colspan="3"><textarea class="boardContent" name="content" cols="50" rows="5">${boardDto.content}</textarea></td>
				</tr>
			</table>
		</c:if>
		
		<input type="text" name="no" value="${boardDto.no}" />
		<input type="password" name="pw" value="" />
		<input type="button" value="수정" onclick="fn_boardUpdate(this.form)" />
		<input type="button" value="삭제" onclick="fn_boardDelete(this.form)" />
		<input type="button" value="게시판목록" onclick="location.href='/CatholicVestments/boardList.do'" />
	</form>

	<script type="text/javascript">
		function fn_boardUpdate(f) {
			f.action='/CatholicVestments/boardUpdate.do';
			f.submit();
		}
		function fn_boardDelete(f) {
			f.action='/CatholicVestments/boardDelete.do';
			f.submit();
		}
	</script>

</body>
</html>