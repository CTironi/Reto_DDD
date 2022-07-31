package com.sofka.hotel.domain.mucama.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Pedidos implements ValueObject<String > {
    private final String value;

    public Pedidos(String value) {
        this.value = Objects.requireNonNull(value);
    }
    @Override
    public String value() {
        return this.value;
    }
}
