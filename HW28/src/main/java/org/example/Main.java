package org.example;


import org.example.dao.StudentDao;

public class Main {
    public static void main(String[] args) {

        StudentDao.addUser("Tom", "tom@gmail.com");
        StudentDao.addUser("Bob", "bob@gmail.com");
        StudentDao.addUser("Jack", "jack@gmail.com");
        StudentDao.addUser("Bill", "bill@gmail.com");

        StudentDao.getAll();

        StudentDao.getByName("Bob");

        StudentDao.getByName("John");

        StudentDao.getByID(2);

        StudentDao.getByID(134);

        StudentDao.updateById(1,"Alex","");

        StudentDao.updateById(2,"Phil","phil@gmail.com");

        StudentDao.updateById(3,"","newmail@gmail.com");

        StudentDao.updateById(4,"","");

        StudentDao.getAll();

        StudentDao.deleteById(1);
        StudentDao.getAll();
    }
}