<%-- 
    Document   : login
    Created on : Oct 16, 2021, 4:57:09 PM
    Author     : 847240
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action="login">

            <label>Username:</label>
            <input type ="text" name="usernameIn" value= "${username}">
            <br><br>
            <label>Password:</label>
            <input type ="password" name="passwordIn">
            <br><br>
            <input type="submit" value ="Log In">
            <p>${error}</p>
            <p>${logout}</p>
    </body>
</html>
