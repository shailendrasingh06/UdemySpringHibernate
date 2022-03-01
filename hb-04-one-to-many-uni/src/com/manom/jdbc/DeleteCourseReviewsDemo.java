package com.manom.jdbc;

import com.manom.jdbc.entity.Course;
import com.manom.jdbc.entity.Instructor;
import com.manom.jdbc.entity.InstructorDetail;
import com.manom.jdbc.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteCourseReviewsDemo {

    private static Transaction tx;

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            int id = 10;

            // start the transactions
            tx = session.beginTransaction();

            //get the Course from the db

            Course course = session.get(Course.class, id);

   // delete the course
            session.delete(course);
            //commit the transaction
            tx.commit();

            System.out.println("Done deleting the course");

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
    }

}
