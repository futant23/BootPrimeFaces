/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jsfspringboot.jsf;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author 
 */
@ManagedBean
@ViewScoped
public class EmployeesManagedBean {
    
    private static final Logger log =LoggerFactory.getLogger(EmployeesManagedBean.class);
    
    private List<Employee> employees =new ArrayList<>();
    

    @PostConstruct
    public void init() {
        for(int i =0; i<10; i++) {
            Employee e =new Employee("first"+i, "last"+i);
            log.info("creating employee: " +e);
            employees.add(e); 
            
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
}
