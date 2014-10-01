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
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" name="deleteForm" action="DeleteServlet">
            <select name="selectCustomer" >

                <% for (Customer customer : DaoFactory.getCustomerDao().getAll()) {
                        out.print("<option value=" + customer.getIdCustomer() + "  >");
                        out.print(customer.getNameCustomer());
                        out.print("</option>");
                    }
                %>
            </select>
            <input type="submit" value="Delete">
        </form>
    </body>
</html>
