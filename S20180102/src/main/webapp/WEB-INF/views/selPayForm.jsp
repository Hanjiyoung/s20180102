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
<section class="body">
<form action="payPro.do">
	<input type="hidden" name="gServNo" value="${resvDto.gServNo }">
	<input type="hidden" name="amount" value="${resvDto.amount }">
	<input type="hidden" name="payCode" value="${resvDto.payCode }">
	<h1> 결제 </h1>
	<table>
		<tr><td><img src="${tcDto.imgSrc }" alt="상품이미지"></td></tr>
		<tr><td>상품명</td></tr>
		<tr><td>${tcDto.gServTitle }</td></tr>
		<tr><td>${tcDto.nickName }</td></tr>
	</table>
	<table>
		<caption>
			<span>구매자 정보</span>
		</caption>
		<tr>
			<td>ID</td>
			<td><input type="text" name="memberId" value="${resvDto.memberId }" readonly="readonly"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="buyer_name" value="${mbDto.mName }" required="required"></td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><input type="tel"  name="buyer_tel" value="${mbDto.tel }" required="required"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="buyer_addr"  value="${mbDto.addr }" required="required"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="buyer_email" value="${resvDto.memberId }" required="required"></td>
		</tr>
	</table>
	<table>
		<caption>예약 정보</caption>
		<tr>	
			<td>예약 인원</td>
			<td>${resvDto.reMemSize }</td>
		</tr>
		<tr>	
			<td>투어예정일</td>
			<td>${resvDto.tourDate }</td>
		</tr>
	</table>
	<table>
		<caption>
			<span>결제 정보</span>
		</caption>
		<tr>
			<td>결제 코드</td>
			<td>${resvDto.payCode }</td>
		</tr>
		<tr>	
			<td>가격</td>
			<td><fmt:formatNumber value = "${resvDto.amount }" type="currency" currencySymbol="\\"/></td>
		</tr>
		<tr>	
			<td>할인금액</td>
			<td>0원</td>
		</tr>
		<tr>
			<td>결제금액</td>
			<td><fmt:formatNumber value = "${resvDto.amount }" type="currency" currencySymbol="\\"/></td>
		</tr>
	</table>
	<table>
		<tr>
			<td colspan=2>결제 방법</td>
		</tr>
		<tr>
			<td><input type="radio" name="pay_method" value="01">신용카드</td>
			<td><input type="radio" name="pay_method" value="02">무통장입금</td>
		</tr>
	</table>	
	<div>
			<input type="submit" value="결제하기">
			<input type="button" value="취소" onclick="location.href='reservation_member.do'">
	</div>
</form>


</section>
</body>
</html>