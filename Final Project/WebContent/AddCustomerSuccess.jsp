<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer Success</title>
</head>
<body>
<jsp:include page="BankerMenu.jsp"/>
<h4>Successfully Added the following user</h4>
<table align="center">

<tr>
<td>UserName:</td>
<td><%=request.getAttribute("userName") %></td>
</tr>

<tr>
<td>First Name:</td>
<td><%=request.getAttribute("firstName") %></td>
</tr>

<tr>
<td>Last Name:</td>
<td><%=request.getAttribute("lastName") %></td>
</tr>

<tr>
<td>Date Of Birth(YYYY-MM-DD):</td>
<td><%=request.getAttribute("dateofBirth") %></td>
</tr>

<tr>
<td>Phone Number:</td>
<td><%=request.getAttribute("phoneNumber") %></td>
</tr>

<tr>
<td>City:</td>
<td><%=request.getAttribute("cityName") %></td>
</tr>

<tr>
<td>User Role:</td>
<td><%=request.getAttribute("userRole") %></td>
</tr>
</table>
</body>
</html>