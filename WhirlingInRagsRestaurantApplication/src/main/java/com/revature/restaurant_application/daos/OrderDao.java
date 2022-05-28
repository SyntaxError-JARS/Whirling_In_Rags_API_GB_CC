package com.revature.restaurant_application.daos;

import com.revature.restaurant_application.models.OrderData;
import com.revature.restaurant_application.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;

public class OrderDao implements Crudable<OrderData>{

    @Override
    public OrderData Create(OrderData newOrderData) {
        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(newOrderData);
            transaction.commit();
            return newOrderData;
        }catch (HibernateException | IOException e){
            e.printStackTrace();
            return null;
        }finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public ArrayList<OrderData> findAll() throws IOException {
        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            ArrayList<OrderData> orders = (ArrayList<OrderData>) session.createQuery("FROM Order");
            transaction.commit();
            return orders;
        }catch (HibernateException | IOException e){
            e.printStackTrace();
            return null;
        }finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public OrderData findByID(String id) {
        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            OrderData order = session.get(OrderData.class, id );
            transaction.commit();
            return order;
        }catch (HibernateException | IOException e){
            e.printStackTrace();
            return null;
        }finally {
            HibernateUtil.closeSession();
        }
    }

    @Override
    public boolean update(OrderData updatedOrder) {
        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.merge(updatedOrder);
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
    public boolean delete(String id) {
        try{
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(id);
            transaction.commit();
            return true;
        }catch (HibernateException | IOException e){
            e.printStackTrace();
            return false;
        }finally {
            HibernateUtil.closeSession();
        }
    }
}
