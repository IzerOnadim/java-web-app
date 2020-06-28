<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create an account</title>
</head>
<body>

    <h1>Create an account</h1>

    <form action="/createAccount" method="post">
        <label>Please enter your details:</label>
        <p><label>username:</label>
            <input type="text" name="username" width="30"/></p>
        <p><label>password:</label>
            <input type="password" name="password" width="30"/></p>
        <input type="submit" value="Create account">
    </form>

    <p style="color:red;">${errorMessage}</p>

    <h3><a href="/index.jsp">HOME</a></h3>

</body>
</html>
