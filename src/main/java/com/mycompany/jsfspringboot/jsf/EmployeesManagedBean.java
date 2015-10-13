/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jsfspringboot.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 
 */
@ManagedBean (name = "employeesView")
@ViewScoped
public class EmployeesManagedBean implements Serializable{
    
    private static final Logger log =LoggerFactory.getLogger(EmployeesManagedBean.class);
    
    private List<Employee> employees =new ArrayList<>();
    
    private Employee selectedEmployee;

    @PostConstruct
    public void init() {
        for(int i =0; i<10; i++) {
            Employee e =new Employee(String.valueOf(i), "first"+i, "last"+i);
            log.debug("creating employee: " +e);
            employees.add(e);    
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(Employee selectedEmployee) {
        log.info("selected employee: " +selectedEmployee);
        this.selectedEmployee = selectedEmployee;
    }
    
    public void onRowSelect(SelectEvent event) {
        log.debug("onRowSelect");
        Employee employee =(Employee)event.getObject();
        setSelectedEmployee(employee);
        FacesMessage msg = new FacesMessage("Employee Selected", ((Employee) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
//        FacesMessage msg = new FacesMessage("Car Unselected", ((Car) event.getObject()).getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
}
