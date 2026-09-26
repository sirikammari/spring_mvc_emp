<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Connection con = controller.DBConn.getConn();
	Statement stmt = con.createStatement();
	int eid = Integer.parseInt(request.getParameter("eid"));
	int i = stmt.executeUpdate("delete from emptbl where eid =" + eid);
	request.getServletContext().getRequestDispatcher("/showEmp.spring").forward(request,response);

	%>
</body>
</html>