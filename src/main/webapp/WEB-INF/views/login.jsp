<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.12.2022
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login in</title>
</head>
<body>
    <h1>Авторизация</h1>
    <form action="/login" method="post">
        <div>
            <c:if test="${(authError != null)}">
                ${authError}
            </c:if>
        </div>

        <label for="login_field">Enter your username:</label>
        <input type="text" name="login" placeholder="Login" id="login_field"/>

        <label for="password_field">Enter your password:</label>
        <input type="password" name="password" placeholder="Password" id="password_field"/>

        <div>
            <input type="submit" value="Submit"/>
            <a href="/registration">Create new account</a>
        </div>

    </form>


</body>
</html>
