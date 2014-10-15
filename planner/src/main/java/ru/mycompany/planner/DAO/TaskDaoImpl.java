/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mycompany.planner.DAO;

import java.util.ArrayList;
import static java.util.Calendar.DAY_OF_MONTH;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ru.mycompany.planner.HibernateUtil;
import ru.mycompany.planner.Customer;
import ru.mycompany.planner.Task;

/**
 *
 * @author ASUP8
 */
public class TaskDaoImpl implements TaskDao {

    @Override
    public Long create(Task newInstance) {
        Session session = null;
        Long id = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(newInstance);
            id = newInstance.getId();
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return 0L;
    }

    @Override
    public Task read(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Task transientObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Task persistentObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Task> getAll() {
        Session session = null;
        List<Task> all = new ArrayList<Task>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            all = session.createCriteria(Task.class).list();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return all;
    }

    @Override
    public List<Task> getByCustomer(Customer customer) {
        Session session = null;
        List<Task> tasks = new ArrayList<Task>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            tasks = session.createCriteria(Task.class)
                    .add(Restrictions.eq("customer", customer)).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return tasks;
    }

    @Override
    public List<Task> getByCustomerMonth(Customer customer, Integer month) {
        Session session = null;
        List<Task> tasks = new ArrayList<Task>();
        GregorianCalendar monthStart = new GregorianCalendar(2014, month, 1);
        GregorianCalendar monthEnd = new GregorianCalendar(2014, month, monthStart.getMaximum(DAY_OF_MONTH));
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            tasks = session.createCriteria(Task.class)
                    .add(Restrictions.eq("customer", customer))
                    .add(Restrictions.ge("dateStart", new GregorianCalendar(2014, 01, 20)))
                    /*.add(Restrictions.ge("dateEnd", monthEnd))*/.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return tasks;
    }

}
