package com.sofka.hotel.domain.usuario.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.domain.usuario.values.UsuarioID;
import com.sofka.hotel.domain.usuario.values.Tipo;

public class AddPedido extends Command {

    private final UsuarioID usuarioID;

    private final Tipo tipo;

    public AddPedido(UsuarioID usuarioID, Tipo tipo ) {

        this.usuarioID = usuarioID;
        this.tipo = tipo;
    }

    public UsuarioID getUsuarioID() {
        return usuarioID;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
