package com.revature.restaurant_application.daos;

import com.revature.restaurant_application.models.CustomerData;
import com.revature.restaurant_application.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerDao implements Crudable<CustomerData>{
    @Override
    public CustomerData Create(CustomerData newCustomerData) {
        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(newCustomerData);
            transaction.commit();
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
            transaction.commit();
            return customers;
        }catch (HibernateException | IOException e){
            e.printStackTrace();
            return null;
        }finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public CustomerData findByID(String username) {
        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            CustomerData customer = session.get(CustomerData.class, username);
            transaction.commit();
            return customer;
        }catch (HibernateException | IOException e){
            e.printStackTrace();
            return null;
        }finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public boolean update(CustomerData updatedCustomer) {

        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.merge(updatedCustomer);
            transaction.commit();
            return true;
        }catch (HibernateException | IOException e){
            e.printStackTrace();
            return false;
        }finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public boolean delete(String username) {
        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            CustomerData customerData = session.load(CustomerData.class, username);
            session.remove(customerData);
            transaction.commit();
            return true;
        }catch (HibernateException | IOException e){
            e.printStackTrace();
            return false;
        }finally {
            HibernateUtil.closeSession();
        }
    }


    public CustomerData authenticateCustomer(String username, String password){

        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from CustomerData where username= :username and password= :password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            CustomerData customerData = (CustomerData) query.uniqueResult();
            transaction.commit();
            return customerData;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }

    }
}
