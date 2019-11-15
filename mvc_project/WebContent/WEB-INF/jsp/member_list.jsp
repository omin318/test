<%@page import="com.bigdata.mvc.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/member_list.css">
<script type="text/javascript">
function memberUp(id){
	document.location.href = "<%=request.getContextPath()%>/memberUpdatePage?id="+id;
}
function memberDe(id){
	document.location.href = "<%=request.getContextPath()%>/memberDelete?id="+id;
}
</script>
</head>
<body>
<%@ include file = "menu.jsp" %>
<!-- ID -->
<!-- PWD -->
<!-- EMAIL -->
<!-- PHONE -->
<!-- ADDR -->
<!-- GENDER -->
<!-- AGE -->

<div  class="table-title">
	<h3>회원 전체 정보</h3>
</div>
	<table class="table-fill" >
	<thead>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>핸드폰</th>
			<th>주소</th>
			<th>성별</th>
			<th>나이</th>
			<th>가입일자</th>
			<th>수정/삭제</th>
		</tr>
		
		</thead>
		<tbody>
		<%
			List<MemberVO> mlist = (List<MemberVO>)request.getAttribute("mlist");
			for(int i=0; i < mlist.size() ; i++){
		%>

		<tr>
			<td><%=mlist.get(i).getId() %></td>
			<td>********</td>
			<td><%=mlist.get(i).getEmail() %></td>
			<td><%=mlist.get(i).getPhone() %></td>
			<td><%=mlist.get(i).getAddr() %></td>
			
			<%
			if(mlist.get(i).getGender().equals("1")){
			%>
		
				<td>남자</td>
			<%
			}else{
				
			%>
				<td>여자</td>
			<%		
			}
			
			%>
			<td><%=mlist.get(i).getAge() %></td>
			<td><%=mlist.get(i).getJoinDt() %></td>
			<td>
			<input type="button" value="수정" onClick="memberUp('<%=mlist.get(i).getId() %>')">
			<input type="button" value="삭제" onClick="memberDe('<%=mlist.get(i).getId() %>')">
			
			</td>
		</tr>
		
		
		<%
			}
		%>
	</tbody>

	</table>
</body>
</html>