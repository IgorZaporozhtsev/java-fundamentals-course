package com.bobocode.basics.generics.recursive.bound;

public class User extends BaseEntity implements Comparable<User> {
    @Override
    public int compareTo(User o) {
        return 0;
    }
}
