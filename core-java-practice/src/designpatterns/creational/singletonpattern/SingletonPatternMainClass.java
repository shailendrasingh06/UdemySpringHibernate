package designpatterns.creational.singletonpattern;

public class SingletonPatternMainClass {
    public static void main(String[] args) {
        SingletonDemoClass obj1 = SingletonDemoClass.getInstance();
        SingletonDemoClass obj2 = SingletonDemoClass.getInstance();
        SingletonDemoClass obj3 = SingletonDemoClass.getInstance();

        obj1.simpleMethod();
        obj2.simpleMethod();
        obj3.simpleMethod();
    }
}
