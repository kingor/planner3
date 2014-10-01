/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.mycompany.planner.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import net.sf.cglib.proxy.Factory;
import org.hibernate.Session;

/**
 *
 * @author ASUP8
 */
public class DaoFactory {
    
    private static DaoFactory instance = null;
    private static CustomerDao customerDao = null;
    private static TaskDao taskDao = null;
    
    public static synchronized DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }
    
    public static synchronized CustomerDao getCustomerDao() {
        if (customerDao == null) {
            customerDao = new CustomerDaoImpl();
        }
        return customerDao;
    }
    
    public static synchronized TaskDao getTaskDao() {
        if (taskDao == null) {
            taskDao = new TaskDaoImpl();
        }
        return taskDao;
    }
   
}
