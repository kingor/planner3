/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.mycompany.planner;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Formatter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.mycompany.planner.DAO.DaoFactory;
import ru.mycompany.planner.DAO.TaskDaoImpl;

/**
 *
 * @author ASUP8
 */
@WebServlet(name = "CustomerTask", urlPatterns = {"/CustomerTask"})
public class CustomerTask extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Long id = null;
        id = Long.parseLong(request.getParameter("selectCustomer"));
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            Customer customer = null;
            customer = DaoFactory.getCustomerDao().getById(id);
            listTask(printWriter, customer);
        }
    }

    private void listTask(PrintWriter out, Customer customer) {

        Collection<Task> result = DaoFactory.getTaskDao().getByCustomer(customer);
        out.println("<h2>Customer: " + customer.getNameCustomer() +"</h2>");
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
            SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
            while (it.hasNext()) {
                Task task = (Task) it.next();
                out.println("<tr>");
                out.println("<td>" + task.getIdTask() + "</td>");
                out.println("<td>" + task.getNameTask() + "</td>");
                out.println("<td>" + /*formatter.format(*/task.getDateStart()/*)*/ + "</td>");
                out.println("<td>" + task.getDateEnd() + "</td>");
                out.println("<td><input type=\"checkbox\" name=\"" + task.getIdTask()
                        + "\" value=\"" + task.getIdTask() + "\" checked=\"" + task.getCompleted().equals(true) + "\"</td>");
                out.println("<td>" + task.getCustomer().getNameCustomer() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } else {
            out.println("Задач для заданного пользователя нет!");
        }
}
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
