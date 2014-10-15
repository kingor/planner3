<%-- 
    Document   : viewUpdateCustomer
    Created on : 06.10.2014, 13:46:56
    Author     : ASUP8
--%>

<%@page import="ru.mycompany.planner.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Обновление пользователей</title>
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
                        String oldName = null;
                        String newName = null;
                        customer = (Customer) request.getAttribute("customer");
                        oldName = (String) request.getAttribute("oldName");
                        newName = (String) request.getAttribute("newName");
                        if (!customer.equals(null)) {
                            out.println("<b>Пользователь: "
                                    + customer.getName() + " обновлен!</b>");
                            out.println("<br>");
                            out.println("<b>Старое имя :" + oldName + " ! </b>");
                            out.println("<b>Новое имя :" + newName + " ! </b>");
                        } else {
                            out.println("Пользователь не добавлен!");
                        }
                    %>
                </td>
            </tr>
        </table>     
    </body>
</html>
