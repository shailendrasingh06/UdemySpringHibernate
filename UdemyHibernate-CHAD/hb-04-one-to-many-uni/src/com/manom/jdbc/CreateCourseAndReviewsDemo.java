package com.manom.jdbc;

import com.manom.jdbc.entity.Course;
import com.manom.jdbc.entity.Instructor;
import com.manom.jdbc.entity.InstructorDetail;
import com.manom.jdbc.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {

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
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            int id = 1;

            // starte the transactions
            tx = session.beginTransaction();

            //create a course

            Course tempCourse  = new Course("Spring: Learn Spring framework in a day");

            //create reviews

            Review review1 = new Review("Fantastic course, but it took me 1 year to complete this course");

            tempCourse.addReview(review1);

            //save the course

            session.save(tempCourse);

            //commit the transaction

            tx.commit();

            System.out.println("Done saving the course");

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
    }

}
