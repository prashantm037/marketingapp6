<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<h2>Login Here....</h2>
<form action="login" method="post">
Username<input type="text" name="email"/>
Password<input type="password" name="password"/>
 <input type="submit" value="login"/>
</form>

<%
 if(request.getAttribute("error")!=null){
	 out.println(request.getAttribute("error"));
 }

%>

</body>
</html>