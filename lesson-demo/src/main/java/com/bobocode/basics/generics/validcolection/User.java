package com.bobocode.basics.generics.validcolection;

public class User extends ChildEntity implements Comparable<User> {
    @Override
    public int compareTo(User o) {
        return 0;
    }
}
