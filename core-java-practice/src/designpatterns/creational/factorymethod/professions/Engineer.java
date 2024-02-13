package designpatterns.creational.factorymethod.professions;

import designpatterns.creational.factorymethod.Profession;

public class Engineer implements Profession {
    @Override
    public void print() {
        System.out.println("I am an Engineer..");
    }
}
