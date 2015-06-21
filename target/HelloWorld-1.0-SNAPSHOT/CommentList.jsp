<%-- 
    Document   : ScriptureList
    Created on : Jun 17, 2015, 3:35:45 PM
    Author     : Schuyler
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comment Thread</title>
        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

        <style> 
            div.inputs {
                    background-color: white; 
                    margin-top: 15px;
                    padding: 10px;
                    padding-bottom:5px;
            }

            div.display {
                    background-color:#CCCCFF; 
                    width: 400px;
                    display: block;
            }

            div.jumbotron {
                    padding-left: 2cm;	
            }

            div.update {
                    padding-left: 2cm;
                    width:80%;
                    margin-left: 2cm;
                    border-width: 2px;
            }

            div {
                    padding-left: .5cm;
            }

            div.block {
                    padding-left: 2cm;
                    width:50%;
                    float: left;
                    margin-left: 1cm;
                    border-width: 2px;
            }

            div.update h1 {
                    font-size: 300%;
            }

            img.rounded {
                    border-radius: 50px/50px;
                    width: 75%;
                    border-style: solid;
                    border-width: 5px;
            }
        </style>
    </head>
    <body>
        <h1>Comment Thread</h1>
        <div style="width: 80%">
            <c:forEach var="comment" items="${comments}">
                ${comment}<br/>
            </c:forEach>
        </div>
        
        <div class="jumbotron">
            <form action="AddComment" method="POST">
                <h3>Write comment:</h3><br/>
                <textarea name="comment" rows="4" cols="80"></textarea><br/>
                <button type="submit"> Post </button>
            </form>
        </div>
    </body>
</html>
