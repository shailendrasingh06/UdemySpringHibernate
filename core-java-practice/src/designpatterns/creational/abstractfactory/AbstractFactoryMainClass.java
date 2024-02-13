package designpatterns.creational.abstractfactory;

public class AbstractFactoryMainClass {

    public static void main(String[] args) {
        AbstractFactory factory = AbstractFactoryProducer.getFactory(false);
        Profession profession = (Profession) factory.getProfession("Doctor");
        profession.print();
    }
}
