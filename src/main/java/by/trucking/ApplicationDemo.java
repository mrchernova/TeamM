package by.trucking;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import by.trucking.dao.DAO;
import by.trucking.dao.EngineDAO;
import by.trucking.model.Engine;


public class ApplicationDemo {
    public static void main(String[] args) {

        SessionFactory factory = null;

        try {
            factory = new Configuration().configure().buildSessionFactory();
            DAO<Engine, String> engineDAO = new EngineDAO(factory);

            final Engine engine = new Engine();
            engine.setModel("engine_model_04");
            engine.setPower(12344);

            engineDAO.create(engine);

//            final Engine result = engineDAO.read("engine_model_03");
//            System.out.println("Created : " + result);
//            System.out.println();
//
//            result.setPower(54321);
//            engineDAO.update(result);
//
//            final Engine update = engineDAO.read("engine_model_03");
//            System.out.println("Updated : " + update);
//            System.out.println();
//
//            engineDAO.delete(new Engine("engine_model_03", 54321));
//
//            System.out.println("Deleted(empty obj) : " + engineDAO.read("engine_model_03"));


        }catch (NoClassDefFoundError e){
            System.out.println("------------------");
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}