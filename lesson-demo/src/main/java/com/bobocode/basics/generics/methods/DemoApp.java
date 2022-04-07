package com.bobocode.basics.generics.methods;

public class DemoApp {
    public static void main(String[] args) {
        //EntityContainer<Integer> integerContainer = new EntityContainer<Integer>(25);
        // <Integer> - не підходить тому що потрібно те що насліжується від BaseEntity
        ComparableValueContainer<User> integerContainer = new ComparableValueContainer<>(new User());

        User val = integerContainer.getValue();
        System.out.println(val);
    }
}
