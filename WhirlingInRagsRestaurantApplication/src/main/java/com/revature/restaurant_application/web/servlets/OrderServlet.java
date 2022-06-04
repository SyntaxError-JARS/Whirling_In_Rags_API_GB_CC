package com.revature.restaurant_application.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.restaurant_application.exceptions.InvalidRequestException;
import com.revature.restaurant_application.exceptions.ResourcePersistenceException;

import com.revature.restaurant_application.models.OrderData;
import com.revature.restaurant_application.services.CustomerServices;
import com.revature.restaurant_application.services.OrderServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class OrderServlet extends HttpServlet {
    private final OrderServices orderServices;


    private final ObjectMapper mapper;

    public OrderServlet(OrderServices orderServices, ObjectMapper mapper){
        this.orderServices = orderServices;
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

        String orderbydata = req.getParameter("orderDate");
        if(req.getParameter("orderDate") != null){
            OrderData orderData;
            try{
                resp.getWriter().write("Grabbing the Customer! \n");
                orderData = orderServices.readByID(orderbydata);
            }catch (ResourcePersistenceException e){
                resp.setStatus(404);
                resp.getWriter().write(e.getMessage());
                return;
            }

            String payload = mapper.writeValueAsString(orderData);
            resp.getWriter().write(payload);
            resp.setStatus(200);
            return;
        }

        ArrayList<OrderData> orderData = orderServices.readAllOrders();
        String payload = mapper.writeValueAsString(orderData);
        resp.getWriter().write(payload);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        try {
            OrderData orderData = mapper.readValue(req.getInputStream(), OrderData.class);
            OrderData newOrder = orderServices.create(orderData);

            String payload = mapper.writeValueAsString(newOrder);
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

        try {

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
        if(req.getParameter("id") == null){

            resp.getWriter().write("Sample output");
            resp.setStatus(401);
            return;
        }
        String id = req.getParameter("id");
        try {
            //OrderData orderData = mapper.readValue(req.getInputStream(), OrderData.class);
            orderServices.delete(id);

            resp.getWriter().write("Deleted order of the Database");
            resp.setStatus(200);
            return;
        }catch (InvalidRequestException | ResourcePersistenceException e) {
            resp.setStatus(404);
            resp.getWriter().write(e.getMessage());
        }
    }
}
