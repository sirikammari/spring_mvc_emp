<%
session.invalidate();
response.sendRedirect("Login.html"); // Redirect to login if not authenticated
%>