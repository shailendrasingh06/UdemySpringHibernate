package designpatterns.creational.abstractfactory.professions;

import designpatterns.creational.abstractfactory.Profession;

public class Teacher implements Profession {
    @Override
    public void print() {
        System.out.println("I am Teacher..");
    }
}
