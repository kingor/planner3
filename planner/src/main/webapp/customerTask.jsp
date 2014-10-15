<%-- 
    Document   : CustomerTask
    Created on : 29.09.2014, 15:39:19
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
                    <form method="post" name="updateCustomer" action="customerTask">
                        Выберите пользователя для просмотра:
                        <select name="selectCustomer" >

                            <% for (Customer customer : DaoFactory.getCustomerDao().getAll()) {
                                    out.print("<option value=" + customer.getId() + "  >");
                                    out.print(customer.getName());
                                    out.print("</option>");
                                }
                            %>
                        </select>
                        <br>
                        <input type="submit" name="submit" value="View">
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
