package com.revature.restaurant_application.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.restaurant_application.exceptions.InvalidRequestException;
import com.revature.restaurant_application.exceptions.ResourcePersistenceException;

import com.revature.restaurant_application.models.OrderData;
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

        if(req.getParameter("username") != null){
            OrderData orderData;
            try{
                resp.getWriter().write("Grabbing the Customer! \n");
                orderData = orderServices.readByID("username");
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
        }catch (Exception e) {
            resp.setStatus(409);
            resp.getWriter().write(e.getMessage());
        }
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        try {
            OrderData orderData = mapper.readValue(req.getInputStream(), OrderData.class);
            OrderData updatedOrder = orderServices.update(orderData);

            String payload = mapper.writeValueAsString(updatedOrder);
            resp.getWriter().write(payload);
            resp.setStatus(200);
            return;
        }catch (InvalidRequestException | ResourcePersistenceException e) {
            resp.setStatus(404);
            resp.getWriter().write(e.getMessage());
        }catch (Exception e) {
            resp.setStatus(409);
            resp.getWriter().write(e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        try {
            OrderData orderData = mapper.readValue(req.getInputStream(), OrderData.class);
            boolean deletedOrder = orderServices.delete("id");

            String payload = mapper.writeValueAsString(deletedOrder);
            resp.getWriter().write(payload);
            resp.setStatus(200);
            return;
        }catch (InvalidRequestException | ResourcePersistenceException e) {
            resp.setStatus(404);
            resp.getWriter().write(e.getMessage());
        }catch (Exception e) {
            resp.setStatus(409);
            resp.getWriter().write(e.getMessage());
        }
    }
}
