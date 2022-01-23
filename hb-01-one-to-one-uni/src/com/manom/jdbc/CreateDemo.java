package com.manom.jdbc;

import com.manom.jdbc.entity.Instructor;
import com.manom.jdbc.entity.InstructorDetail;
import com.manom.jdbc.entity.Student;
import com.manom.jdbc.utils.DateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {
//        String jdbcURl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
//        String user="hbstudent";
//        String pass="hbstudent";
//        System.out.println("Connecting to databse - " + jdbcURl);

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            //create the objects

//            Instructor obj1 = new Instructor("shailendra","Singh","shailendra@gmail.com");
//
//            InstructorDetail instructorDetail = new InstructorDetail("TechShail","Ultimate learner");

            Instructor obj1 = new Instructor("Ujala","Singh","Ujala@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("TechUjala","Ultimate Rotdu");

            //associate the objects
            obj1.setInstructorDetail(instructorDetail);

            // save the Instructor object into db
            session.beginTransaction();
            System.out.println("Saving Instructor object into DB....");
            session.save(obj1);
            session.getTransaction().commit();
            System.out.println("Done saving instructor object.");
//            Connection conn = DriverManager.getConnection(jdbcURl, user, pass);
//            System.out.println("Connected successfully with the DB!!!");
            factory.close();
        }catch (Exception e) {
            e.printStackTrace();

        }
    }

}
