<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="manoj.Loanbean,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of loans</title>
</head>
<body>
<jsp:include page="BankerMenu.jsp"/>
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
<th>COMMENTS</th>
</tr>
<%
List<Loanbean> list=(ArrayList)request.getAttribute("loanlist");
for(Loanbean loanbean: list){%>
<tr>
<td><%=loanbean.getLoanid() %></td>
<td><%=loanbean.getUsername()%></td>
<td><%=loanbean.getLoandate() %></td>
<td><%=loanbean.getLoanamount() %></td>
<td><%=loanbean.getIntrestrate() %></td>
<td><%=loanbean.getItemtype() %></td>
<td><%=loanbean.getItemname() %></td>
<td><%=loanbean.getTotalweight() %></td>
<td><%=loanbean.getNetweight() %></td>
<td><%=loanbean.getComment() %></td>
</tr>	
<%}
%>

</table>
</body>
</html>