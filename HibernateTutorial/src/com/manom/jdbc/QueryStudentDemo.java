package com.manom.jdbc;

import com.manom.jdbc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            System.out.println("Fetching all students data....");
            List<Student> studentList = session.createQuery("from Student").getResultList();
            //Update the last_name of the
            session.createQuery("update Student set last_name='Yadav'").executeUpdate();

            //display all the fetched students data
            displayStudents(studentList);
            //Fetching value using where clause
            List<Student> student1 = session.createQuery("from Student s where s.first_name = 'Piny'").list();

            System.out.println("Here is the details for student 'Piny': ");
            displayStudents(student1);
            session.getTransaction().commit();
            factory.close();
            System.out.println("Fetched student information successfully.");
        }catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    private static void displayStudents(List<Student> studentList) {
        int i = 1;
        for(Student stud : studentList) {
            System.out.println("Data of student " + i + " : "+ stud.toString());
            i++;
        }
    }
}
