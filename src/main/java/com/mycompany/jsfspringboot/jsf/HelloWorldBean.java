/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jsfspringboot.jsf;


import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author 
 */
@ManagedBean
@ViewScoped
public class HelloWorldBean {
    
    public String getHello() {
        return "Hello from PrimeFaces and Spring Boot!";
    }
}
