package com.revature.restaurant_application.daos;

import com.revature.restaurant_application.models.CreditCardData;
import com.revature.restaurant_application.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;


public class CreditCardDao implements Crudable<CreditCardData>{

@Override
        public CreditCardData Create(CreditCardData newCreditCardData) {


    try {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(newCreditCardData);
        return newCreditCardData;


    } catch (HibernateException | IOException e) {
        e.printStackTrace();
        return null;
    } finally {
        HibernateUtil.closeSession();
    }

}



    @Override
        public ArrayList findAll() throws IOException {


        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            ArrayList<CreditCardData> creditCard = (ArrayList<CreditCardData>) session.createQuery("FROM CreditCardData").list();
            return creditCard;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();


        }
    }
        @Override
        public CreditCardData findByID(String username){
                try {
                    Session session = HibernateUtil.getSession();
                    Transaction transaction = session.beginTransaction();
                    CreditCardData credit = session.get(CreditCardData.class, username);
                    return credit;
                }catch (HibernateException | IOException e) {
                    e.printStackTrace();
                    return null;
                }finally {
                    HibernateUtil.closeSession();


                }
            }



                @Override
                public boolean update (CreditCardData updatedCreditCard){

                    try {
                        Session session = HibernateUtil.getSession();
                        Transaction transaction = session.beginTransaction();
                        session.merge(updatedCreditCard);
                        transaction.commit();
                        return true;
                    } catch (HibernateException | IOException e) {
                        e.printStackTrace();
                        return false;
                    } finally {
                        HibernateUtil.closeSession();
                    }
                }

                @Override
                public boolean delete (String username){
                    try {
                        Session session = HibernateUtil.getSession();
                        Transaction transaction = session.beginTransaction();
                        session.remove(username);
                        transaction.commit();
                        return true;
                    } catch (HibernateException | IOException e) {
                        e.printStackTrace();
                        return false;
                    } finally {
                        HibernateUtil.closeSession();
                    }
                }






}

