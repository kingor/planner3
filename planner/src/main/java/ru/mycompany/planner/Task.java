/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.mycompany.planner;

import java.beans.*;
import java.io.Serializable;
import java.util.Date;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author ASUP8
 */
//@Entity
//@Table(name="customer")
public class Task implements Serializable{

    private Long idTask;
    private String nameTask;
    private Date dateStart;
    private Date dateEnd;
    private Integer completed;
    private Customer customer;
    public Task() {

    }
    
    public Long getIdTask() {
        return idTask;
    }
    
    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }
    

    public String getNameTask() {
        return nameTask;
    }
    
    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }
    
    public Date getDateStart() {
        return dateStart;
    }
    
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }
    
    public Date getDateEnd() {
        return dateEnd;
    }
    
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
    
    public Integer getCompleted() {
        return completed;
    }
    
    public void setCompleted(Integer completed) {
        this.completed = completed;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}

