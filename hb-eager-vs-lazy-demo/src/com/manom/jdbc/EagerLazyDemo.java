package com.manom.jdbc;

import com.manom.jdbc.entity.Course;
import com.manom.jdbc.entity.Instructor;
import com.manom.jdbc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

    private static Transaction tx;

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            int id = 1;

            // start the transactions
            tx = session.beginTransaction();

            //get the instructor from the db

            Instructor instructor = session.get(Instructor.class, id);

            System.out.println("shail : " + instructor.getFirst_name());

            System.out.println("shail : " + "Courses" + instructor.getCourses());

            tx.commit();
            //close the session to break the flow LAZY loading
            session.close();


            System.out.println("shail : " + "Courses" + instructor.getCourses());
            //commit the transaction


        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
            factory.close();
        }
    }

}
