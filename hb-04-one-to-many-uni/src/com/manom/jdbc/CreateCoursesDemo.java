package com.manom.jdbc;

import com.manom.jdbc.entity.Course;
import com.manom.jdbc.entity.Instructor;
import com.manom.jdbc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

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

            int id = 1;

            // starte the transactions
            tx = session.beginTransaction();

            //get the instructor from the db

            Instructor instructor = session.get(Instructor.class, id);
            //create some courses
            Course course1 = new Course("MCA");
            Course course2 = new Course("BCA");
            //add the courses in the instructor
            instructor.add(course1);
            instructor.add(course2);
            //save the courses
            session.save(course1);
            session.save(course2);
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
