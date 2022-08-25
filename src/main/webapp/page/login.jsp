<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Rubik:400,700'>
    <link rel="stylesheet" href="../assets/style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="login-form">
    <form action="/login" method="post">
        <h1>Login</h1>
        <%--        first approach--%>
        <%--<%
            Boolean successFullRegister = (Boolean) request.getAttribute("successFullRegister");
            if (successFullRegister != null && successFullRegister) {
        %>
        <h3 style="color: red">Register Complete!!!</h3>
        <%
            }
        %>--%>

        <%--        second approach--%>
        <%
            Boolean successFullRegister = (Boolean) request.getAttribute("successFullRegister");
            if (successFullRegister != null && successFullRegister) {
                out.print("<h3 style=\"color: red\">Register Complete!!!</h3>");
            }
        %>

        <c:if test="${loginFailed}">
            <h3 style="color: red">Wrong username or password!!!</h3>
        </c:if>

        <div class="content">
            <div class="input-field">
                <input type="text" placeholder="enter username" autocomplete="off" name="username">
            </div>
            <div class="input-field">
                <input type="password" placeholder="enter Password" autocomplete="off" name="password">
            </div>
            <a href="/register">Register</a>
        </div>
        <div class="action">
            <button>Sign in</button>
        </div>
    </form>
</div>

</body>
</html>
