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
	
	.star_rating {font-size:0; letter-spacing:-4px;}
	.star_rating a {
	    font-size:10px;
	    letter-spacing:0;
	    display:inline-block;
	    margin-left:5px;
	    color:#ccc;
	    text-decoration:none;
	}
	.star_rating a:first-child {margin-left:0;}
	.star_rating a.on {color:#777;}


</style>
<script type="text/javascript">
	$(document).ready(function(){	
		document.getElementById("theTime").valueAsDate = new Date();
	});
	$(document).ready(function(){
	 	$('input[name=rStar]').val(5);
		$( ".star_rating a" ).click(function() {
		     $(this).parent().children("a").removeClass("on");
		     $(this).addClass("on").prevAll("a").addClass("on");		     
			 $('input[name=rStar]').val($(".on").size());
		     return false;
		});
	});
</script>
</head>
<body>
<form action="writeReviewPro.do">
	<input type="hidden" name="memberId" value="${memberId }">
	<input type="hidden" name="gServNo" value="${rsvDto.gServNo }">	
	<table>
		<caption>
		   [ ${rsvDto.gServTitle } ] 후기 등록
		</caption>
		<tr>
			<td>후기 제목 <input type="text" name = "rTitle" required="required"></td>
		</tr>
		<tr>
			<td>작성자 <input type="text" name="nickName" value="${nickName }" readonly="readonly"></td>
		</tr>
		<tr>
			<td>작성일 <input type="date" id="theTime" disabled="disabled"></td>
		</tr>
		<tr>
			<td><p class="star_rating">
				    <a href="#" class="on">★</a>
				    <a href="#" class="on">★</a>
				    <a href="#" class="on">★</a>
				    <a href="#" class="on">★</a>
				    <a href="#" class="on">★</a>
				</p><input type="hidden" name="rStar"></td>
			<td><input type="file" name="rImg"></td>
			</tr>
		<tr>
			<div id="imgImport"></div>
		</tr>
		<tr>
			<td>
				<textarea rows="15" name="rContent" cols="100"></textarea>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="후기 등록"></td>
		</tr>
	</table>
</form>

</body>
</html>