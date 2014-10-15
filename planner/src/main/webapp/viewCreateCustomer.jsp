<%-- 
    Document   : viewCreateCustomer
    Created on : 06.10.2014, 10:34:05
    Author     : ASUP8
--%>

<%@page import="ru.mycompany.planner.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Создание пользователя</title>
    </head>
    <body>
        <table>
            <tr>
                <td valign = "top">
                    <%@include file="Menu.jspf" %>
                </td>
                <td valign = "top">
                    <%
                        Customer customer = null;
                        Long id = null;
                        customer = (Customer) request.getAttribute("customer");
                        id = (Long) request.getAttribute("id");
                        if (!customer.equals(null) && !id.equals(null)) {
                            out.println("<b>Пользователь: " 
                                    + customer.getName() + " добавлен!</b>");
                            out.println("<br>");
                            out.println("<b>ID :" + customer.getId() 
                                    + " ! </b>");
                        } else {
                            out.println("Пользователь не добавлен!");
                        }
                    %>
                </td>
            </tr>
        </table>     
    </body>
</html>
