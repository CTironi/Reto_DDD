package com.sofka.hotel.domain.usuario.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.domain.usuario.values.Nombre;
import com.sofka.hotel.domain.usuario.values.UsuarioID;

public class CreateUsuario extends Command {

    private final UsuarioID usuarioID;

    private final Nombre nombre;

    public CreateUsuario(UsuarioID usuarioID, Nombre nombre){
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
