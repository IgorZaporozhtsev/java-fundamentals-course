package com.bobocode.fp;

import java.util.HashMap;

public class MainMap {

    public static void main(String[] args) {
        // create an HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // insert entries to the HashMap
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // recompute the value of Shoes with 10% discount
        int newPrice = prices.compute("Shoes", (key, value) -> value - value * 10/100);
        System.out.println("Discounted Price of Shoes: " + newPrice);

        // print updated HashMap
        System.out.println("Updated HashMap: " + prices);
    }
}
