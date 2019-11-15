<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='https://fonts.googleapis.com/css?family=Ubuntu:500' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css">

</head>
<body>
	 <% String msg = (String)request.getAttribute("msg"); 
		if(msg==null){
			msg="";
		}
	%>
	<%--<h1>로그인</h1>
	<form action="<%=request.getContextPath()%>/loginController" method = "post">
		ID : <input type="text" name="id"><br>
		PW : <input type="password" name="pwd"><br>
		<input type="submit" value ="로그인">
	</form>
	 --%>
	
<form action="<%=request.getContextPath()%>/loginController" method = "post">
	<div class="login">
	  <div class="login-header">
	    <h1>Login</h1>
	  </div>
	  <div class="login-form">
	    <h3>Username:</h3>
	   	 <input type="text" placeholder="Username" name ="id"/><br>
	    <h3>Password:</h3>
	    <input type="password" placeholder="Password" name="pwd"/>
	    <br>
	    <input type="submit" value="Login" class="login-button"/>
	    <br>
	    <a class="sign-up">Sign Up!</a>
	    <br>
		<font color="red"> <%=msg %></font>
	  </div>
	</div>
</form>
	
</body>
</html>