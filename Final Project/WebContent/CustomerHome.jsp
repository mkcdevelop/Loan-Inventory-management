<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="manoj.Loanbean,java.util.*,manoj.LoanDao,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Homepage</title>
</head>
<body>
<jsp:include page="CustomerMenu.jsp"></jsp:include>
<table align="center" border="2">
<tr>
<th>LOAN ID</th>
<th>USER NAME</th>
<th>LOAN DATE</th>
<th>LOAN AMOUNT</th>
<th>INTEREST RATE</th>
<th>ITEM TYPE</th>
<th>ITEM NAME</th>
<th>TOTAL WEIGHT(Grams)</th>
<th>NET WEIGHT(Grams)</th>
<th>Release Date</th>
<th>Release Amount</th>
<th>Loan Status</th>
<th>Comments</th>
</tr>
<%
LoanDao loandao=new LoanDao();
String username=session.getAttribute("userName").toString();
System.out.print("username is :"+username);
try{
	ResultSet rs= loandao.searchLoan(username);
	while(rs.next()){
%>
<tr>
<td><%=rs.getInt(1) %></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getDouble(4) %></td>
<td><%=rs.getString(5) %></td>
<td><%=rs.getString(6) %></td>
<td><%=rs.getString(7) %></td>
<td><%=rs.getDouble(8) %></td>
<td><%=rs.getDouble(9) %></td>
<td><%=rs.getString(10) %></td>
<td><%=rs.getDouble(11) %></td>
<td><%=rs.getString(12) %></td>
<td><%=rs.getString(13) %></td>
</tr>	
<%}
}catch(SQLException e){
	
}
%>
</table>

</body>
</html>