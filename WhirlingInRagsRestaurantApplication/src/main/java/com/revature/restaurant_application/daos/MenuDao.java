package com.revature.restaurant_application.daos;

import com.revature.restaurant_application.models.CreditCardData;
import com.revature.restaurant_application.models.MenuData;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;

public class MenuDao  {

   /* @Override
    public MenuData create(MenuData newMenuData) {


        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(newMenuData);
            return newMenuData;


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
            ArrayList<MenuData> menu = (ArrayList<MenuData>) session.createQuery("FROM MenuData").list();
            return menu;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();


        }

        @Override
        public MenuData findById (String itemName){

            try {
                    Session session = HibernateUtil.getSession();
                    Transaction transaction = session.beginTransaction();
                    MenuData menu = session.get(MenuData.class, id);
                    return menu;
                }catch (HibernateException | IOException e) {
                    e.printStackTrace();
                    return null;
                }finally {
                    HibernateUtil.closeSession();


                }
            }


            @Override
            public boolean update (MenuData updatedMenuData){

                try {
                    Session session = HibernateUtil.getSession();
                    Transaction transaction = session.beginTransaction();
                    session.merge(updatedMenuData);
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
            public boolean delete (String itemName){
                try {
                    Session session = HibernateUtil.getSession();
                    Transaction transaction = session.beginTransaction();
                    session.remove(itemName);
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

    }
    */
    }

