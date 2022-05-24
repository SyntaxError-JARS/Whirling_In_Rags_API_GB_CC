package com.revature.restaurant_application.daos;

import com.revature.restaurant_application.models.CreditCardData;
import com.revature.restaurant_application.models.CustomerData;
import com.revature.restaurant_application.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerDao implements Crudable<CustomerData>{
    @Override
    public CustomerData Create(CustomerData newCustomerData) {
        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(newCustomerData);
            return newCustomerData;
        }catch (HibernateException | IOException e){
            e.printStackTrace();
            return null;
        }finally {
            HibernateUtil.closeSession();
        }

    }

    @Override
    public ArrayList findAll() throws IOException {
        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            ArrayList<CustomerData> customers = (ArrayList<CustomerData>) session.createQuery("FROM Customer").list();
            return customers;
        }catch (HibernateException | IOException e){
            e.printStackTrace();
            return null;
        }finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public CustomerData findByID(String id) {
        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            //CustomerData customer = session.get(CustomerData.class, username);
            transaction.commit();
            return null;
        }catch (HibernateException | IOException e){
            e.printStackTrace();
            return null;
        }finally {
            HibernateUtil.closeSession();
        }
        return null;
    }

    @Override
    public boolean update(CustomerData customerData) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
