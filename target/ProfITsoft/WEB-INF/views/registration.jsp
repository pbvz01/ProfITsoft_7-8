<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.12.2022
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration form</title>
</head>
<body>
    <h1>Регистрация</h1>
    <form:form action="/registration" method="post" modelAttribute="userValid">
        <div>
           <c:if test="${loginIsTaken != null}">
               ${loginIsTaken}
           </c:if>
        </div>

        <div>
            <label for="name_field">Enter your name:</label>
            <form:input type="text" placeholder="Your name" id="name_field" path="name"/>
            <form:errors path="name"/>
        </div>
        <div>
            <label for="login_field">Enter your username:</label>
            <form:input type="text" placeholder="Your login" path="username" id="login_field"/>
            <form:errors path="username"/>
        </div>
        <div>
            <label for="password_field">Enter your password:</label>
            <form:input type="password" placeholder="Your password" path="password" id="password_field"/>
            <form:errors path="password"/>
        </div>
        <input type="submit"value="Submit">
    </form:form>

</body>
</html>
