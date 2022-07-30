package com.sofka.hotel.usuario.events;


import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.usuario.values.Nombre;

public class UsuarioCreated extends DomainEvent {

    private final Nombre nombre;

    public UsuarioCreated(Nombre nombre){
        super("com.sofka.hotel.usuario.usuariocreated");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
