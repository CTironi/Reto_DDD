package com.sofka.hotel.domain.usuario.events;


import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.usuario.values.Nombre;
import com.sofka.hotel.domain.usuario.values.UsuarioID;

public class UsuarioCreated extends DomainEvent {

    public final UsuarioID usuarioID;
    public final Nombre nombre;

    public UsuarioCreated(UsuarioID usuarioID, Nombre nombre){
        super("com.sofka.hotel.domain.usuario.usuariocreated");
        this.usuarioID = usuarioID;
        this.nombre = nombre;
    }

    public UsuarioID getUsuarioID() {
        return usuarioID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
