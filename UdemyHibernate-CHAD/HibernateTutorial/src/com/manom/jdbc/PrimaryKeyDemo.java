package com.manom.jdbc;

import com.manom.jdbc.entity.Student;
import com.manom.jdbc.utils.DateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {


            Student stdobj = new Student("Apple", "Singh", DateUtil.parseDate("16/12/1997"), "Apple@gmail.com");
            Student stdobj2 = new Student("Mango", "Singh",DateUtil.parseDate("16/12/1997"), "Mango@gmail.com");
            Student stdobj3 = new Student("Kiwi", "Singh",DateUtil.parseDate("16/12/1997"), "Kiwi@gmail.com");

            session.beginTransaction();
            System.out.println("Saving students data....");
            session.save(stdobj);
            session.save(stdobj2);
            session.save(stdobj3);
            session.getTransaction().commit();

            factory.close();
            System.out.println("Saved student data successfully.");
        }catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

}

