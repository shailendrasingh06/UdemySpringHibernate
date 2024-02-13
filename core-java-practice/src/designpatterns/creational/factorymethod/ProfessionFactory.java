package designpatterns.creational.factorymethod;

import designpatterns.creational.factorymethod.professions.Doctor;
import designpatterns.creational.factorymethod.professions.Engineer;
import designpatterns.creational.factorymethod.professions.Teacher;

public class ProfessionFactory {

    public Profession getProfessionObject(String profession) throws NullPointerException{
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
