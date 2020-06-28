<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Java Web App</title>
</head>
<body>

  <h1>Hello World!</h1>
  <p>This is my first web app.</p>
  <p><a href="login.jsp">Login</a></p>
  <p><a href="createAccount.jsp">Create an account</a></p>

  <h2>Technologies used:</h2>

  <ul>
    <li>Java</li>
    <li>Apache Tomcat application server</li>
    <li>MySQL database (model)</li>
    <li>JavaServer Pages (view)</li>
    <li>Java Servlets (controller)</li>
  </ul>

  <b><%= new Date()%></b>

</body>
</html>