package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AppDQL {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // HQL yazıyoruz Hibernate Query Language
            // SELECT * FROM student demek ile aynı
            //List<Student> students = session.createQuery("from Student ").getResultList();

            // SELECT * FROM student WHERE student.firstName = 'Burhan'
            // List<Student> students = session.createQuery("from Student s where s.firstName = 'Burhan'").getResultList();

            // SELECT * FROM student as s ORDER BY s.firstName
            //List<Student> students = session.createQuery("from Student s ORDER BY s.firstName").getResultList();

            /*  Select s.firstName
                From student as s
                Group by s.firstName */
            List<String> names = session.createQuery("select s.firstName" +
                            " from Student s" +
                            " GROUP BY s.firstName")
                    .getResultList();

            for (String name : names
            ) {
                System.out.println(name);
            }

//            for (Student student : students
//            ) {
//                System.out.println(student.getFirstName());
//            }

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
