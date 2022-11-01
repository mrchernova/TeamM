package by.trucking;

import by.trucking.model.Engine;
import by.trucking.model.Role;
import by.trucking.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.SQLException;


public class RunnerUser {
    private static SessionFactory factory = null;

    public static void main(String[] args) throws SQLException {

        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            for (int i = 0; i < 3; i++) {
                User u = new User();
                u.setLogin("user_" + i);
                u.setPassword("1111");
                u.setRole(Role.getByOrdinal(i));
                System.out.println("saving " + u);
                session.persist(u);

            }
            transaction.commit();
            System.out.println("all engines saved");
        }
    }

    private static SessionFactory getSessionFactory() {
        if (factory == null) {
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");

          ServiceRegistry serReg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            factory = config.buildSessionFactory();
        }
        return factory;
    }
}