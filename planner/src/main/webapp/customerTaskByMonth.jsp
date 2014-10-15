<%-- 
    Document   : customTaskByMonth
    Created on : 08.10.2014, 12:11:17
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
                    <form method="post" name="updateCustomer" action="customerTaskByMonth">
                        <table>
                            <tr>
                                <td>
                                    Выберите пользователя для просмотра:
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
                                    Выберите месяц
                                </td>
                                <td>
                                    <select name="selectMonth" >
                                        <option value="1" >Январь</option>
                                        <option value="2" >Февраль</option>
                                        <option value="3" >Март</option>
                                        <option value="4" >Апрель</option>
                                        <option value="5" >Май</option>
                                        <option value="6" >Июнь</option>
                                        <option value="7" >Июль</option>
                                        <option value="8" >Август</option>
                                        <option value="9" >Сентябрь</option>
                                        <option value="10" >Октябрь</option>
                                        <option value="11" >Ноябрь</option>
                                        <option value="12" >Декабрь</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                        <input type="submit" name="submit" value="View">
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
