package com.bobocode.basics.generics.validcolection;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class DemoApp {
    public static void main(String[] args) {

        User user1 = new  User();
        User user2 = new  User();
        user2.id = 11L;
        user2.name = "Jane";
        User user3 = new  User();
        user3.id = 11L;
        user3.name = "Jane";
        User user4 = new  User();
        List<User> users = List.of(
                user1,
                user2,
                user3,
                user4
        );

        Predicate<ChildEntity> nameValidationPredicate =  entity ->
                Optional.ofNullable(entity)
                        .map(BaseEntity::getName)
                        .map(isJaneName())
                        .orElse(false);

        Predicate<BaseEntity> notNullIdValidationPredicate = entity -> entity.id != null;

        boolean validAnyMatch = isValidAnyMatchCollection(users, nameValidationPredicate);
        System.out.println(validAnyMatch);

        boolean validAllMatch = isValidAllMatchCollection(users, notNullIdValidationPredicate);
        System.out.println(validAllMatch);
    }

    private static Function<String, Boolean> isJaneName() {
        return name -> name.startsWith("Jane");
    }

    public static boolean isValidAnyMatchCollection(Collection<? extends ChildEntity> entities,
                                                    Predicate<? super ChildEntity> validationPredicate){
        //entities.add(new ChildEntity()); // - не работает так
        return entities.stream().anyMatch(validationPredicate);
    }

    public static boolean isValidAllMatchCollection(Collection< ? extends BaseEntity > entities,
                                                    Predicate<? super BaseEntity> validationPredicate){
        return entities.stream().allMatch(validationPredicate);
    }



}
