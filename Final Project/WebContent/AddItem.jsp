<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Item</title>
<script type="text/javascript">
function validatename(){
var x=document.additem.itemname.value
if(x==null||x==""){
	alert("Item Name can't be blank")
	return false
}
}
</script>
</head>
<body>
<jsp:include page="AdminMenu.jsp"/>
<form name="additem" action="AddItemServlet" method="post" onsubmit="return validatename();" >
<table align="center">
<tr>
<td>Item Name</td>
<td><input type="text" name="itemname"/></td>
</tr>

<tr>
<td>
<%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td>
 </tr>
 
 <tr>
<td></td>
<td><input type="submit" value="Add Item" align="right"/></td>
</tr>
</table>
</form>
</body>
</html>