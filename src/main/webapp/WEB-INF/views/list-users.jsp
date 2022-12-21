
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.12.2022
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Список юзеров</h1>

  <table>
      <tr>
          <th>ID</th>
          <th>Login</th>
          <th>Name</th>
      </tr>
      <c:forEach var="user" items="${users}">
          <tr>
              <th>${user.id}</th>
              <th>${user.username}</th>
              <th>${user.name}</th>
          </tr>
      </c:forEach>
  </table>

    <a href="/welcome">Назад</a>


</body>
</html>
