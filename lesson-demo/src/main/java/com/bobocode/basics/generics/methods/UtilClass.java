package com.bobocode.basics.generics.methods;

import java.util.List;

public class UtilClass {
    // <T, R> - вказуєм тип в дужках щоб зробити метод generic і якщо будем використовувати
   // T - return type
    static <T> T findMin(List<T> collection){
        T temp = collection.get(0);
      return temp;
    }

    //якщо немає return Type
    //? - байдуже якій тип
    static void printAll(List<?> list){
        list.forEach(System.out::println);
    }

    //також в параметрах метода може бути wildcard
    static void printAllWildCard(List<? extends BaseEntity> list){
        list.forEach(System.out::println);
    }
}
