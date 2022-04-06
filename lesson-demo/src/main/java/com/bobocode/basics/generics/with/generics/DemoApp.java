package com.bobocode.basics.generics.with.generics;

public class DemoApp {
    public static void main(String[] args) {
        Container<Integer> integerContainer = new Container<>(25);
        //integerContainer.setValue("Andriy"); // про цю помилку бачимо на етапі компіляції
        int val = integerContainer.getValue();
        System.out.println(val);
    }
}
