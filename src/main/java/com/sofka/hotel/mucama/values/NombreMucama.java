package com.sofka.hotel.mucama.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreMucama implements ValueObject<String> {
    private final String value;

    public NombreMucama(String value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public String value() {
        return this.value;
    }
}
