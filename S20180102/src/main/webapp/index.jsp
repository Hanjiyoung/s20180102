<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="board.css" type="text/css"> -->
</head>
<body> 
<%
 //------ 지영 -----------------
 //response.sendRedirect("wishList.do");                             // 위시리스트
 //response.sendRedirect("reservation_member.do");                   // 예약관리
 //response.sendRedirect("pay_member.do");                           // 결제관리
 response.sendRedirect("review_member.do");                        // 후기관리
 
 
 //------ 태욱 -----------------
 
  //response.sendRedirect("service_guide.do?gNo=10001");           // 가이드 상품관리
  //response.sendRedirect("selGServForm.do?gServNo=10001001");     // 상품 수정 form
 
 //---------------------------
%>
</body>
