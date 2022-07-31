package com.sofka.hotel.domain.usuario.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Fecha implements ValueObject<LocalDate> {
    private final LocalDate day;

    public Fecha( LocalDate day) {
        this.day = Objects.requireNonNull(day);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fecha)) return false;
        Fecha fecha = (Fecha) o;
        return Objects.equals(day, fecha.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day);
    }

    @Override
    public LocalDate value() {
        return day;
    }

}
