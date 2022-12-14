package com.sofka.hotel.domain.recepcionista.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Clase implements ValueObject<String> {
    private final String value;

    public Clase(String value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public String value() {
        return this.value;
    }
}
