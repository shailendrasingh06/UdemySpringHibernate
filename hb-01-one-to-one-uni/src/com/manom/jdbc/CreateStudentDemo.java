package com.manom.jdbc;

import com.manom.jdbc.entity.Student;
import com.manom.jdbc.utils.DateUtil;
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

            String dateOfBirth = "16/12/1997";

            Student stdobj = new Student("Manom", "Singh", DateUtil.parseDate(dateOfBirth), "shailendra@gmail.com");
            Student stdobj2 = new Student("Ujala", "Singh",DateUtil.parseDate(dateOfBirth), "Ujala@gmail.com");
            Student stdobj3 = new Student("Ujala", "Singh",DateUtil.parseDate(dateOfBirth), "Ujala@gmail.com");


            session.beginTransaction();
            session.save(stdobj2);
            session.save(stdobj);
            session.getTransaction().commit();
//            Connection conn = DriverManager.getConnection(jdbcURl, user, pass);
//            System.out.println("Connected successfully with the DB!!!");
            factory.close();
        }catch (Exception e) {
            e.printStackTrace();

        }
    }

}
