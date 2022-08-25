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
<p>${user.id}</p>
<p>${user.firstName}</p>
<p>${user.lastName}</p>
<p>${user.username}</p>
</body>
</html>
