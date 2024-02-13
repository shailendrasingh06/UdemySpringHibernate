package designpatterns.creational.factorymethod.professions;

import designpatterns.creational.factorymethod.Profession;

public class Doctor implements Profession {
    @Override
    public void print() {
        System.out.println("I am Doctor");
    }
}
