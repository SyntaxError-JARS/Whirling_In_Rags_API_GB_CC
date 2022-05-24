package com.revature.restaurant_application.services;

import com.revature.restaurant_application.daos.OrderDao;
import com.revature.restaurant_application.exceptions.InvalidRequestException;
import com.revature.restaurant_application.exceptions.ResourcePersistenceException;
import com.revature.restaurant_application.models.OrderData;

import java.io.IOException;
import java.util.ArrayList;

public class OrderServices {

    private OrderDao orderDao;

    public OrderServices(OrderDao orderDao){
        this.orderDao = orderDao;
    }

    public OrderData create(OrderData newOrderData){

        if(!orderValidation(newOrderData)){
            throw new InvalidRequestException("Customer input was not Validated, either empty Strings or null values");
        }


        OrderData persistedOrder = orderDao.Create(newOrderData);

        if(persistedOrder == null){
            throw new ResourcePersistenceException("Order was not persisted to the database");
        }



        return newOrderData;
    }

    public ArrayList<OrderData> readAllOrders() throws IOException {
        ArrayList<OrderData> orders = orderDao.findAll();
        return orders;
    }

    public OrderData update(OrderData updatedOrder){
        if(!orderDao.update(updatedOrder)){
            return null;
        }
        return updatedOrder;
    }

    public boolean delete(String id){
        return orderDao.delete(id);
    }


    public boolean orderValidation(OrderData orderData){
        if(orderData.getMenuItem() == null || orderData.getMenuItem().trim().equals("")) return false;
        if(orderData.getOrderDate()== null || orderData.getOrderDate().trim().equals("")) return false;
        if(orderData.getUsername() == null || orderData.getUsername().trim().equals("")) return false;
        
        return true;
    }
}
