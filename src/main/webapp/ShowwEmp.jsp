<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>
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
	ResultSet rs = stmt.executeQuery("SELECT * FROM emptbl where eid =" + eid);
	if(rs.next()){
	%>
	<form method="post" action="./updateEmp.spring">
		<table align="center" width="20%" border="2">
			<tr>
				<th>Eid</th>
				<td><input type="text" name="eid" value="<%=rs.getInt(1)%>"/></td>
			</tr>
			<tr>
				<th>Ename</th>
				<td><input type="text" name="ename" value="<%=rs.getString(2)%>"/></td>
			</tr>
			
			<tr>
				<th>desg</th>
				<td><input type="text" name="desg"value="<%=rs.getString(3)%>" /></td>
			</tr>
			<tr>
				<th>sal</th>
				<td><input type="text" name="sal"value="<%=rs.getDouble(4)%>" /></td>
			</tr>
			<tr>
				<th><input type="submit" name="submit" value="update" /></th>
				<td><input type="reset" name="reset" value="clear" /></td>
			</tr>
		</table>
	</form>
<% } %>
</body>
</html>