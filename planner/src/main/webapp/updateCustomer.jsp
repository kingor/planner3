<%-- 
    Document   : updateCustomer
    Created on : 06.10.2014, 13:24:18
    Author     : ASUP8
--%>

<%@page import="ru.mycompany.planner.DAO.DaoFactory"%>
<%@page import="ru.mycompany.planner.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Обновление пользователя</title>
    </head>
    <body>
        <table valign = "top">
            <tr>
                <td valign = "top">
                    <%@include file="Menu.jspf" %>
                </td>
                <td valign = "top">
                    <form method="post" name="updateCustomer" action="updateCustomer">
                        Выберите пользователя для удаления:
                        <select name="selectCustomer" >

                            <% for (Customer customer : DaoFactory.getCustomerDao().getAll()) {
                                    out.print("<option value=" + customer.getId() + "  >");
                                    out.print(customer.getName());
                                    out.print("</option>");
                                }
                            %>
                        </select>
                        <br>
                        Новое ФИО пользователя:
                        <input type="text" name="nameCustomer" value="">
                        <br>
                        <input type="submit" name="submit" value="Update">
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
