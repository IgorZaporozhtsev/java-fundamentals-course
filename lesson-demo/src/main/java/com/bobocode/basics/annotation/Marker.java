package com.bobocode.basics.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Marker {
    String value() default "Default message";
    //without default will be use "This value of current annotation" as a parameter of @Marker("This value of current annotation") in MagicClass
}
