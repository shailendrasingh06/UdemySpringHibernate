package designpatterns.creational.abstractfactory.professions;

import designpatterns.creational.abstractfactory.Profession;

public class Engineer implements Profession {
    @Override
    public void print() {
        System.out.println("I am an Engineer..");
    }
}
