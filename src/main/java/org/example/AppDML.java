package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppDML {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try {
            session.beginTransaction();


//            Student student = new Student();
//            student.setId(105);
//            student.setFirstName("Abdulrezzak");

//             INSERT INTO student(id,firstName) value (105,'Abdulrezzak')
//             session.save(student);


            // UPDATE student SET firstName = 'Yenes2' where id = 104
            Student student1 = session.get(Student.class, 104);
            student1.setFirstName("Yenes2");


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
