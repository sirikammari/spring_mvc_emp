
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.*" %>

<%@ page import="controller.Employee" %>

<html>

<head>

<title>Employee List</title>

<style>

table {

width: 60%;

margin: auto;

border-collapse: collapse;

}

th, td {

border: 1px solid gray;

padding: 8px;

text-align: center;

}

th {

background-color: #f2f2f2;

}

</style>

</head>

<body>

<a href="menu.jsp">Back</a>

<h2 style="text-align:center;">Employee List</h2>
<p align="right"><a href="LogOut.jsp">Logout</a></p>
<p><a href="NewEmp.html">NewEmp</a></p>

<%

String msg = (String) request.getAttribute("msg");

if (msg != null && !msg.isEmpty()) {

%>

<p style="color:red;text-align:center;"><%= msg %></p>

<%

}

List<Employee> empList = (List<Employee>) request.getAttribute("empList");

if (empList != null && !empList.isEmpty()) {

%>

<table>

<tr>

<th>EID</th>

<th>Name</th>

<th>Designation</th>

<th>Salary</th>

<th></th>

</tr>

<%

for (Employee emp : empList) {

%>

<tr>

<td><%= emp.getEid() %></td>

<td><%= emp.getEname() %></td>

<td><%= emp.getDesg() %></td>

<td><%= emp.getSal() %></td>

<td>
	<a href="./ShowEmp.jsp?eid=<%=emp.getEid()%>">Update</a>
	<a href="./DeleteEmp.jsp?eid=<%=emp.getEid()%>">Delete</a>
</td>

</tr>

<%

}

%>

</table>

<%

} else {

%>

<p style="text-align:center;">No employees found.</p>

<%

}

%>

</body>

</html>