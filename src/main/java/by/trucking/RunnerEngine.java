package by.trucking;

import by.trucking.model.Engine;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

//import javax.imageio.spi.ServiceRegistry;
import org.hibernate.service.ServiceRegistry;
import java.sql.SQLException;


public class RunnerEngine {
    private static SessionFactory factory = null;

    public static void main(String[] args) throws SQLException {

        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            for (int i = 0; i < 3; i++) {
                Engine e = new Engine();
                e.setModel("model_" + i);
                e.setPower(500 + i + 3);
                System.out.println("saving " + e);
                session.persist(e);

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