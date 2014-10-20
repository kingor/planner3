<%-- 
    Document   : viewCustomerTask
    Created on : 06.10.2014, 15:34:22
    Author     : ASUP8
--%>

<%@page import="java.util.GregorianCalendar"%>
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
                        Integer month = 0;
                        customer = (Customer) request.getAttribute("customer");
                        tasks = (List<Task>) request.getAttribute("tasks");
                        month = (Integer) request.getAttribute("month");
                        if (!customer.equals(null)) {
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
                                for (int day = 1; day < 30; day++) {
                                    out.println("<th>"+ day +"</th>");
                                }
                                out.println("</tr>");
                                Iterator itTask = tasks.iterator();
                                GregorianCalendar calendarStart = new GregorianCalendar();
                                GregorianCalendar calendarEnd = new GregorianCalendar();
                                GregorianCalendar calendarTemp = new GregorianCalendar();
                                while (itTask.hasNext()) {
                                    Task task = (Task) itTask.next();
                                    calendarStart.setTime(task.getDateStart());
                                    calendarEnd.setTime(task.getDateEnd());
                                    calendarTemp.setTime(task.getDateStart());
                                    int year = calendarTemp.get(1);
                                    out.println("<tr>");
                                    out.println("<td>" + task.getId() + "</td>");
                                    out.println("<td>" + task.getName() + "</td>");
                                    out.println("<td>" + task.getDateStart() + "</td>");
                                    out.println("<td>" + task.getDateEnd() + "</td>");
                                    out.println("<td>" + task.getCompleted() + "</td>");
                                    for (int day = 1; day < 30; day++) {
                                        calendarTemp.set(year, month-1, day);
                                        if ((calendarTemp.after(calendarStart) || calendarTemp.equals(calendarStart)) && (calendarTemp.before(calendarEnd) || calendarTemp.equals(calendarEnd)))
                                            out.println("<td>" + "X" + "</td>");
                                        else
                                            out.println("<td>" + "." + "</td>");
                                    }
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
