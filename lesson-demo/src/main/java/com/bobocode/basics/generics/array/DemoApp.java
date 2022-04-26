package com.bobocode.basics.generics.array;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DemoApp {
    public static void main(String[] args) {
       //Коваріантність
       Integer[] intArray = {1,3,54,23,44,21};
       Number[] numbers = intArray;

       List<Integer> integerList = new ArrayList<>();
      // List<Number> numberList = integerList; // всі Дженеріки інваріантні


    }
}
