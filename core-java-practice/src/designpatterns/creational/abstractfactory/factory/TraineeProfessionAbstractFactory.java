package designpatterns.creational.abstractfactory.factory;

import designpatterns.creational.abstractfactory.AbstractFactory;
import designpatterns.creational.abstractfactory.Profession;
import designpatterns.creational.abstractfactory.professions.TraineeDoctor;
import designpatterns.creational.abstractfactory.professions.TraineeEngineer;
import designpatterns.creational.abstractfactory.professions.TraineeTeacher;

public class TraineeProfessionAbstractFactory extends AbstractFactory {
    @Override
    protected Profession getProfession(String profession) throws NullPointerException{
        if (profession.equalsIgnoreCase("Doctor"))
            return new TraineeDoctor();
        else if (profession.equalsIgnoreCase("Engineer"))
            return new TraineeEngineer();
        else if (profession.equalsIgnoreCase("Doctor"))
            return new TraineeTeacher();
        else {
            throw new NullPointerException("No profession found for this type.");
        }
    }
}
