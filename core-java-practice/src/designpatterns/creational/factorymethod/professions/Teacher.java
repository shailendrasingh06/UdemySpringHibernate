package designpatterns.creational.factorymethod.professions;

import designpatterns.creational.factorymethod.Profession;

public class Teacher implements Profession {
    @Override
    public void print() {
        System.out.println("I am Teacher..");
    }
}
