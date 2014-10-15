/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.mycompany.planner.DAO;

import java.util.Collection;
import ru.mycompany.planner.Customer;

/**
 *
 * @author ASUP8
 */
public interface CustomerDao  extends GenericDao<Customer, Long>{
    Collection<Customer> findByName(String name);
}
