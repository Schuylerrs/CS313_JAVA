<%-- 
    Document   : Login
    Created on : Jun 19, 2015, 1:42:36 PM
    Author     : Schuyler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Select Username</h1>
        <div class="jumbotron">
            <form action="ShowComments" method="POST">
                <h3>Enter Name:</h3>
                <input type="text" name="username"></input><br/>
                <button type="submit"> Login </button>
            </form>
        </div>
    </body>
</html>
