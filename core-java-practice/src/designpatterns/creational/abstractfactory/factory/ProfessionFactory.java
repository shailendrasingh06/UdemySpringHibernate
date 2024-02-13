package designpatterns.creational.abstractfactory.factory;

import designpatterns.creational.abstractfactory.AbstractFactory;
import designpatterns.creational.abstractfactory.Profession;
import designpatterns.creational.abstractfactory.professions.Doctor;
import designpatterns.creational.abstractfactory.professions.Engineer;
import designpatterns.creational.abstractfactory.professions.Teacher;

public class ProfessionFactory extends AbstractFactory {

    @Override
    protected Profession getProfession(String profession) throws NullPointerException{
        if (profession.equalsIgnoreCase("Doctor"))
            return new Doctor();
        else if (profession.equalsIgnoreCase("Engineer"))
            return new Engineer();
        else if (profession.equalsIgnoreCase("Doctor"))
            return new Teacher();
        else {
            throw new NullPointerException("No profession found for this type.");
        }
    }
}
