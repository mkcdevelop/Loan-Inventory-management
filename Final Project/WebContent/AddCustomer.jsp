<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Banker</title>
<script type="text/javascript" src="addcustomer_validate.js"></script>
</head>
<body>
<jsp:include page="BankerMenu.jsp"/>
<form name="addcustomer" action="AddCustomerServlet" method="post" onsubmit="return validateform();">
<table align="center">
<tr>
<td>Username</td>
<td><input type="text" name="username" /></td>
</tr>
 
<tr>
<td>First Name</td>
<td><input type="text" name="firstname" /></td>
 </tr>
 
 <tr>
<td>Last Name</td>
<td><input type="text" name="lastname" /></td>
</tr>

<tr>
<td>Date of Birth (YYYY-MM-DD)</td>
<td><input type="text" name="dateofbirth" /></td>
</tr>

<tr>
<td>Phone Number</td>
<td><input type="text" name="phonenumber" /></td>
</tr>

<tr>
<td>City</td>
<td><input type="text" name="city" /></td>
</tr>
 <tr>
 
 <tr>
<td>Password</td>
<td><input type="text" name="password" /></td>
</tr>

<tr>
<td>
<%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td>
 </tr>
 
<tr>
<td></td>
<td><input type="submit" value="Add" align="right"/></td>
</tr>
 </table>
 </form>
</body>
</html>