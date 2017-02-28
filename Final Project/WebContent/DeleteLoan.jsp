<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>delete loan</title>
</head>
<body>
<jsp:include page="BankerMenu.jsp"/>
<h4>Do you really want to clear the following Loan?</h4>
<form action="DeleteLoanServlet" method="post">
<table align="center">
<tr>
<td>Loan Id:</td>
<td><%=request.getAttribute("loanid") %></td>
</tr>
<tr>
<td>UserName:</td>
<td><%=request.getAttribute("username") %></td>
</tr>
<tr>
<td>Loan Date:</td>
<td><%=request.getAttribute("loandate") %></td>
</tr>
<tr>
<td>Loan Amount:</td>
<td><%=request.getAttribute("loanamount") %></td>
</tr>
<tr>
<td>Rate of Interest:</td>
<td><%=request.getAttribute("interestrate") %></td>
</tr>
<tr>
<td>Item Type:</td>
<td><%=request.getAttribute("itemtype") %></td>
</tr>
<tr>
<td>Item Name:</td>
<td><%=request.getAttribute("itemname") %></td>
</tr>
<tr>
<td>Total weight:</td>
<td><%=request.getAttribute("totalweight") %></td>
</tr>
<tr>
<td>Net Weight:</td>
<td><%=request.getAttribute("netweight") %></td>
</tr>
<tr>
<td>Comment:</td>
<td><%=request.getAttribute("comments") %></td>
</tr>
<tr>
<td>Release Amount:</td>
<td><%=request.getAttribute("releaseamount") %></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Delete" align="middle"></td>
</tr>
</table>
</form>
</body>
</html>