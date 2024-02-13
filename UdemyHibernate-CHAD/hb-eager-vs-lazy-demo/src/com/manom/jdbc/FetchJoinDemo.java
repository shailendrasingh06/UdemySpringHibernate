package com.manom.jdbc;

import com.manom.jdbc.entity.Course;
import com.manom.jdbc.entity.Instructor;
import com.manom.jdbc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchJoinDemo {

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
            //Using HQL

            Query<Instructor> instructorQuery = session.createQuery("select i from Instructor i "
                    +"JOIN FETCH i.courses "
                    +"where i.id = :instructorID", Instructor.class);

            //set the param
            instructorQuery.setParameter("instructorID", id);

            //execute the query

            Instructor instructor = (Instructor) instructorQuery.getSingleResult();


            System.out.println("shail : " + instructor.getFirst_name());

            System.out.println("shail : " + "Courses" + instructor.getCourses());

            tx.commit();
            //close the session to break the flow LAZY loading
            session.close();

            System.out.println("Session is closed now...");

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
