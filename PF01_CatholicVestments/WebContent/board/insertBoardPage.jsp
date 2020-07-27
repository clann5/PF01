<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_insert(f) {
		if(f.insertBoard.value == '' || f.insertBoard.value == null){
			alert('내용을 입력하세요')
		}
		f.submit();
	}
</script>
</head>
<body>


<h3>게시글 작성</h3>
	<form action="insertBoard.do" method="post">
		<label>제목</label>
		<input type="text" name="title" autofocus/><br/>
		
		<label>내용</label>
		<textarea name="content" rows="5" cols="50"></textarea><br/>
	
		<button onclick="fn_insert(this.form)">작성</button>
		<input type="reset" value="초기화" />
		<input type="button" value="게시판목록" onclick="location.href='/15_MYBATIS/listBoard.do'" />
	
		<input type="hidden" name="user_id" value="${boardDto.user_id}"/>
	</form>

</body>
</html>