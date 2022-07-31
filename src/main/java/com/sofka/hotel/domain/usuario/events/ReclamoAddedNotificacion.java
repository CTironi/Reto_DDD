package com.sofka.hotel.domain.usuario.events;

import co.com.sofka.domain.generic.DomainEvent;

public class ReclamoAddedNotificacion extends DomainEvent {
    private final String message;

    public ReclamoAddedNotificacion(String message) {
        super("com.sofka.hotel.domain.usuario.usuarioaddednotificacion");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
