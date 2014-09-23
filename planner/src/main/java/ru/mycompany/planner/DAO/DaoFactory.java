/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.mycompany.planner.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import org.hibernate.Session;

/**
 *
 * @author ASUP8
 */
public interface DaoFactory {
    public Connection getSession() throws SQLException;
    
    public CustomerDAO getCustomerDAO(Session session);
    //public TaskDAO getTaskDAO(Session session);
    
}
