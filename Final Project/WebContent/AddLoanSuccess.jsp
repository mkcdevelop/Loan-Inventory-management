<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Loan Success</title>
</head>
<body>
<jsp:include page="BankerMenu.jsp"/>
<table align="center">
<tr>
<td>UserName:</td>
<td><%=request.getAttribute("userName") %></td>
</tr>

<tr>
<td>Loan Date:</td>
<td><%=request.getAttribute("loanDate") %></td>
</tr>

<tr>
<td>Item Type:</td>
<td><%=request.getAttribute("itemType") %></td>
</tr>

<tr>
<td>Item Name</td>
<td><%=request.getAttribute("itemName") %></td>
</tr>

<tr>
<td>Total Weight:</td>
<td><%=request.getAttribute("totalWeight") %></td>
</tr>

<tr>
<td>Net Weight</td>
<td><%=request.getAttribute("netWeight") %></td>
</tr>

<tr>
<td>Loan Amount:</td>
<td><%=request.getAttribute("loanAmount") %></td>
</tr>

<tr>
<td>Interest Rate</td>
<td><%=request.getAttribute("intrestRate") %></td>
</tr>

<tr>
<td>Comments:</td>
<td><%=request.getAttribute("comments") %></td>
</tr>
</table>
</body>
</html>