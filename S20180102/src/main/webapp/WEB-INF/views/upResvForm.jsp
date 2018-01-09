<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_detail.jsp" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.body {
		padding-top: 70px;
	}	
</style>
</head>
<body>
<form action="upResvPro.do">
<input type="hidden" name="payCode" value="${resvDto.payCode }">
	<h1>[ ${tcDto.gServTitle } ] 예약 정보 </h1>
	<table>
		<tr><td><img src="${tcDto.imgSrc }" alt="상품이미지"></td></tr>
		<tr><td>상품명</td></tr>
		<tr><td>${tcDto.gServTitle }</td></tr>
		<tr><td>${tcDto.nickName }</td></tr>
	</table>
	<table>
		<tr>
			<td>예약자 EMAIL(ID)</td>
			<td>${resvDto.memberId }</td>
		</tr>
		<tr>
			<td>예약 번호</td>
			<td>${resvDto.payCode }</td>
		</tr>
		<tr>
			<td>상품명</td>
			<td>${tcDto.gServTitle }</td>
		</tr>
		<tr>
			<td>예약인원</td>
			<td><input type="number" name="reMemSize" value="${resvDto.reMemSize }" required="required"></td>
		</tr>
		<tr>
			<td>투어예정일</td>
			<td><input type="date"  name="tourDate" value="${resvDto.tourDate }" required="required"></td>
		</tr>
		<tr>
			<td>총 가격</td>
			<td>${tcDto.gServPrice*resvDto.reMemSize }</td>
		</tr>
		<tr>
			<td>확정여부</td>
			<td>${resvDto.confirm }</td>
		</tr>
	</table>
	<div>
			<input type="submit" value="예약하기">
			<input type="button" value="취소" onclick="location.href='reservation_member.do'">
	</div>
</form>
</body>
</html>