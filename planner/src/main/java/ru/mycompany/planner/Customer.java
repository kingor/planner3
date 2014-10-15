/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.mycompany.planner;

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
    private Long id;
   // @Column(name="NAME_CUSTOMER")
    private String name;
  
    public Customer() {

    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long idCustomer) {
        this.id = idCustomer;
    }
    

    public String getName() {
        return name;
    }
    
    public void setName(String nameCustomer) {
        this.name = nameCustomer;
    }
    
}


