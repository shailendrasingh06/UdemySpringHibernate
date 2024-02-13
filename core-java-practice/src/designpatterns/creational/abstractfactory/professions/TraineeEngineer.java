package designpatterns.creational.abstractfactory.professions;

import designpatterns.creational.abstractfactory.Profession;

public class TraineeEngineer implements Profession {
    @Override
    public void print() {
        System.out.println("I am a Trainee Engineer..");
    }
}
