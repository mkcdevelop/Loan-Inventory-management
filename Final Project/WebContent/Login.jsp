<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<script type="text/javascript">
function validateEmail(){
	var x= document.loginform.username.value
	var atposition=x.indexOf("@");
	var dotposition=x.lastIndexOf("."); 
	if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
	  alert("Please enter a valid e-mail address");  
	  return false;  
	  }  
}
</script>
</head>
<body>
<form name="loginform" action="LoginServlet" method="post" onsubmit="return validateEmail();">
<h1 align="center">Loan Management System</h1>
 
<table align="center">
<tr>
<td>Username</td>
<td><input type="text" name="username"  /></td>
</tr>
 
<tr>
<td>Password</td>
<td><input type="password" name="password" /></td>
 </tr>
 
<tr>
<td>
<%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td>
 </tr>
<tr>
<td></td>
<td><input type="submit" value="Login"></input></td>
 </tr>
 </table>
 
 </form>
</body>
</html>