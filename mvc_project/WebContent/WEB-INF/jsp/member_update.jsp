<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='https://fonts.googleapis.com/css?family=Ubuntu:500' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/member_update.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	var gender = ${requestScope.mvo.gender};
	if(gender==1){
		$("#male").attr("checked", true);
		$("#female").attr("checked", false);
	}else{
		$("#female").attr("checked", true);
		$("#male").attr("checked", false);
	}
});
</script>
</head>
<%@include file="menu.jsp" %>
<body>
<form action="<%=request.getContextPath()%>/memberUpdate" method = "post">
	<div class="member_update">
	  <div class="member_update-header">
	    <h1>Login</h1>
	  </div>
	  <div class="member_update-form">
<!-- 	  ID, PWD, EMAIL, PHONE, ADDR, GENDER, AGE, JOINDT -->
	    <h3>Username:</h3>
	   	 <input type="text" name ="id" readonly="readonly" value="${requestScope.mvo.id }"/><br>
	    <h3>Password:</h3>
	    <input type="password" placeholder="Password" name="pwd" value="${requestScope.mvo.pwd }"/>
	    <br>
	    <h3>Eamil:</h3>
	    <input type="text" placeholder="Eamil" name="email" value="${requestScope.mvo.email }"/>
	    <br>
	    <h3>Phone:</h3>
	    <input type="text" placeholder="Phone Number" name="phone" value="${requestScope.mvo.phone}" />
	    <br>
	    <h3>Address:</h3>
	    <input type="text" placeholder="Address" name="addr" value="${requestScope.mvo.addr}" />
	    <br>
	    <div style="float:left">
	    <h3 style="display: inline-block;">Gender:</h3>
	    <input type="radio" name="gender" id="male" value="1" disabled="disabled"/>Male
	    <input type="radio" name="gender" id="female" value="2" disabled="disabled"/>Female
	    </div>
	    <br><br>
	    <h3>Age:</h3>
	    <input type="text" name="pwd" readonly="readonly" value="${requestScope.mvo.age}" />
	    <br>
	    <input type="submit" value="Update" class="member_update-button"/>
	  </div>
	</div>
</form>
</body>
</html>