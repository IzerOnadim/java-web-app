<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="main.css" type="text/css"/>
</head>
<body>

    <h1>Welcome</h1>

    <p>
        Hello ${username}, <br><br>
        Welcome to my first my first webapp.
    </p>

    <button onclick="window.location.href='./index.jsp'">Home</button>
    <button onclick="window.location.href='./deleteAccount.jsp'">Delete my account</button>

</body>
</html>
