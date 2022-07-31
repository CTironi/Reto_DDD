package com.sofka.hotel.domain.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Origen implements ValueObject<String> {
    private final String value;

    public Origen(String value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public String value() {
        return this.value;
    }
}
