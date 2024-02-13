package designpatterns.creational.abstractfactory.professions;

import designpatterns.creational.abstractfactory.Profession;

public class Doctor implements Profession {
    @Override
    public void print() {
        System.out.println("I am Doctor");
    }
}
