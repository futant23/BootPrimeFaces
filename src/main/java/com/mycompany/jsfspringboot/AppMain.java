/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jsfspringboot;

import javax.faces.webapp.FacesServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * 
 */
@Configuration
@ComponentScan(basePackages={""})
@EnableAutoConfiguration
public class AppMain extends SpringBootServletInitializer{
    
    private final static Logger log =LoggerFactory.getLogger(AppMain.class);
    
    public static void main(String[] args) {
        log.info("main()");
        SpringApplication.run(AppMain.class, args);
    }
    
   @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(new Class[] { AppMain.class, Initializer.class});
    }
    
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        log.info("servletRegistrationBean()");
        FacesServlet servlet = new FacesServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
		return servletRegistrationBean;
    }
}
