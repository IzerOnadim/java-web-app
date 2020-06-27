<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Java Web App</title>
</head>
<body>

  <h1>Hello World!</h1>
  <p>This is my first web app JSP page.</p>
  <p><a href="login.jsp">Login</a></p>
  <p><a href="signup.jsp">Create an account</a></p>

  <b><%= new Date()%></b>

</body>
</html>