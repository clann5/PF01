<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>boardInsertPage입니다.</h3>
	<script type="text/javascript">
		if (${param.result} > 0) {
			alert('추가되었습니다.');
			location.href='/CatholicVestments/boardList.do';
		} else {
			alert('입력 실패');
			history.back();
		}
	</script>
</body>
</html>