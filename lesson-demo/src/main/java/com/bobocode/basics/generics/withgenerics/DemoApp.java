package com.bobocode.basics.generics.withgenerics;

public class DemoApp {
    public static void main(String[] args) {
        Container<Integer> integerContainer = new Container<Integer>(25);
        int val = integerContainer.getValue();
        System.out.println(val);
    }
}
