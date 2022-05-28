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
<<<<<<< HEAD



=======
            //Properties props = new Properties();

            //
//            ClassLoader loader = Thread.currentThread().getContextClassLoader();
//            props.load(loader.getResourceAsStream("hibernate.properties"));
//
//            configuration.setProperties(props);


            String url = System.getenv("SQLAZURECONNSTR_whirlinginragsDB");
            String username = System.getenv("DBNAME");
            String password = System.getenv("DBPASS");

            configuration.setProperty("hibernate.connection.url", url);
            configuration.setProperty("hibernate.connection.username", username);
            configuration.setProperty("hibernate.connection.password", password);
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
            configuration.setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
            configuration.setProperty("hibernate.show_sql", "true" );
            configuration.setProperty("hibernate.hbm2ddl.auto", "update" );

>>>>>>> cb3dc6719753870502237cc0b97e7f940aaae09e

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
