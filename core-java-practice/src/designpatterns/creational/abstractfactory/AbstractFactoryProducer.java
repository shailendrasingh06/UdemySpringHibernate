package designpatterns.creational.abstractfactory;

import designpatterns.creational.abstractfactory.factory.ProfessionFactory;
import designpatterns.creational.abstractfactory.factory.TraineeProfessionAbstractFactory;

public class AbstractFactoryProducer {

    public  static AbstractFactory getFactory(boolean isTrainee){
        if (isTrainee)
            return new TraineeProfessionAbstractFactory();
        else
            return new ProfessionFactory();
    }
}
