/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.mycompany.planner;

import java.beans.*;
import java.io.Serializable;
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
public class Customer implements Serializable{
    
   // @Id
   // @GeneratedValue(generator = "increment")
   // @GenericGenerator(name = "increment", strategy = "increment")
   // @Column(name="ID_CUSTOMER")
    private Long idCustomer;
   // @Column(name="NAME_CUSTOMER")
    private String nameCustomer;
  
    public Customer() {

    }
    
    public Long getIdCustomer() {
        return idCustomer;
    }
    
    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }
    

    public String getNameCustomer() {
        return nameCustomer;
    }
    
    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }
    
}
