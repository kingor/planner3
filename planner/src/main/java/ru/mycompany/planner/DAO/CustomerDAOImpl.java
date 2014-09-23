/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.mycompany.planner.DAO;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import ru.mycompany.planner.Customer;
import ru.mycompany.planner.HibernateUtil;
import ru.mycompany.planner.Task;

/**
 *
 * @author ASUP8
 */
public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public List<Customer> findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long create(Customer newInstance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer read(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Customer transientObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Customer persistentObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Customer> getAll() {
       Collection<Customer> all = HibernateUtil.getSessionFactory().getCurrentSession().createCriteria(Task.class).list();
       return all;
    }

    
}
