package com.revature.restaurant_application.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.restaurant_application.daos.CreditCardDao;
import com.revature.restaurant_application.daos.CustomerDao;
import com.revature.restaurant_application.daos.MenuDao;
import com.revature.restaurant_application.daos.OrderDao;
import com.revature.restaurant_application.services.CreditCardServices;
import com.revature.restaurant_application.services.CustomerServices;
import com.revature.restaurant_application.services.MenuServices;
import com.revature.restaurant_application.services.OrderServices;
import com.revature.restaurant_application.web.servlets.CreditCardServlet;
import com.revature.restaurant_application.web.servlets.CustomerServlet;
import com.revature.restaurant_application.web.servlets.MenuServlet;
import com.revature.restaurant_application.web.servlets.OrderServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ObjectMapper mapper = new ObjectMapper();
        CreditCardDao creditCardDao = new CreditCardDao();
        OrderDao orderDao = new OrderDao();
        MenuDao menuDao = new MenuDao();
        CustomerDao customerDao = new CustomerDao();

        CustomerServices customerServices = new CustomerServices(customerDao);
        OrderServices orderServices = new OrderServices(orderDao);
        MenuServices menuServices = new MenuServices(menuDao);
        CreditCardServices creditCardServices = new CreditCardServices(creditCardDao);



        CustomerServlet customerServlet = new CustomerServlet(customerServices, mapper);
        OrderServlet orderServlet = new OrderServlet(orderServices, mapper);
        CreditCardServlet creditCardServlet = new CreditCardServlet(creditCardServices,mapper);
        MenuServlet menuServlet = new MenuServlet(menuServices, mapper);


        ServletContext context = sce.getServletContext();
        context.addServlet("CustomerServlet", customerServlet).addMapping("/customer/*");
        context.addServlet("OrderServlet", orderServlet).addMapping("/order/*");
        context.addServlet("CreditCardServlet", creditCardServlet).addMapping("/Credit/*");
        context.addServlet("MenuServlet", menuServlet).addMapping("/menu/*");
;




    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
