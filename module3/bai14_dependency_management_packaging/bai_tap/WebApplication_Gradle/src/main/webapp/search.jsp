<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/14/2021
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Search</title>
    <style>
        body {
            font-family: Arial;
        }

        * {
            box-sizing: border-box;
        }

        form.example input[type=text] {
            padding: 10px;
            font-size: 17px;
            border: 1px solid grey;
            float: left;
            width: 80%;
            background: #f1f1f1;
        }

        form.example button {
            float: left;
            width: 20%;
            padding: 10px;
            background: #2196F3;
            color: white;
            font-size: 17px;
            border: 1px solid grey;
            border-left: none;
            cursor: pointer;
        }

        form.example button:hover {
            background: #0b7dda;
        }

        form.example::after {
            content: "";
            clear: both;
            display: table;
        }
    </style>
</head>
<body>
<h3 style="text-align: center">Search User</h3>
<form class="example" method="post" style="margin:auto;max-width:300px">
    <input type="text" placeholder="Type user's name" name="searchName">
    <button type="submit"><i class="fa fa-search"></i></button>
</form>

<%--<form method="post" style="text-align: center;border: 1px">--%>
<%--    <input type="text" placeholder="Search" name="searchName"><br><br>--%>
<%--    <input type="submit" value="Search">--%>
<%--</form>--%>
</body>
</html>
