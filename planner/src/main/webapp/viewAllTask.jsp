<%-- 
    Document   : viewAllTask
    Created on : 08.10.2014, 14:18:35
    Author     : ASUP8
--%>

<%@page import="java.util.Iterator"%>
<%@page import="ru.mycompany.planner.Task"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Все задачи</title>
    </head>
    <body>
        <table >
            <tr>
                <td valign = "top">
                    <%@include file="Menu.jspf" %>
                </td>
                <td valign = "top">
                    <%
                        List<Task> tasks = (List<Task>) request.getAttribute("tasks");
                        if (tasks.size() > 0) {
                            out.println("<h2>Customers in database:</h2>");
                            out.println("<table border='1'>");
                            out.println("<tr>");
                            out.println("<th>Customer id</th>");
                            out.println("<th>Customer Name</th>");
                            out.println("</tr>");
                            Iterator itTask = tasks.iterator();
                            while (itTask.hasNext()) {
                                Task task = (Task) itTask.next();
                                out.println("<tr>");
                                out.println("<td>" + task.getId() + "</td>");
                                out.println("<td>" + task.getName() + "</td>");
                                out.println("<td>" + task.getDateStart() + "</td>");
                                out.println("<td>" + task.getDateEnd()+ "</td>");
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
