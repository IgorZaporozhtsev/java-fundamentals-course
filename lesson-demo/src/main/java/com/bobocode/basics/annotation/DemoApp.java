package com.bobocode.basics.annotation;

public class DemoApp {
    public static void main(String[] args) {
        var annotations = MagicClass.class.getAnnotations();
        for (var a: annotations) {
            System.out.println(a);
        }

        var annotation = MagicClass.class.getAnnotation(Marker.class);
        System.out.println(annotation.value());


    }
}
