package com.manom.jdbc;

import com.manom.jdbc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

//            List<Student> student1 = session.createQuery("from Student s where s.first_name = 'Ujala'").list();
//            System.out.println("Here is the details for student 'Piny': ");
//            displayStudents(student1);
//            //try to delete the student data
//            Student studentDele = session.get(Student.class, student1.get(0).getId());
//            session.delete(studentDele);
            session.createQuery("delete from Student s where s.id = 2").executeUpdate();
            session.getTransaction().commit();
            System.out.println("successfully deleted all the data from the table..");
            factory.close();
            System.out.println("Fetched student information successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void displayStudents (List< Student > studentList) {
        int i = 1;
        for (Student stud : studentList) {
            System.out.println("Data of student " + i + " : " + stud.toString());
            i++;
        }
    }
}

