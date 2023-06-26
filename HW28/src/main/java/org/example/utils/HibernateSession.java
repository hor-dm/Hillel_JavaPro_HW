package org.example.utils;

import org.example.entities.StudentEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class HibernateSession {

    private final static String DRIVER = "org.postgresql.Driver";
    private final static String URL = "jdbc:postgresql://localhost:5432/student";
    private final static String USER = "";
    private final static String PASSWORD = "";
    private final static String SHOW_SQL = "true";
    private final static String DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
    private final static String CURRENT_SESSION_CONTEXT_CLASS = "thread";
    private final static String HBM2DDL_AUTO = "update";
    private final static String CONNECTION_PROVIDER = "org.hibernate.hikaricp.internal.HikariCPConnectionProvider";

    private final static List<Class> CLASSES = List.of(StudentEntity.class);

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        Configuration configuration = new Configuration();

        for (Class c : CLASSES) {
            configuration.addAnnotatedClass(c);
        }

        configuration.setProperty(Environment.DRIVER, DRIVER)
                .setProperty(Environment.URL, URL)
                .setProperty(Environment.USER, USER)
                .setProperty(Environment.PASS, PASSWORD)
                .setProperty(Environment.SHOW_SQL, SHOW_SQL)
                .setProperty(Environment.DIALECT, DIALECT)
                .setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, CURRENT_SESSION_CONTEXT_CLASS)
                .setProperty(Environment.HBM2DDL_AUTO, HBM2DDL_AUTO)
                .setProperty(Environment.CONNECTION_PROVIDER, CONNECTION_PROVIDER);

        ServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
}
