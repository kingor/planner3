<%-- 
    Document   : viewCustomerTask
    Created on : 06.10.2014, 15:34:22
    Author     : ASUP8
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="ru.mycompany.planner.Task"%>
<%@page import="java.util.List"%>
<%@page import="ru.mycompany.planner.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Просмотр задач пользователя</title>
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
                        List<Task> tasks = null;

                        customer = (Customer) request.getAttribute("customer");
                        tasks = (List<Task>) request.getAttribute("tasks");
                        if (!customer.equals(null) ) {
                            out.println("<h1>Пользователь: "
                                    + customer.getName() + " </h1>");
                            out.println("<br>");
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
                                    out.println("</tr>");
                                }
                                out.println("</table>");
                                
                            } else {
                                out.println("<h1>Задач для данного пользователя нет!</h1>");
                            }
                        } else {
                            out.println("Пользователь не выбран!");
                        }
                    %>
                </td>
            </tr>
        </table>     
    </body>
</html>
