package com.sofka.hotel.mucama.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Piso implements ValueObject<Integer> {
    private final Integer value;

    public Piso(Integer value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public Integer value() {
        return this.value;
    }
}
