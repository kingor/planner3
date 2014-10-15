<%-- 
    Document   : viewDeleteCustomer
    Created on : 06.10.2014, 11:29:44
    Author     : ASUP8
--%>

<%@page import="ru.mycompany.planner.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <td>
                    <%@include file="Menu.jspf" %>
                </td>
                <td>
                    <%
                        Customer customer = null;
                        //Long id = null;
                        customer = (Customer) request.getAttribute("customer");
                        if (!customer.equals(null) ) {
                            out.println("<b>Пользователь: "
                                    + customer.getName() + " удален!</b>");
                            out.println("<br>");
                            out.println("<b>ID :" + customer.getId()
                                    + " ! </b>");
                        } else {
                            out.println("Пользователь не удален!");
                        }
                    %>
                </td>
            </tr>
        </table>

    </body>
</html>
