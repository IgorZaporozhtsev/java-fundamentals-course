package com.bobocode.basics.generics.with.object;

public class DemoApp {
    public static void main(String[] args) {
        Container integerContainer = new Container(25);

        integerContainer.setValue("Andriy"); // про цю помилку дизнаємлсь тільки на етапі рантайму
        int val = (int) integerContainer.getValue(); //треба кастити
        System.out.println(val);
    }
}
