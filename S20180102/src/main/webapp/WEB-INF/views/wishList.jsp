<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_detail.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.body {
		padding-top: 70px;
		padding-left:250px;
	}
	
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
</head>
<body>
<jsp:include page="memberBar.jsp"></jsp:include>
<section class="body">
<div>

	<div>
		총 ${wishList.size() }개
	</div>
	<div>
		<h2>나의 위시리스트</h2>
		<hr>
	</div>
			<ul class="lst_tour">
				<c:forEach var="list" items="${wishList }">
					<li class="left">
						<a class="" href="">
							<img src="" alt="상품 이미지">
						</a>
						<span class="author">
							<a href="author_detail.do">
								<img alt="프로필사진" src="">
							</a><br>
							<strong>
								<a href="">닉네임</a>
							</strong>
						</span>
						<p>
							<strong><a class="call_tour" href="">${list.gServTitle }</a></strong><br>
							${list.gServSub }
						</p>
						<div class="option">
							<div class="time left"><a href="">${list.gServLeadTime }</a></div>
							<div class="like left">좋아요수</div>
							<div class="remainMember left">남은 인원</div>
						</div>
						</li>
				</c:forEach>
			</ul>
</div>

</section>
</body>
</html>