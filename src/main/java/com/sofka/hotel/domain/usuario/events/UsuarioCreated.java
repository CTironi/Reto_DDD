package com.sofka.hotel.domain.usuario.events;


import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.usuario.values.Nombre;

public class UsuarioCreated extends DomainEvent {

    private final Nombre nombre;

    public UsuarioCreated(Nombre nombre){
        super("com.sofka.hotel.domain.usuario.usuariocreated");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
