package com.sofka.hotel.domain.recepcionista.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Monto implements ValueObject<Integer> {
    private final Integer value;

    public Monto(Integer value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public Integer value() {
        return this.value;
    }
}
