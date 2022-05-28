package com.revature.restaurant_application.util;

import com.revature.restaurant_application.models.CreditCardData;
import com.revature.restaurant_application.models.CustomerData;
import com.revature.restaurant_application.models.MenuData;
import com.revature.restaurant_application.models.OrderData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;

    public static Session getSession() throws IOException {
        if(sessionFactory == null){
            Configuration configuration = new Configuration();




            configuration.addAnnotatedClass(CreditCardData.class);
            configuration.addAnnotatedClass(CustomerData.class);
            configuration.addAnnotatedClass(MenuData.class);
            configuration.addAnnotatedClass(OrderData.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        if(session == null){
            session = sessionFactory.openSession();
        }

        return session;
    }

    public static void closeSession(){
        session.close();
        session = null;
    }

}
