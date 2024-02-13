package designpatterns.creational.factorymethod;

public class FactoryPatternMainClass {
    public static void main(String[] args){
        ProfessionFactory factory = new ProfessionFactory();
        Profession obj = factory.getProfessionObject("Doctors");
        obj.print();
    }
}
