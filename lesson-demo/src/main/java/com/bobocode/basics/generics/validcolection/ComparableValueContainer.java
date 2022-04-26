package com.bobocode.basics.generics.validcolection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComparableValueContainer<T extends Comparable<T>> {  // recursive bound
    private T value;

    public ComparableValueContainer(T value) {
        this.value = value;
    }
}
