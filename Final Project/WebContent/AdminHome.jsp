<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Homepage</title>
</head>
<body>
<jsp:include page="AdminMenu.jsp"></jsp:include>
<h4><%=(request.getAttribute("Message") == null) ? "" : request.getAttribute("Message")%> </h4>
</body>
</html>