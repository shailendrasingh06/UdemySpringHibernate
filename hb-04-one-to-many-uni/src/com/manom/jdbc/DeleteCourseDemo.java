package com.manom.jdbc;

import com.manom.jdbc.entity.Course;
import com.manom.jdbc.entity.Instructor;
import com.manom.jdbc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

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
            int id = 10;

            //get the course from the db
           tx = session.beginTransaction();

            Course tempCourse = session.get(Course.class, id);

            if (tempCourse != null) {
                session.delete(tempCourse);
                System.out.println("Deleted course successfully");
            }
            //commit the transaction
            tx.commit();

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
    }

}
