package org.example.dao;

import jakarta.persistence.NoResultException;
import org.example.utils.HibernateSession;
import org.example.entities.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDao {

    private final static SessionFactory sessionFactory = HibernateSession.getSessionFactory();

    public static void addUser(String name, String email) {
        System.out.println("\naddUser - persist(" + name + ")");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(new StudentEntity(name, email));
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteById(Integer id) {
        System.out.println("\ndelete(Integer id) - id = " + id);
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        StudentEntity student = session.get(StudentEntity.class, id);
        session.remove(student);

        session.getTransaction().commit();
        session.close();
    }

    public static void updateById(Integer id, String newName, String newEmail) {
        System.out.println("\nupdate(Integer id) - id = " + id);
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        StudentEntity student = session.get(StudentEntity.class, id);
        if (!newName.isBlank()) student.setName(newName);
        if (!newEmail.isBlank()) student.setEmail(newEmail);

        session.getTransaction().commit();
        session.close();
    }

    public static void getAll() {
        System.out.println("\ngetAll()");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session
                .createQuery("select s from StudentEntity s order by id", StudentEntity.class)
                .list()
                .forEach(System.out::println);

        session.getTransaction().commit();
        session.close();
    }

    public static void getByID(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        System.out.println("\ngetByID - id = " + id);

        try {
            StudentEntity student = session
                    .createQuery("select s from StudentEntity s where s.id = :id", StudentEntity.class)
                    .setParameter("id", id).getSingleResult();
            System.out.println(student);
        } catch (NoResultException e) {
            System.out.println("no student with id = " + id);
        }

        session.getTransaction().commit();
        session.close();
    }

    public static void getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        System.out.println("\ngetByName(String name) - name = " + name);

        List<StudentEntity> list = session
                .createQuery("select s from StudentEntity s where s.name = :name", StudentEntity.class)
                .setParameter("name", name)
                .list();
        if (list.isEmpty()) {
            System.out.println("no students with name " + name);
        } else {
            list.forEach(System.out::println);
        }

        session.getTransaction().commit();
        session.close();
    }
}
