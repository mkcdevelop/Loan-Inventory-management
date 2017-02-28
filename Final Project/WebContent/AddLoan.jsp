<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddLoan</title>
<script type="text/javascript" src="addloan_validate.js"></script>
</head>
<body>
<jsp:include page="BankerMenu.jsp"/>
<form name="addloan" action="AddLoanServlet" method="post" onsubmit="return validateform();">
<%
String userName=request.getAttribute("userName").toString();
session.setAttribute("userName", userName);
String loandate;
%>
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
<td>Loan Date:</td>
<td>
<%
java.util.Date dnow=new java.util.Date();
SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd");
loandate=ft.format(dnow);
out.print(ft.format(dnow));
session.setAttribute("loandate",loandate);
%></td>
</tr>

<tr>
<td>Loan Amount:</td>
<td>$<input type="text" name="loanamount"></td>
</tr>

<tr>
<td>Interest Rate:</td>
<td>
<select name="intrestrate">
<option value=null>Select</option>
<option value="10">10 %</option>
<option value="15">15 %</option>
<option value="20">20 %</option>
</select>
</td>
</tr>

<tr>
<td>Item Type:</td>
<td><select name="itemtype">
<option value=null>Select</option>
<option value="GOLD">Gold</option>
<option value="SILVER">Silver</option>
<option value="PLATINUM">Platinum</option>
<option value="DIAMOND">Diamond</option>
</select></td>
</tr>

<tr>
<td>Item Name:</td>
<td>
<select name="itemname">
<option value=null >Select</option>
 <%! manoj.AddItemDao additemdao=new manoj.AddItemDao();
 ResultSet rs; %>
 <%rs=additemdao.searchItem();
 while(rs.next()){
 %>
 <option><%=rs.getString(2) %></option>
 <% } %>
</select>
</td>
</tr>

<tr>
<td>Total Weight:</td>
<td><input type="text" name="totalweight"> grams</td>
</tr>

<tr>
<td>Net Weight:</td>
<td><input type="text" name="netweight"> grams</td>
</tr>

<tr>
<td>Comment:</td>
<td><textarea name="comments" rows="3" cols="30"></textarea></td>
</tr>

<tr>
<td>
<%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td>
 </tr>
 
<tr>
<td></td>
<td><input type="submit" value="Add" align="right"></td>
</tr>
</table>
</form>
</body>
</html>