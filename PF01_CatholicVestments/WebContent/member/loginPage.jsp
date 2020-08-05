<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_refresh_image() {
		location.href = '/CatholicVestments/getCaptchaImage.api';
	}
	function fn_login(f) {
		f.action = '/CatholicVestments/login.api';
		f.submit();
	}
</script>
</head>
<body>

	<form method="post">
	
		<h3>로그인</h3>
	
		<input type="text" name="id" placeholder="아이디" /><br/>
		<input type="password" name="pw" placeholder="****" /><br/><br/>
		아래 이미지를 보이는대로 입력해주세요<br/>
		<img src="${DIRECTORY}/${filename}" style="width: 200px;" /> 
		<input type="button" value="새로고침" onclick="fn_refresh_image()" /> <br/>
		<input type="text" name="input_key" placeholder="자동입력 방지문자" /><br><br>
		<input type="hidden" name="key" value="${key}" />
		<input type="button" value="로그인" onclick="fn_login(this.form)" />
	
	</form>

</body>
</html>