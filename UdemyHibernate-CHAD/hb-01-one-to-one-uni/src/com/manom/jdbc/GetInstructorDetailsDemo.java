package com.manom.jdbc;

import com.manom.jdbc.entity.Instructor;
import com.manom.jdbc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailsDemo {

    public static void main(String[] args) {
//create the session factory using the provided configuration file
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // get the current session from Session Factory
        Session session = sessionFactory.getCurrentSession();
        try{

            session.beginTransaction();
            int iDetailID = 2999;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, iDetailID);

            if (instructorDetail !=null) {
                System.out.println("found the instructor with ID = " + instructorDetail.getId());
                // print the fetched instructor detail
                System.out.println(instructorDetail.getInstructor().toString());
            }
            session.getTransaction().commit();
        }catch ( Exception e){
            System.out.println("Some error occurred with in the fetching the Instructor Details...");
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
