<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글을 수정중입니다</title>
</head>
<body>
<h3>게시글 삭제 페이지입니다.</h3>
<script type="text/javascript">
		if (${param.result} > 0) {
			alert('삭제되었습니다.');
			location.href='/CatholicVestments/boardList.do';
		} else {
			alert('삭제 실패');
			history.back();
		}
	</script>
</body>
</html>