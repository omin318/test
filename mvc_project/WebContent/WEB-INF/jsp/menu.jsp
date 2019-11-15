<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css"> --%>
<style type="text/css">
body {
  background:url('http://cdn.wallpapersafari.com/13/6/Mpsg2b.jpg');
  margin:0px;
  font-family: 'Ubuntu', sans-serif;
	background-size: 100% 800%;
	
	text-align: center;
}
</style>


</head>
<body >
<%
	if(session.getAttribute("id")==null){
		response.sendRedirect("login");
	}
%>
<h1><a href="memberSelect">회원전체정보</a></h1>

<hr>
<div style="text-align: right">
	<%=session.getAttribute("id") %>님 환영합니다. <br>
	<a href="logout">로그아웃</a>
</div>
</body>
</html>