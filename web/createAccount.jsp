<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create an account</title>
    <link rel="stylesheet" href="main.css" type="text/css"/>
</head>
<body>

    <h1>Create an account</h1>
    <br>

    <form action="${pageContext.request.contextPath}/createAccount" method="post">
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
        <input type="submit" value="Create account">
    </form>

    <p style="color:red;">${errorMessage}</p>

    <h3><a class="button" href="./index.jsp">HOME</a></h3>

</body>
</html>
