<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script type="text/javascript">
		if (${result} == true) {
			alert('캡차 인증 성공');
			location.href='/CatholicVestments/index.jsp';
		} else {
			alert('캡차 인증 실패');
			// 새로고침
			location.href = '/CatholicVestments/getCaptchaImage.api';
		}
	
	</script>

</body>
</html>