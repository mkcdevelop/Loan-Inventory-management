<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoanDataSearch</title>
<script type="text/javascript">
function validateloan(){
	var x= document.loandatasearchr.loanid.value
	if(isNaN(x)||x==null||x==""){
	alert("enter Numeric value")
	return false;  
	  }  
}
</script>
</head>
<body>
<jsp:include page="BankerMenu.jsp"/>
<form name="loandatasearchr" action="SearchLoanDataServlet" method=post onsubmit="return validateloan();">
<table align="center">
<tr>
<td>Loan ID:</td>
<td><input type="text" name="loanid"/></td>
</tr>
<tr>
<td>
<%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td>
 </tr>
<tr>
<td></td>
<td><input type="submit" value="search" align="right"/></td>
</tr>
</table>
</form>
</body>
</html>