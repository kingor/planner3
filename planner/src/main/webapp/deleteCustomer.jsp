<%-- 
    Document   : deleteCustomer
    Created on : 25.09.2014, 11:40:58
    Author     : ASUP8
--%>

<%@page import="ru.mycompany.planner.DAO.DaoFactory"%>
<%@page import="ru.mycompany.planner.DAO.CustomerDaoImpl"%>
<%@page import="ru.mycompany.planner.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Удаление пользователя</title>
    </head>
    <body>
        <table>
            <tr>
                <td valign = "top">
                    <%@include file="Menu.jspf" %>
                </td>
                <td valign = "top">
                    <form method="post" name="deleteForm" action="deleteCustomer">
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
                        <input type="submit" value="Delete">  
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
