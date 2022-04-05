package com.bobocode.basics.generics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Container<T> {
    private T value;

    public Container(T value) {
        this.value = value;
    }
}
