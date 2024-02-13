package com.manom.jdbc;

import com.manom.jdbc.entity.Instructor;
import com.manom.jdbc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

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
            Instructor obj1 = new Instructor("Ujala","Singh","Ujala@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("TechUjala","Ultimate Rotdu");

            //associate the objects
            obj1.setInstructorDetail(instructorDetail);

            int userId = 2;
            // create Query to delete a record from the table
            session.beginTransaction();

            Instructor getIntructor = session.get(Instructor.class, userId);
            System.out.println("Searching for user with id = ...." + userId);

            if (getIntructor != null) {
                System.out.println("Found user and now deleting it ...");
                session.delete(getIntructor);    ////cascade does work with this method
            }

//            session.createQuery("delete from Instructor i where i.id = 1").executeUpdate();   //cascade does not work with this
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
