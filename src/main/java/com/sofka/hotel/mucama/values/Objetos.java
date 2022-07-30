package com.sofka.hotel.mucama.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Objetos implements ValueObject<String > {
    private final String value;

    public Objetos(String value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public String value() {
        return this.value;
    }
}
