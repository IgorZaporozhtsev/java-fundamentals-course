package com.bobocode.basics.generics.wildcard;

import java.util.List;
import java.util.function.Predicate;

public class UtilClass {

   static void wrongEntity(List<BaseEntity> entities){

   }

   static void isValid(List<? extends BaseEntity> entities){

   }

   public static boolean wrongIsValidPredicate(User user, Predicate<User> validationPredicate) {
      return validationPredicate.test(user);
   }

   public static boolean isValidPredicate(User user, Predicate<? super User> validationPredicate) {
      return validationPredicate.test(user);
   }
}
