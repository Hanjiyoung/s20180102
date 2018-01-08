<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_detail.jsp" %>
<!DOCTYPE html>
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
<div class="body">
	<form action="selGServPro.do" method="post">
	<c:set var="gs" value="${gsDto}"></c:set>
		<h3>상품명</h3>
		<input type="text" name="gServTitle" value="${gs.gServTitle}">
		<h3>가이드지역</h3>
		<input type="text" name="gServArea" value="${gs.areaName}">
		<h3>가이드 경로</h3>
		<div id="gServGps"></div>
		<h3>상품 소개</h3>
		<c:set var="cDtoList" value="${cDtoList }"></c:set>
		<textarea rows="30" cols="50">${cDtoList[0].gServIntro }</textarea>
		<h2>가이드 내용</h2>
		<table id="TblAttach">
			<tr>
				<th>#</th>
				<th>행선지소개</th>
				<th>이미지 등록</th>
				<th>경로등록</th>
			</tr>
			<% int num = 1; %>
			<c:forEach var="cDto" items="${cDtoList }">
			<c:if test="${cDto.gServOrder!=0}">
				<tr>
					<td><%=num%></td>
					<% num++; %>
					<td><input type="text" name="gServIntro" value="${cDto.gServIntro }"></td>
					<td><input type="file" name="imgSrc" value="${cDto.imgSrc }"></td>
					<td><input type="button" name="fixServ" value="수정"><input type="button" name="fixServ" value="X" onclick="delItem()"></td>
				</tr>
			</c:if>
			</c:forEach>
			<tr>
					<td><%=num%></td>
					<% num++; %>
					<td><input type="text" name="gServIntro" value=""></td>
					<td><input type="file" name="imgSrc" value=""></td>
					<td><input type="button" name="addServ" onclick="addItem()" value="추가"></td>
			</tr>
		</table>
		<h2>상품유형</h2>
		<input type="radio" name="gServSub" value="1001">명소
		<input type="radio" name="gServSub" value="1002">음식
		<input type="radio" name="gServSub" value="1003">이색투어
		<input type="radio" name="gServSub" value="1004">문화<br>
		<input type="radio" name="gServSub" value="1005">자연
		<input type="radio" name="gServSub" value="1006">액티비티
		<input type="radio" name="gServSub" value="1007">야경
		<input type="radio" name="gServSub" value="1008">쇼핑<br>
		<input type="radio" name="gServSub" value="1009">힐링
		<input type="radio" name="gServSub" value="1010">체험
		<input type="radio" name="gServSub" value="1011">축제
		<input type="radio" name="gServSub" value="2001">가족여행<br>
		<input type="radio" name="gServSub" value="2002">단체여행
		<input type="radio" name="gServSub" value="3001">바다
		<input type="radio" name="gServSub" value="3002">산
		<input type="radio" name="gServSub" value="4001">기차
		<h2>TAG</h2>
		<input type="text" name="servTag" value="${gs.servTag}">
		<h2>가용인원</h2>
		<input type="number" name="memSizeMin" value="${gs.memSizeMin }">
		<input type="number" name="memSizeMax" value="${gs.memSizeMax }">
		<h2>픽업시간</h2>
		<input type="time" name="pickUpTime" value="${gs.pickUpTime }">
		<h2>가능언어</h2>
		<input type="text" name="gServLang" value="${gs.gServLang }">
		<h2>소요시간</h2>
		<input type="text" name="gServLeadTime" value="${gs.gServLeadTime }">
		<h3>가격포함사항</h3>
		<input type="text" name="pInclude" value="${gs.pInclude}">
		<h3>가격불포함사항</h3>
		<input type="text" name="notPInclude" value="${gs.notPInclude}">
		<h3>주의사항</h3>
		<textarea rows="" cols="" name="caution">${gs.caution}</textarea>
		<h3>노출여부</h3>
		<select name="gServLock">
			<option value="Y">Y</option>
			<option value="N">N</option>
		</select>
		
		<input type="submit" value="수정"><input type="reset" value="취소">
	</form>

</div>
	
	<script type="text/javascript">
	function addItem() {
	      var lo_table = document.getElementById("TblAttach");
	      var row_index = lo_table.rows.length;      // 테이블(TR) row 개수
	      newTr = lo_table.insertRow(row_index);
	      newTr.idName = row_index;
	 
	      newTd=newTr.insertCell(0);
	      newTd.innerHTML= row_index;
	 
	      newTd=newTr.insertCell(1);
	      newTd.align = "center";
	      newTd.innerHTML= "<input type=text name=gServIntro>";
	      
	      newTd=newTr.insertCell(2);
	      newTd.align = "center";
	      newTd.innerHTML= "<input type=file name=imgSrc>";
	      newTd=newTr.insertCell(3);
	      newTd.innerHTML= "<input type=button name=addServ onclick=addItem() value=추가>";
	}
	function delItem(){
	      var lo_table = document.getElementById("TblAttach");
	      var row_index = lo_table.rows.length-1;      // 테이블(TR) row 개수
	 
	      if(row_index > 0) lo_table.deleteRow(row_index);    
	}
	</script>
</body>
</html>