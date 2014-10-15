/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mycompany.planner.DAO;

import java.util.List;
import ru.mycompany.planner.Customer;
import ru.mycompany.planner.Task;

/**
 *
 * @author ASUP8
 */
public interface TaskDao extends GenericDao<Task, Long> {
    public List<Task> getByCustomer(Customer customer);
    public List<Task> getByCustomerMonth (Customer customer, Integer month);
}
