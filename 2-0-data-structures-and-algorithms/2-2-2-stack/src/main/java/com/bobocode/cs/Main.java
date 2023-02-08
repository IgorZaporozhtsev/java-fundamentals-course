package com.bobocode.cs;

public class Main {

    public static void main(String[] args) {
        Foo f = new Foo("f");
        changeReference(f); // It won't change the reference!
        modifyReference(f); // It will modify the object that the reference variable "f" refers to!


    }

    public static void changeReference(Foo a) {
        System.out.println(a);
        Foo b = new Foo("b");
        a = b;
        System.out.println(a);
    }

    public static void modifyReference(Foo c) {
        c.setValue("c");
    }

    static class Foo{
        String value;

        Foo(String value){
            this.value = value;
        }

        public void setValue(String value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Foo{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}
