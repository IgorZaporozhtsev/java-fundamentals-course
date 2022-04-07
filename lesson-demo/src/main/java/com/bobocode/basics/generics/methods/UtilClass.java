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

    //якщо в рамках метода Тип використовується тоді його треба і використовувати в параметрах
    //це приклад з помилкою
    static <T> T usual(List<T> list){
        T variable;
        variable = list.get(0);
        return variable;
    }
    // приклад з помилкою
    static <T> T wrongExample(List<? extends BaseEntity> list){
        T variable = null;
        //variable = list.get(0); // не зрозуміло який тим тому що знак питання
        return variable;
    }

    //це приклад з помилкою
    //wildcard в параметрах метода використовуємо тільки коли немає Типу в рамках методу. Якщо в рамках метода Тип використовується то wildcard не використовуємо
    static <T extends BaseEntity> T wrongExampleSecond(List<T/* extends BaseEntity*/> list){
        T variable = null;
        //variable = list.get(0); // не зрозуміло який тим тому що знак питання
        return variable;
    }

}
