<%-- 
    Document   : newCustomer
    Created on : 24.09.2014, 11:24:15
    Author     : ASUP8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" name="customerForm" action="Controller">
            ФИО нового пользователя:
            <input type="text" name="nameCustomer" value="">
            <br>
            <input type="submit" name="submit" value="Save">
        </form>
    </body>
</html>