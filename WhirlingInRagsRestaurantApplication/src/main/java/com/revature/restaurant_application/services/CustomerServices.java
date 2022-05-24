package com.revature.restaurant_application.services;

import com.revature.restaurant_application.daos.CustomerDao;
import com.revature.restaurant_application.exceptions.InvalidRequestException;
import com.revature.restaurant_application.exceptions.ResourcePersistenceException;
import com.revature.restaurant_application.models.CustomerData;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerServices {


    private CustomerDao customerDao;

    public CustomerServices(CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    public CustomerData CreateCustomer(CustomerData newCustomerData){

        if(!validateCustomer(newCustomerData)){
            throw new InvalidRequestException("Customer input was not Validated, either empty Strings or null values");
        }

        CustomerData persistedCustomer = customerDao.Create(newCustomerData);

        if(persistedCustomer == null){
            throw new ResourcePersistenceException("Customer was not persisted to the database");
        }

        return newCustomerData;
    }

    public ArrayList<CustomerData> readAll() throws IOException {
        ArrayList<CustomerData> customers = customerDao.findAll();
        return customers;
    }

    public CustomerData readByID(String username){
        CustomerData customer = customerDao.findByID(username);
        return customer;
    }

    public CustomerData update(CustomerData updatedCustomer){
        if(!customerDao.update((updatedCustomer))){
            return null;
        }

        return updatedCustomer;
    }

    public boolean delete(String username){
        return customerDao.delete(username);
    }

    public boolean validateCustomer(CustomerData newCustomerData){
        if(newCustomerData == null) return false;
        if(newCustomerData.getUsername() == null || newCustomerData.getUsername().trim().equals((""))) return false;
        if(newCustomerData.getFname() == null || newCustomerData.getFname().trim().equals((""))) return false;
        if(newCustomerData.getLname() == null || newCustomerData.getLname().trim().equals((""))) return false;
        if(newCustomerData.getPassword() == null || newCustomerData.getPassword().trim().equals((""))) return false;
        return true;

    }

}
