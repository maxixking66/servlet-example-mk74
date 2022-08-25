<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Rubik:400,700'>
    <link rel="stylesheet" href="../assets/style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="login-form">
    <form action="/register" method="post">
        <h1>Register</h1>
        <div class="content">
            <div class="input-field">
                <input type="text" placeholder="enter firstName" autocomplete="off" name="firstName" required>
            </div>
            <div class="input-field">
                <input type="text" placeholder="enter lastName" autocomplete="off" name="lastName" required>
            </div>
            <div class="input-field">
                <input type="text" placeholder="enter username" autocomplete="off" name="username" required>
            </div>
            <div class="input-field">
                <input type="password" placeholder="enter Password" autocomplete="off" name="password" required>
            </div>
            <a href="/login">Login</a>
        </div>
        <div class="action">
            <button type="submit">Register</button>
        </div>
    </form>
</div>

</body>
</html>
