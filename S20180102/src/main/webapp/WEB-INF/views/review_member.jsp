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
		<th colspan=3>후기</th>
	</tr>
	<c:if test="${total > 0 }">
		<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.payCode }</td>
				<td><a href="tour_detail.do?gServNo=${list.gServNo }">${list.gServTitle }</a></td>
				<td>${list.reservDate }</td>
					<c:if test="${list.rvNum >0 }">
						<td><input type="button" value="후기보기" onclick="location.href='getReviewPro.do?gServNo=${list.gServNo}'"></td>
						<td><input type="button" value="후기수정" onclick="location.href='updateReviewForm.do?gServNo=${list.gServNo}'"></td>
						<td><input type="button" value="후기삭제" onclick="location.href='delReviewPro.do?gServNo=${list.gServNo}'"></td>
					</c:if>
					<c:if test="${list.rvNum == 0 }">
						<td>
						  <input type="button" value="후기작성" onclick="location.href='writeReviewForm.do?payCode=${list.payCode}'">
						</td>
					</c:if>
				</tr>
			<form action="writeCommentPro.do">
				<input type="hidden" name="gServNo" value="${revDto.gServNo }">
				<input type="hidden" name="rGroup" value="${revDto.rGroup }"> 
				<input type="hidden" name="nickName" value="${revDto.nickName }"> 
				<c:if test="${getReview > 0}">
					<tr>
						<td rowspan=3><img src="${revDto.rImg }" alt="후기 이미지 "></td>
						<td colspan=4>${revDto.rTitle }</td>
						<td>DATE ${revDto.rCredate }</td>
						
					</tr>
					<tr>
						<td  rowspan=2, colspan=4>${revDto.rContent }</td>
						<td>STAR <c:forEach var="i" begin="1" end="${revDto.rStar }">★</c:forEach> </td>
					</tr>
					<tr>
						<td>BY ${revDto.nickName }</td>
					</tr>
					<c:forEach var="revList" items="${revList }">
						<tr>
							<td rowspan=2>┗</td>
							<td rowspan=2, colspan=3>${revList.rContent }</td>
							<td>DATE ${revList.rCredate }</td>
							<c:if test="${revDto.memberId==revList.memberId }">
								<td rowspan=2><input type="button" value="X" onclick="location.href='delCmtPro.do?gServNo=${revDto.gServNo}&rStep=${revList.rStep}'"></td>
							</c:if>
						</tr>
						<tr>
							<td>BY ${revList.nickName }</td>
						</tr>
					</c:forEach>
						<tr>
							<td>┗</td>
							<td colspan=4><textarea name="rContent" cols="80"></textarea></td>
							<td><input type="submit" value="comment"></td>
						</tr>					
				</c:if>
			</form>
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