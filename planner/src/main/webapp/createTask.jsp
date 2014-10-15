<%-- 
    Document   : createTask
    Created on : 08.10.2014, 16:05:36
    Author     : ASUP8
--%>

<%@page import="ru.mycompany.planner.DAO.DaoFactory"%>
<%@page import="ru.mycompany.planner.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table valign = "top">
            <tr>
                <td valign = "top">
                    <%@include file="Menu.jspf" %>
                </td>
                <td valign = "top">
                    <form method="get" name="customerForm" action="createTask">
                        <table>
                            <tr>
                                <td>
                                    Название новой задачи:
                                </td>
                                <td>
                                    <input type="text" name="nameTask" value="">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Выберите пользователя для данной задачи:
                                </td>
                                <td>
                                    <select name="selectCustomer" >
                                        <% for (Customer customer : DaoFactory.getCustomerDao().getAll()) {
                                                out.print("<option value=" + customer.getId() + "  >");
                                                out.print(customer.getName());
                                                out.print("</option>");
                                            }
                                        %>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Дата начала задачи:
                                </td>
                                <td>
                                    <input type="date" name="dateStart" value="2014-01-01">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Дата окончания задачи
                                </td>
                                <td>
                                    <input type="date" name="dateEnd" value="2014-01-01">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Выполнено:
                                </td>
                                <td>
                                    <input type="checkbox" name="completed">
                                </td>
                            </tr>
                        </table>
                        <br>
                        <input type="submit" name="submit" value="Save">
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
