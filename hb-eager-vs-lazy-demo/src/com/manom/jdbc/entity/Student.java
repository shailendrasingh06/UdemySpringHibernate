package com.manom.jdbc.entity;

import com.manom.jdbc.utils.DateUtil;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date date_of_birth;
    @Column(name = "email")
    private String email;

    public Student() {}

    public Student(String first_name, String last_name,Date date_of_birth, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.date_of_birth = date_of_birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", date_of_birth='" + DateUtil.formatDate(date_of_birth) + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    // SessionFactory: create Session Objects which reads the config file | heavy weight object | create only once in your application
    // Session: wraps a JDBC connection | Main object is used to save/retrieve objects |
}
