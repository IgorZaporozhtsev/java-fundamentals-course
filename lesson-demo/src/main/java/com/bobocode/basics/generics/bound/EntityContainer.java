package com.bobocode.basics.generics.bound;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityContainer<T extends BaseEntity> { //bound
    private T value;

    public EntityContainer(T value) {
        this.value = value;
    }
}
