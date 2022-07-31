package com.sofka.hotel.domain.recepcionista.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreCliente implements ValueObject<String> {
    private final String value;

    public NombreCliente(String value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public String value() {
        return this.value;
    }
}
