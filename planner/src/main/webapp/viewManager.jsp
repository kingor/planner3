<%-- 
    Document   : viewManager
    Created on : 01.10.2014, 13:48:22
    Author     : ASUP8
--%>

<%@page import="ru.mycompany.planner.Task"%>
<%@page import="ru.mycompany.planner.Customer"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                            out.println("");

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

                        Collection<Task> tasks = (Collection<Task>) request.getAttribute("tasks");
                        if (tasks.size() > 0) {
                            out.println("<h2>Task in database:</h2>");
                            out.println("<table border='1'>");
                            out.println("<tr>");
                            out.println("<th>Task id</th>");
                            out.println("<th>Task Name</th>");
                            out.println("<th>Task Date Start</th>");
                            out.println("<th>Task Date End</th>");
                            out.println("<th>Task Complited</th>");
                            out.println("</tr>");
                            Iterator itTask = tasks.iterator();
                            while (itTask.hasNext()) {
                                Task task = (Task) itTask.next();
                                out.println("<tr>");
                                out.println("<td>" + task.getId() + "</td>");
                                out.println("<td>" + task.getName() + "</td>");
                                out.println("<td>" + task.getDateStart() + "</td>");
                                out.println("<td>" + task.getDateEnd() + "</td>");
                                out.println("<td>" + task.getCompleted() + "</td>");
                                out.println("<td>" + ((Customer) task.getCustomer()).getName() + "</td>");
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
