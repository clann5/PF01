<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="전례복" content="" >
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="assets/css/reset.css">
<style>
.wrap {
	width: 100%;
	margin: 0 auto;
	max-width:1200px;
	background: skyblue;
}
.wrap section{
	box-sizing: border-box;
}

.header{
order: 1;
}

.header_list{
display: flex; 
}


@media all and (min-width:960px) {
.wrap {
	max-width: 100%;
}
}
</style>
</head>
<body>
	<div class="wrap">
		<header class="header">
			<ul class="header_list">
				<li><a href="">1</a></li>
				<li><a href="">2</a></li>
				<li><a href="">3</a></li>
				<li><a href="">4</a></li>
				<li><a href="">5</a></li>
				<li><a href="">6</a></li>
				<li><a href="">7</a></li>
				<li><a href="">8</a></li>
			</ul>
		</header>
		<section class="gallery_section">
			2
		</section>
		<section class="info_section">
			<a href="listBoard.do">게시판으로 이동</a>
		</section>
		<section class="popular_section">
			4
		</section>
		<section class="latest_section">
			5
		</section>
		
		<footer class="footer">
			6
		</footer>
	</div>
<script>

</script>
</body>
</html>