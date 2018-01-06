<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "js/jquery.js"></script>
<style type="text/css">
	.bar {
		width: 250px;
		height:100%;
		background-color: #232323;
		box-sizing: border-box;
		display: inline-block;
		position: fixed;
		
	}
	
	li {
		list-style: none;
	}
	
	.tap1 {
		text-decoration: none;
		color:white;
	}
</style>
<script type="text/javascript">
function funLoad(){
    var Cheight = $(window).height();
    $('.bar').css({'height':Cheight+'px'});
}
window.onload = funLoad;
window.onresize = funLoad;
</script>
</head>
<body>
<div class="bar">
	<ul >
		<li><a href="profile_member.do" class="tap1">프로필관리</a></li>
		<li><a href="tourDiary.do" class="tap1">투어일정관리</a></li>
		<li><a href="service_guide.do" class="tap1">상품관리</a></li>
		<li><a href="review_guide.do" class="tap1">후기관리</a></li>
		<li><a href="pay_guide.do" class="tap1">정산관리</a></li>			
		<li><a href="QA_guide.do" class="tap1">문의사항</a></li>
	</ul>
</div>
</body>
</html>