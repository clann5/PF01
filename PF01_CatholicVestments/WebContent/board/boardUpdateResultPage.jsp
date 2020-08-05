<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글을 수정중입니다</title>
</head>
<body>
<h3>게시글 수정 페이지입니다.</h3>
<script type="text/javascript">
		if (${param.result} > 0) {
			alert('수정되었습니다.');
			location.href='/CatholicVestments/boardView.do?no='+${boardDto.no};
		} else {
			alert('입력 실패');
			history.back();
		}
	</script>
</body>
</html>