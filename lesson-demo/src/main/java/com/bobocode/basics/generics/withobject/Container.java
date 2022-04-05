package com.bobocode.basics.generics.withobject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Container {
    private Object value;

    public Container(Object value) {
        this.value = value;
    }
}
