package com.manom.castingInJava;

public class Main {

    static class Parent {
        Parent() {
            System.out.println("Parent Constructor");
        }

        public void xyz() {
            System.out.println("parent method");
        }

        public void abc() {

        }
    }

        static class Child extends Parent{

            Child() {
                System.out.println("child constructor");
            }

            private void hello(){
                System.out.println("hello there");
            }

            @Override
            public void xyz() {
                System.out.println("child method");
            }
        }

    public static void main(String[] args) {

        String a1 = "abd";
        String a2 = "abd";

        System.out.println(a1.equals(a1));
        Child p1  = (Child) new Parent(); // down casting
        Parent p2  =  new Child(); //upcasting
        p1.xyz();
        p1.abc();
        p1.hello();
        //p1.hello();  // this method is accessible when using "Child p1  = new Child();"
    }

}
