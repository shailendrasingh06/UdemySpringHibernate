package com.manom.jdbc;

import com.manom.jdbc.entity.Course;
import com.manom.jdbc.entity.Instructor;
import com.manom.jdbc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    private static Transaction tx;

    public static void main(String[] args) {
//        String jdbcURl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
//        String user="hbstudent";
//        String pass="hbstudent";
//        System.out.println("Connecting to databse - " + jdbcURl);

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            Instructor obj1 = new Instructor("Ujala","Singh","Ujala@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("TechUjala","Ultimate Rotdu");

            Course course1 = new Course("MCA");

            //associate the objects
            obj1.setInstructorDetail(instructorDetail);

            // save the Instructor object into db
            tx = session.beginTransaction();
            System.out.println("Saving Instructor object into DB....");
            session.save(obj1);
            tx.commit();
            System.out.println("Done saving instructor object.");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
    }

}
