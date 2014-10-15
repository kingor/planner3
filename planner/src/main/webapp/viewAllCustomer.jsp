<%-- 
    Document   : allCustomer
    Created on : 24.09.2014, 11:33:27
    Author     : ASUP8
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="ru.mycompany.planner.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Все заказчики</title>
    </head>
    <body>
        <table >
            <tr>
                <td valign = "top">
                    <%@include file="Menu.jspf" %>
                </td>
                <td valign = "top">
                    <%
                        Collection<Customer> customers = (Collection<Customer>) request.getAttribute("customers");
                        if (customers.size() > 0) {
                            out.println("<h2>Customers in database:</h2>");
                            out.println("<table border='1'>");
                            out.println("<tr>");
                            out.println("<th>Customer id</th>");
                            out.println("<th>Customer Name</th>");
                            out.println("</tr>");
                            Iterator itCust = customers.iterator();
                            while (itCust.hasNext()) {
                                Customer customer = (Customer) itCust.next();
                                out.println("<tr>");
                                out.println("<td>" + customer.getId() + "</td>");
                                out.println("<td>" + customer.getName() + "</td>");
                                out.println("</tr>");
                            }
                            out.println("</table>");
                        }
                    %>
                </td>
            </tr>
        </table>
    </body>
</html>
