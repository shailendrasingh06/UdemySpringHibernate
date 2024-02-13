package com.manom.hashcodeandequalscontract;

public class Student {

/*    if this contract is not followed properly then we will face issue while using hashing
      structures in java  */
    private int rollno;
    private String name;
    private int contact;

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    @Override
    public int hashCode() {
        return this.rollno;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.rollno == ((Student) obj).rollno)
            return true;
        else
            return false;
    }
}
