<%@page import="com.bigdata.mvc.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    MemberVO vo = (MemberVO)request.getAttribute("vo");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">

$(document).ready(function() {
    
    //초기화
    //라디오버튼
    $("input:radio[name='gender'][value='<%=vo.getGender()%>']").attr('checked', true);
    
     
});
</script>
</head>
<body>
<div  class="table-title">
	<h3>회원 전체 정보</h3>
</div>
<!-- <th>아이디</th> -->
<!-- 			<th>비밀번호</th> -->
<!-- 			<th>이메일</th> -->
<!-- 			<th>핸드폰</th> -->
<!-- 			<th>주소</th> -->
<!-- 			<th>성별</th> -->
<!-- 			<th>나이</th> -->
<!-- 			<th>가입일자</th> -->
<form action="" method = "post">
	<table class="table-fill" >
	
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><input type="radio" name="gender" value="1">남
				<input type="radio" name="gender" value="2">여
			</td>
		</tr>

	</table>
		<input type="submit" value="수정">
	</form>
</body>
</html>