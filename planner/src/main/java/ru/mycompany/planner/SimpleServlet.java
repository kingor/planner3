package ru.mycompany.planner;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.mycompany.planner.DAO.CustomerDAOImpl;
import ru.mycompany.planner.DAO.TaskDAOImpl;

public class SimpleServlet extends HttpServlet
{
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  {
    try
    {
      response.setContentType("text/html");
      response.setCharacterEncoding("UTF-8");
      PrintWriter printWriter = response.getWriter();
      HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
      listEvents(printWriter);
      listTask(printWriter);
    }
    catch (IOException ioException)
    {
      ioException.printStackTrace();
    }
  }
  
   private void listEvents(PrintWriter out) {
       CustomerDAOImpl cust = new CustomerDAOImpl();
        Collection<Customer> result = cust.getAll();
        if (result.size() > 0) {
            out.println("<h2>Customers in database:</h2>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>Customer id</th>");
            out.println("<th>Customer Name</th>");
            out.println("</tr>");
            Iterator it = result.iterator();
            while (it.hasNext()) {
                Customer customer = (Customer) it.next();
                out.println("<tr>");
                out.println("<td>" + customer.getIdCustomer() + "</td>");
                out.println("<td>" + customer.getNameCustomer()+ "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }
    }
   private void listTask(PrintWriter out) {
        TaskDAOImpl tsk = new TaskDAOImpl();
        Collection<Task> result = tsk.getAll();
        if (result.size() > 0) {
            out.println("<h2>Task in database:</h2>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>Task id</th>");
            out.println("<th>Task Name</th>");
            out.println("<th>Task Date Start</th>");
            out.println("<th>Task Date End</th>");
            out.println("<th>Task Complited</th>");
            out.println("</tr>");
            Iterator it = result.iterator();
            while (it.hasNext()) {
                Task task = (Task) it.next();
                out.println("<tr>");
                out.println("<td>" + task.getIdTask() + "</td>");
                out.println("<td>" + task.getNameTask()+ "</td>");
                out.println("<td>" + task.getDateStart()+ "</td>");
                out.println("<td>" + task.getDateEnd()+ "</td>");
                out.println("<td>" + task.getCompleted()+ "</td>");
                out.println("<td>" + task.getCustomer().getNameCustomer()+ "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }
    }
}
