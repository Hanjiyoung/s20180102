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
</style>
</head>
<body>
<jsp:include page="memberBar.jsp"></jsp:include>
<section class="body">
<h2>나의 후기 관리</h2>

<c:set var="num" value="${pg.total-pg.start+1}"></c:set>
<table>
	<tr><th>주문번호</th>
		<th>상품명</th>
		<th>예약일자</th>
		<th>후기</th>
	</tr>
	<c:if test="${total > 0 }">
		<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.payCode }</td>
				<td><a href="detail_tour.do?gServNo=${list.gServTitle }">${list.gServTitle }</a></td>
				<td>${list.reservDate }</td>
					<c:if test="${list.rvNum >0 }">
						<td><input type="button" value="후기보기"></td>
						<td><input type="button" value="후기수정"></td>
						<td>댓글 수 : ${list.rvNum-1 }</td>
					</c:if>
					<c:if test="${list.rvNum == 0 }">
						<td><input type="button" value="후기작성"></td>
					</c:if>
				</tr>
			<c:set var="num" value="${num - 1 }"></c:set>
		</c:forEach>
	</c:if>
	<c:if test="${total ==0 }">
			<tr>
				<td colspan=6>작성할 후기가 없습니다 :-)</td>
			</tr>
		</c:if>
</table>

<c:if test="${pg.startPage > pg.pageBlock }">
	<a href="review_member.do?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${pg.startPage }" end="${pg.endPage }">
	<a href="review_member.do?currentPage=${i}">[${i}]</a>
</c:forEach>
<c:if test="${pg.endPage < pg.totalPage }">
	<a href="review_member.do?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
</c:if>

</section>
</body>
</html>