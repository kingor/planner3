/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.mycompany.planner.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import ru.mycompany.planner.Customer;
import ru.mycompany.planner.DAO.DaoFactory;
import ru.mycompany.planner.Task;

/**
 *
 * @author ASUP8
 */
public class CreateTask extends HttpServlet {

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
        String name = "";
        Customer customer = new Customer();
        GregorianCalendar dateStart = new GregorianCalendar();
        GregorianCalendar dateEnd = new GregorianCalendar();
        Task task = null;
        Integer checked = 0;
        try {
            //name = request.getParameter("nameTask");
            Long id = null;
            id = Long.parseLong(request.getParameter("selectCustomer"));
            //customer = DaoFactory.getCustomerDao().read(id);
            //dateStart = request.getParameter("dateStart");
            //dateEnd = request.getParameter("dateEnd");
            task = new Task();
            task.setName(name);
            task.setCustomer(customer);
            task.setCompleted(checked);
           // task.setDateStart(new Date());
           // task.setDateEnd(new Date());
            DaoFactory.getTaskDao().create(task);
            
        } catch (HibernateException e) {
            e.printStackTrace();
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
