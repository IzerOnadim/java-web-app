<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="main.css" type="text/css"/>
</head>
<body>

    <h1>Log in</h1>
    <br>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <label>Please enter your details:</label>
        <p>
            <label>username:
                <input type="text" name="username" width="30"/>
            </label>
        </p>
        <p>
            <label>password:
                <input type="password" name="password" width="30"/>
            </label>
        </p>
        <input type="submit" value="Login"/>
    </form>

    <button onclick="window.location.href='./index.jsp'">Home</button>

    <p style="color:red;">${errorMessage}</p>



</body>
<script src="./home.js"></script>
</html>
