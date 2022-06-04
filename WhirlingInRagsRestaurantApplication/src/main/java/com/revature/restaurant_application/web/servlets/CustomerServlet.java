package com.revature.restaurant_application.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.restaurant_application.exceptions.InvalidRequestException;
import com.revature.restaurant_application.exceptions.ResourcePersistenceException;
import com.revature.restaurant_application.models.CustomerData;
import com.revature.restaurant_application.services.CustomerServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerServlet extends HttpServlet {

    private final CustomerServices customerServices;

    private final ObjectMapper mapper;

    public CustomerServlet(CustomerServices customerServices, ObjectMapper mapper){
        this.customerServices = customerServices;
        this.mapper = mapper;
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        if(req.getParameter("username") != null){
            CustomerData customerData;
            try{
                resp.getWriter().write("Grabbing the Customer! \n");
                customerData = customerServices.readByID(req.getParameter("username"));
            }catch (ResourcePersistenceException e){
                resp.setStatus(404);
                resp.getWriter().write(e.getMessage());
                return;
            }

            String payload = mapper.writeValueAsString(customerData);
            resp.getWriter().write(payload);
            resp.setStatus(200);
            return;
        }

        ArrayList<CustomerData> customerData = customerServices.readAll();
        String payload = mapper.writeValueAsString(customerData);
        resp.getWriter().write(payload);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        try {
            CustomerData customerData = mapper.readValue(req.getInputStream(), CustomerData.class);
            CustomerData newCustomerData = customerServices.CreateCustomer(customerData);

            String payload = mapper.writeValueAsString(newCustomerData);
            resp.getWriter().write(payload);
            resp.setStatus(200);
            return;
        }catch (InvalidRequestException | ResourcePersistenceException e) {
            resp.setStatus(404);
            resp.getWriter().write(e.getMessage());
        }
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        if(req.getParameter("balance") == null){

            resp.getWriter().write("Sample output");
            resp.setStatus(401);
            return;
        }
        String balance = req.getParameter("balance");
        try {
            //CustomerData customerData = mapper.readValue(req.getInputStream(), CustomerData.class);
            customerServices.update2(balance);
            resp.getWriter().write("Order amount has been added to your balance.");
            resp.setStatus(200);
            return;
        }catch (InvalidRequestException | ResourcePersistenceException e) {
            resp.setStatus(404);
            resp.getWriter().write(e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        if(req.getParameter("username") == null){

            resp.getWriter().write("Sample output");
            resp.setStatus(401);
            return;
        }

        String userName = req.getParameter("username");

        try {
            //CustomerData customerData = mapper.readValue(req.getInputStream(), CustomerData.class);
            customerServices.delete(userName);
            //String payload = mapper.writeValueAsString(deletedCustomerData);
            resp.getWriter().write("User Account deleted from the database");
            resp.setStatus(200);
        }catch (InvalidRequestException | ResourcePersistenceException e) {
            resp.setStatus(404);
            resp.getWriter().write(e.getMessage());
        }
    }
}
