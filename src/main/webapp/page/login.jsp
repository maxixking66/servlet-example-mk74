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
    <form>
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

        <div class="content">
            <div class="input-field">
                <input type="email" placeholder="Email" autocomplete="nope">
            </div>
            <div class="input-field">
                <input type="password" placeholder="Password" autocomplete="new-password">
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
