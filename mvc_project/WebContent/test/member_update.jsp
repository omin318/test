<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='https://fonts.googleapis.com/css?family=Ubuntu:500' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	var gender = ${requestScope.mvo.gender}
	alert(gender);
});
</script>
</head>
<body>
<form action="<%=request.getContextPath()%>/MemberUpdate" method = "post">
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
	    <input type="password" placeholder="Eamil" name="email" value="${requestScope.mvo.email }"/>
	    <br>
	    <h3>Phone:</h3>
	    <input type="password" placeholder="Phone Number" name="phone" value="${requestScope.mvo.phone}" />
	    <br>
	    <h3>Address:</h3>
	    <input type="password" placeholder="Address" name="addr" value="${requestScope.mvo.addr}" />
	    <br>
	    <h3>Gender:</h3>
	    
	    <input type="radio" name="gender" value="1"/>Male
	    <input type="radio" name="gender" value="2"/>Female
	    <br>
	    <h3>Age:</h3>
	    <input type="password" name="pwd" readonly="readonly" value="${requestScope.mvo.age}" />
	    <br>
	    <input type="submit" value="Update" class="member_update-button"/>
	  </div>
	</div>
</form>
</body>
</html>