package com.manom.jdbc;

import com.manom.jdbc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {
//        String jdbcURl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
//        String user="hbstudent";
//        String pass="hbstudent";
//        System.out.println("Connecting to databse - " + jdbcURl);

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            Student stdobj = new Student("Manom", "Singh", "shailendra@gmail.com");
            Student stdobj2 = new Student("Ujala", "Singh", "Ujala@gmail.com");


            session.beginTransaction();
            session.save(stdobj2);
            session.getTransaction().commit();
//            Connection conn = DriverManager.getConnection(jdbcURl, user, pass);
//            System.out.println("Connected successfully with the DB!!!");
            factory.close();
        }catch (Exception e) {
            e.printStackTrace();

        }
    }

}
