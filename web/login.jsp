<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <h1>Welcome to my first webapp.</h1>
    <br>

    <form action="/login" method="post">
        <label>Please enter your details:</label>
        <p><label>username:</label>
            <input type="text" name="username" width="30"/></p>
        <p><label>password:</label>
            <input type="password" name="password" width="30"/></p>
        <input type="submit" value="Login">
    </form>

    <p style="color:red;">${errorMessage}</p>

</body>
</html>
