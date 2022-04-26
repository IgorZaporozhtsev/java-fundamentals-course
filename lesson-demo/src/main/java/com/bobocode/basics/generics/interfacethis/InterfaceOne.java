package com.bobocode.basics.generics.interfacethis;

    interface InterfaceOne {

    default void display() {
        this.defaultMethod();
        System.out.println("InterfaceOne method displayed");
    }

    default void defaultMethod() {
        System.out.println("defaultMethod of InterfaceOne called");
    }

    interface InterfaceTwo extends InterfaceOne{
        default void show(){
            this.defaultMethod();
        }
    }

    class ClassOne implements InterfaceTwo {

    }

    class DemoApp {
        public static void main(String[] args) {
            ClassOne one = new ClassOne();
            one.show();
        }

    }
}
