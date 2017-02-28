<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search customer</title>
<script type="text/javascript">
function validateEmail(){
	var x= document.searchcustomer.username.value
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
<jsp:include page="BankerMenu.jsp"/>
<form name="searchcustomer" action="SearchCustomerServlet" method=post onsubmit="return validateEmail();">
<table align="center">
<tr>
<td>Username:</td>
<td><input type="text" name="username"/></td>
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