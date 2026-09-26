<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Status</title>
</head>
<body>
<%
 String status = (String) request.getAttribute("emp_status");
 if (status != null && !status.isEmpty()) {
	 out.println(status);	 
 }
 else{
	 out.println("operation Failed");
	 
 }
%> 


</body>
</html>