package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateSessionFactory {

    @Autowired
    private static SessionFactory INSTANCE = null;

    public static SessionFactory getInstance(){
        if (INSTANCE == null){
            INSTANCE = getSessionFactory();
        }
        return INSTANCE;
    }

    private static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure();
        ConfigurationUtil.loadEntityClasses(configuration);

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
