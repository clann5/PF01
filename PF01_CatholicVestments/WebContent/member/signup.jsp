<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="../assets/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		fn_signup();
	});
	
	function fn_signup(){
		$('#signupBtn').click(function(){
			$.ajax({
				url: '/CatholicVestments/signup.member',
				type: 'post',
				data: $('#f').serialize(),
				dataType: 'json',
				success:function(obj){
					if (obj.isSuccess) {
						alert('회원가입을 축하합니다.');
						location.href = '/CatholicVestments/loginPage.member';
					} else {
						alert('회원가입에 실패하였습니다.');
					}
				},
				error:function(){
					alert('회원가입 실패!');
				}
			});
		});
	}
</script>

</head>
<body>
	<form id="f" method="post">
		<h3>회원가입</h3>
		
		아이디<br/>
		<input id="mId" type="text" name="mId" autofocus />&nbsp;&nbsp;&nbsp;<br>
		<div id="idCheckResult"></div><br/>
		비밀번호<br>
		<input id="mPw" type="password" name="mPw" /><br><br>
		비밀번호 확인<br>
		<input id="mPw2" type="password" name="mPw2" /><br><br>

		이름<br/>
		<input id="mName" type="text" name="mName" /><br><br>
		
		이메일<br/>
		<input id="mEmail" type="text" name="mEmail" /><br><br>
		
		전화<br/>
		<input id="mPhone" type="text" name="mPhone" /><br><br>
		
		주소<br/>
		<input id="mAddress" type="text" name="mAddress" /><br><br>
		
		<input id="signupBtn" type="button" value="회원가입"/>
		<input id="clearBtn" type="button" value="입력취소"/>
	</form>

</body>
</html>