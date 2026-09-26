
<%

String user = (String) session.getAttribute("user");

if (user == null) {

response.sendRedirect("login.html"); // Redirect to login if not authenticated

return;

}

%>

<!DOCTYPE html>

<html>

<head>

<title>Menu</title>

<style>

body {

font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;

background-color: #f4f6f8;

margin: 40px;

padding: 20px;

color: #333;

}

h2 {

color: #2d89ef;

margin-bottom: 20px;

}


.menu-container {

background-color: white;

border-radius: 10px;

padding: 30px;

box-shadow: 0 4px 10px rgba(0,0,0,0.1);

max-width: 400px;

}

</style>

</head>

<body>

<div class="menu-container">

<h2>Employee Management System</h2>

<ul>

<li><a href="NewEmp.html">Add Employee</a></li>

<li><a href="showEmp.spring">Show Employees</a></li>

<li><a href="logout.jsp">Logout</a></li>

</ul>

</div>

</body>

</html>