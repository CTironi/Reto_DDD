package com.sofka.hotel.domain.usuario.events;

import co.com.sofka.domain.generic.DomainEvent;

public class UsuarioNotificacion extends DomainEvent {
    private final String messageBody;

    public UsuarioNotificacion(String messageBody) {
        super("com.sofka.hotel.domain.usuario.usuarionotificacion");

        this.messageBody = messageBody;
    }

    public String getMessageBody() {
        return messageBody;
    }
}
