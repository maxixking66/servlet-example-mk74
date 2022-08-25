<%--
  Created by IntelliJ IDEA.
  User: Mohsen
  Date: 8/25/2022
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="../assets/users.css">
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css'>

</head>
<body>
<h1>welcome - ${currentUser.firstName}</h1>
<table class="zui-table">
    <thead>
    <tr>
        <th>#</th>
        <th>first name</th>
        <th>last name</th>
        <th>username</th>
        <th>edit</th>
    </tr>
    </thead>
    <tbody>

    <%--  for(User user: users)  --%>
    <c:forEach items="${users}" var="user" varStatus="i">

        <tr>
            <td>${i.index + 1}</td>
            <td>${user.firstName}
                <c:choose>
                    <c:when test="${i.index % 2 == 0}">
                        -even
                    </c:when>
                    <c:otherwise>
                        -odd
                    </c:otherwise>
                </c:choose></td>
            <td>${user.lastName}</td>
            <td>${user.username}</td>
            <td>
                <a href="/user?userId=${user.id}">
                    <i class="fa fa-edit"></i>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
