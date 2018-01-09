<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_detail.jsp" %>
<%
	String context = request.getContextPath();
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.body {
		padding-top: 70px;
		padding-left:250px;
	}
	
	.left {
		float: left;
	}
</style>
<script type="text/javascript">
	function chk() {
		if(confirm("정말 삭제하시겠습니까?")){
			return true;
		} else {return false;}	
	}	
</script>
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
	</div>
			<ul class="lst_tour">
				<c:forEach var="list" items="${wishList }">
					<li class="left">
						<c:if test="${list.heart>0 }">
							<img src="" alt="빨강하트" id='heart' onclick="location.href='delLikeItPro.do?gServNo=${list.gServNo}'">						
						</c:if>
						<c:if test="${list.heart==0 }">
							<img src="" alt="하양하트" id='heart' onclick="location.href='writeLikeItPro.do?gServNo=${list.gServNo}'">						
						</c:if>
						<a class="" href="tour_detail.do?gServNo=${list.gServNo }">
							<img src="${list.imgSrc }" alt="상품 이미지">
						</a>
						<span class="author">
							<a href="author_detail.do">
								<img alt="프로필사진" src="${list.gImg }">
							</a><br>
							<strong>
								<a href="">${list.nickName }</a>
							</strong>
						</span>
						<p>
							<strong><a href="tour_detail.do?gServNo=${list.gServNo }">${list.gServTitle }</a></strong><br>
							${list.gServSub }
						</p>
						<p>
							<fmt:formatNumber value = "${list.gServPrice }" type="currency" currencySymbol="\\"/>/인<br>
						</p>
						<div class="option">
							<div class="left"><a href="">${list.gServLeadTime }</a></div>
							<div class="left">${list.likeIt }</div>
							<div class="left">${list.remainSize }</div>
						</div>
						<br>
							<input type="button" value="예약하기" onclick="location.href='tour_detail.do?gServNo=${list.gServNo }'">
						  <form class="left" action="delWishList.do" onsubmit="return chk()">
						  	<input type="hidden" name="gServNo" value="${list.gServNo }">						  
							<input type="submit" value="위시리스트 삭제">
						  </form>
						</li>
<%-- 						<c:if test="${list.rn%4==0 }">
							<br>
						</c:if> --%>
				</c:forEach>
			</ul>
</div>

</section>
</body>
</html>