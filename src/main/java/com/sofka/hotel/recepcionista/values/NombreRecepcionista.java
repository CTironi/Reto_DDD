package com.sofka.hotel.recepcionista.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreRecepcionista implements ValueObject<String> {
    private final String value;

    public NombreRecepcionista(String value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public String value() {
        return this.value;
    }
}
