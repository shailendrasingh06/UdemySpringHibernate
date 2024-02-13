package designpatterns.creational.singletonpattern;

public class SingletonDemoClass {

    //    private static SingletonDemoClass obj= new SingletonDemoClass();  //eager loading
    private static SingletonDemoClass obj;  //lazy loading
    private SingletonDemoClass(){
    }
    //get the only object available
    public static SingletonDemoClass getInstance(){
        if(obj == null) {
            obj = new SingletonDemoClass();
            return obj; }
        else
            return obj;
    }

    public void simpleMethod() {
        System.out.println("hashcode of singleton object" + obj);
    }
}
