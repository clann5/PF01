<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>


<h3>게시글 작성</h3>
	<form method="post" enctype="multipart/form-data">
		<label>제목</label>
		<input type="text" name="title" autofocus/>
		
		<label>작성자</label>
		<input type="text" name="user_id"/>
		<br/>
		<label>비밀번호</label>
		<input type="password" name="pw" /> &nbsp;
		<input type="file" name="filename" />
		<br/>
		
		<label>내용</label>
		<textarea name="content" rows="5" cols="50" style="width: 380px;"></textarea><br/>
	
		
	
		<button onclick="fn_insert(this.form)">작성</button>
		<input type="reset" value="초기화" />
		<!-- contextpath 에러구간 : 임시로 project명으로 구현중 -->
		<input type="button" value="게시판목록" onclick="location.href='/PF01_CatholicVestments/boardList.do'" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
	</form>
	
	<script type="text/javascript">
		function fn_insert(f) {
			if (f.title.value == '') {
				alert('제목을 입력하세요');
				f.title.focus();
				return;
			}
			f.action = '/PF01_CatholicVestments/boardInsert.do';
			f.submit();
		}
	</script>

</body>
</html>