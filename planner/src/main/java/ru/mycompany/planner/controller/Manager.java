package ru.mycompany.planner.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.mycompany.planner.Customer;
import ru.mycompany.planner.DAO.DaoFactory;
import ru.mycompany.planner.Task;

public class Manager extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            Collection<Customer> listCustomer = DaoFactory.getCustomerDao().getAll();
            Collection<Task> listTask = DaoFactory.getTaskDao().getAll();
            request.setAttribute("customers", listCustomer);
            request.setAttribute("tasks", listTask);
            RequestDispatcher view = request.getRequestDispatcher("viewManager.jsp");
            view.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listTasks(HttpServletResponse response, Collection<Task> listTask) {
        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            if (listTask.size() > 0) {
                out.println("<h2>Task in database:</h2>");
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<th>Task id</th>");
                out.println("<th>Task Name</th>");
                out.println("<th>Task Date Start</th>");
                out.println("<th>Task Date End</th>");
                out.println("<th>Task Complited</th>");
                out.println("</tr>");
                Iterator itTask = listTask.iterator();
                while (itTask.hasNext()) {
                    Task task = (Task) itTask.next();
                    out.println("<tr>");
                    out.println("<td>" + task.getId() + "</td>");
                    out.println("<td>" + task.getName() + "</td>");
                    out.println("<td>" + task.getDateStart() + "</td>");
                    out.println("<td>" + task.getDateEnd() + "</td>");
                    out.println("<td>" + task.getCompleted() + "</td>");
                    out.println("<td>" + task.getCustomer().getName() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
