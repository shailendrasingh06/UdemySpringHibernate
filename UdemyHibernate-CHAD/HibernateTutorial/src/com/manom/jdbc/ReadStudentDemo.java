package com.manom.jdbc;

import com.manom.jdbc.entity.Student;
import com.manom.jdbc.utils.DateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {


            // create student object
            Student stdobj = new Student("Piny", "Singh", DateUtil.parseDate("16/12/1997"),"Piny@gmail.com");
            //Begin Transaction
            session.beginTransaction();
            //save student object
            session.save(stdobj);
            System.out.println("Saving students with Id...." + stdobj.getId());
            session.save(stdobj);
            session.getTransaction().commit();
            System.out.println("Saved student data successfully.");

            //Get New Session
            Session session1 = factory.getCurrentSession();

            //Start Transaction

            session1.beginTransaction();

            //get the student object using session
            System.out.println("Fetching student data with ID " + stdobj.getId());
            Student student = session1.get(Student.class, stdobj.getId());
            System.out.println("Got the student with ID = " + student.getId());
            System.out.println(student.toString());
            session1.getTransaction().commit();
            factory.close();

        }catch (Exception e) {
            System.out.println(e.getMessage());

        }


    }

}
