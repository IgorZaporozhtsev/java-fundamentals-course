package com.bobocode.basics.generics.wildcard;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DemoApp {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User());

        //UtilClass.wrongEntity(users);// List<User> it's not List<BaseEntity>
        //that's why we should use method like below

        UtilClass.isValid(users);
        //UtilClass.wrongEntity(users);  // List<User> it's not List<BaseEntity>


        //обмеження знизу
        Predicate<BaseEntity> baseEntityPredicate = entity -> entity.id != null;

        //UtilClass.wrongIsValidPredicate(new User(), baseEntityPredicate); // List<User> it's not List<BaseEntity>
        UtilClass.isValidPredicate(new User(), baseEntityPredicate);


    }
}
